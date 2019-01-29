package mishkat.mdrd.com.mishkat.EnteryPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mishkat.mdrd.com.mishkat.Data.SharePrefarence;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.DeskboardActivity;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.SignupModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.VerifyModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.UtilsTools.UtilsTool;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static mishkat.mdrd.com.mishkat.UtilsTools.UtilsTool.checkEmailValidation;
import static mishkat.mdrd.com.mishkat.UtilsTools.UtilsTool.checkMobileValidation;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class RegisterActivity extends AppCompatActivity {

    Button Register, btnAccept;
    Intent i;
    TextView terms;
    private BottomSheetBehavior mBottomSheetBehavior1;
    BottomSheetDialog dialog;
    private ImageView imageView2;
    private LinearLayout linearLayout2;
    private TextInputEditText RegisterFName;
    private TextInputEditText RegisterLName;
    private TextInputEditText RegisterEmail;
    private TextInputEditText RegisterMobile;
    private Button RegisterGetCode;
    private TextInputEditText RegisterVarification;
    private CheckBox check;
    private TextView textView;
    boolean bl;
    int Userid;
    String Code;
    String mFNmae, mLNmae, mEmail, mPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Register = findViewById(R.id.Register);
        terms = findViewById(R.id.terms);
        initView();
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BottomSheetDialog(RegisterActivity.this, R.style.BottomSheetDialog);
                dialog.setContentView(R.layout.lay_terms);
                dialog.show();
                btnAccept = dialog.findViewById(R.id.btnAccept);
                btnAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        RegisterGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFNmae = RegisterFName.getText().toString().trim();
                mLNmae = RegisterLName.getText().toString().trim();
                mEmail = RegisterEmail.getText().toString().trim();
                mPhone = RegisterMobile.getText().toString().trim();
               /* String mPassword = signUpPasswordEt.getText().toString().trim();
                String mRePassword = signUpConfirmPasswordEt.getText().toString().trim();*/
                if (UtilsTool.isInternetOn(RegisterActivity.this)) {
                    if (!UtilsTool.isEmpty(RegisterFName) && !UtilsTool.isEmpty(RegisterLName) && !UtilsTool.isEmpty(RegisterEmail) && !UtilsTool.isEmpty(RegisterMobile)) {
                        if (checkEmailValidation(RegisterEmail)) {
                            if (checkMobileValidation(RegisterMobile)) {
                                UtilsTool.showProgressDialog(RegisterActivity.this);
                                SignupData(mFNmae, mLNmae, mEmail, mPhone);
                            }
                        }
                    } else {
                        UtilsTool.ChackNull(RegisterFName);
                        UtilsTool.ChackNull(RegisterLName);
                        UtilsTool.ChackNull(RegisterEmail);
                        UtilsTool.ChackNull(RegisterMobile);
                    }
                } else {
                    UtilsTool.customMessage(RegisterActivity.this, "Please check your Internet connection!");
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UtilsTool.isInternetOn(RegisterActivity.this)) {
                    if (!UtilsTool.isEmpty(RegisterFName) && !UtilsTool.isEmpty(RegisterLName) && !UtilsTool.isEmpty(RegisterEmail) && !UtilsTool.isEmpty(RegisterMobile) && !UtilsTool.isEmpty(RegisterLName)) {
                        if (checkEmailValidation(RegisterEmail)) {
                            if (checkMobileValidation(RegisterMobile)) {
                                UtilsTool.showProgressDialog(RegisterActivity.this);
                                mPhone = RegisterMobile.getText().toString().trim();
                                VerifyNumber(mPhone, Code, "123456789");
                            }
                        }
                    } else {
                        UtilsTool.ChackNull(RegisterFName);
                        UtilsTool.ChackNull(RegisterLName);
                        UtilsTool.ChackNull(RegisterLName);
                        UtilsTool.ChackNull(RegisterLName);
                    }
                } else {
                    UtilsTool.customMessage(RegisterActivity.this, "Please check your Internet connection!");
                }
            }
        });


       /* i = new Intent(RegisterActivity.this, DeskboardActivity.class);
        startActivity(i);*/


    }

    private void initView() {
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        RegisterFName = (TextInputEditText) findViewById(R.id.Register_FName);
        RegisterLName = (TextInputEditText) findViewById(R.id.Register_LName);
        RegisterEmail = (TextInputEditText) findViewById(R.id.Register_Email);
        RegisterMobile = (TextInputEditText) findViewById(R.id.Register_Mobile);
        RegisterGetCode = (Button) findViewById(R.id.Register_GetCode);
        RegisterVarification = (TextInputEditText) findViewById(R.id.Register_Varification);
        check = (CheckBox) findViewById(R.id.check);
        textView = (TextView) findViewById(R.id.textView);
    }

    private void SignupData(String FName, String LName, String mEmail, String mPhone) {
        API.getAPIService().SaveRegister(SharePrefarence.ENGLISH, FName, LName, mEmail, mPhone).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SignupModel>() {
                    @Override
                    public void onCompleted() {
                        UtilsTool.hideProgressDialog();
                        Log.e("retro_error", "Succesfull");
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.hideProgressDialog();
                        Log.e("retro_error", e.toString());
                    }

                    @Override
                    public void onNext(SignupModel response) {
                        UtilsTool.hideProgressDialog();
                        if (response.isStatus()) {
                            RegisterVarification.setText(response.getResult().getCode());
                            Code = response.getResult().getCode();
                               /* Intent intent = new Intent(getApplicationContext(), OtpActivity.class);
                                intent.putExtra("MobileNo", mPhone+"");
                                intent.putExtra("type", "Donothing");
                                finish();
                                startActivity(intent);*/

                        } else {
                            UtilsTool.hideProgressDialog();

                            UtilsTool.custoAlert(RegisterActivity.this, "User is already registered...");

                        }

                    }
                });
    }


    private void VerifyNumber(String mobile, String code, String device_id) {
        API.getAPIService().VerifyRegister(mobile, code, device_id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VerifyModel>() {
                    @Override
                    public void onCompleted() {
                        UtilsTool.hideProgressDialog();

                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.hideProgressDialog();
                        Log.e("retro_error", e.toString());
                    }

                    @Override
                    public void onNext(VerifyModel response) {
                        UtilsTool.hideProgressDialog();
                        if (response.getStatus()) {
                            Userid = Integer.valueOf(response.getResult().getId());
                            bl = SharePrefarence.getmInstance(getApplicationContext())
                                    .SaveDataLocal(
                                            Userid,
                                            response.getResult().getF_name() + "" + response.getResult().getL_name(),
                                            response.getResult().getEmail() + "",
                                            response.getResult().getMobile() + ""
                                    );
                            if (bl) {
                                i = new Intent(RegisterActivity.this, DeskboardActivity.class);
                                startActivity(i);
                            } else {
                                UtilsTool.custoAlert(RegisterActivity.this, "Something Worng?");
                            }


                        }
                    }
                });
    }

}
