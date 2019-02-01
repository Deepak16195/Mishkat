package mishkat.mdrd.com.mishkat.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import mishkat.mdrd.com.mishkat.Data.SharePrefarence;
import mishkat.mdrd.com.mishkat.Address.My_AddressActivity;
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

public class ProfileActivity extends AppCompatActivity {

    Button Bt_myAddress;
    Intent intent;
    int Userid;
    private LinearLayout linner2;
    private ImageView imageView2;
    private LinearLayout linearLayout2;
    private TextInputEditText Fname;
    private TextInputEditText Lname;
    private TextInputEditText Email;
    private TextInputEditText Number;
    private Button EditProfile;
    private Button BtMyAddress;
    String mFNmae, mLNmae, mEmail, mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        Userid = SharePrefarence.getmInstance(getApplication()).getUserId();
        if (UtilsTool.isInternetOn(ProfileActivity.this)) {
            GetProfileData(Userid + "");
        } else {
            UtilsTool.customMessage(ProfileActivity.this, "Please check your Internet connection!");
        }

        Bt_myAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ProfileActivity.this, My_AddressActivity.class);
                startActivity(intent);
            }
        });

        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFNmae = Fname.getText().toString().trim();
                mLNmae = Lname.getText().toString().trim();
                mEmail = Email.getText().toString().trim();
                mPhone = Number.getText().toString().trim();
               /* String mPassword = signUpPasswordEt.getText().toString().trim();
                String mRePassword = signUpConfirmPasswordEt.getText().toString().trim();*/
                if (UtilsTool.isInternetOn(ProfileActivity.this)) {
                    if (!UtilsTool.isEmpty(Fname) && !UtilsTool.isEmpty(Lname) && !UtilsTool.isEmpty(Lname) && !UtilsTool.isEmpty(Lname)) {
                        if (checkEmailValidation(Email)) {
                            if (checkMobileValidation(Number)) {
                                UtilsTool.showProgressDialog(ProfileActivity.this);
                                UpdateProfile(Userid + "", mFNmae, mLNmae, mEmail, mPhone);
                            }
                        }
                    } else {
                        UtilsTool.ChackNull(Fname);
                        UtilsTool.ChackNull(Lname);
                        UtilsTool.ChackNull(Lname);
                        UtilsTool.ChackNull(Lname);
                    }
                } else {
                    UtilsTool.customMessage(ProfileActivity.this, "Please check your Internet connection!");
                }

            }
        });


    }


    private void GetProfileData(String Userid) {
        UtilsTool.showProgressDialog(ProfileActivity.this);
        API.getAPIService().GetProfile(SharePrefarence.ENGLISH, Userid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProfileModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.hideProgressDialog();
                        Log.e("retro_error", e.toString());
                    }

                    @Override
                    public void onNext(ProfileModel response) {
                        UtilsTool.hideProgressDialog();
                        if (response.getStatus()) {

                            Fname.setText(response.getResult().getF_name() + " ");
                            Lname.setText(response.getResult().getL_name() + " ");
                            Email.setText(response.getResult().getEmail() + " ");
                            Number.setText(response.getResult().getMobile() + " ");


                        }
                    }
                });
    }

    private void initView() {
        Bt_myAddress = findViewById(R.id.Bt_myAddress);
        linner2 = (LinearLayout) findViewById(R.id.linner2);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        Fname = (TextInputEditText) findViewById(R.id.Fname);
        Lname = (TextInputEditText) findViewById(R.id.Lname);
        Email = (TextInputEditText) findViewById(R.id.Email);
        Number = (TextInputEditText) findViewById(R.id.Number);
        EditProfile = (Button) findViewById(R.id.Edit_profile);
        BtMyAddress = (Button) findViewById(R.id.Bt_myAddress);
    }


    private void UpdateProfile(String Userid, String f_name, String Lname, String Mobile, String Email) {
        API.getAPIService().UpdateProfile(SharePrefarence.ENGLISH, Userid, f_name, Lname, Mobile, Email).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProfileModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.hideProgressDialog();
                        Log.e("retro_error", e.toString());
                    }

                    @Override
                    public void onNext(ProfileModel response) {
                        UtilsTool.hideProgressDialog();

                        if (response.getStatus()) {

                            UtilsTool.custoAlert(ProfileActivity.this, "Profile Updated");


                        }
                    }
                });
    }


}
