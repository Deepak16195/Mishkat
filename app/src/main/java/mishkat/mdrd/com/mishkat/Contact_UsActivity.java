package mishkat.mdrd.com.mishkat;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import mishkat.mdrd.com.mishkat.Data.SharePrefarence;
import mishkat.mdrd.com.mishkat.EnteryPages.LoginActivity;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.LoginModel;
import mishkat.mdrd.com.mishkat.EnteryPages.RegisterActivity;
import mishkat.mdrd.com.mishkat.Model.ContectModel;
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

public class Contact_UsActivity extends AppCompatActivity {

    private LinearLayout linner2;
    private ImageView imageView2;
    private LinearLayout linearLayout2;
    private TextInputEditText FName;
    private TextInputEditText LName;
    private TextInputEditText Mobile;
    private TextInputEditText Email;
    private EditText notesBox;
    private Button BtSubmit;
    String mFNmae, mLNmae, mEmail, mPhone, mcommnts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);
        initView();


        BtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFNmae = FName.getText().toString().trim();
                mLNmae = LName.getText().toString().trim();
                mEmail = Email.getText().toString().trim();
                mPhone = Mobile.getText().toString().trim();
                mcommnts = notesBox.getText().toString().trim();
                if (UtilsTool.isInternetOn(Contact_UsActivity.this)) {
                    if (!UtilsTool.isEmpty(FName) && !UtilsTool.isEmpty(LName) && !UtilsTool.isEmpty(Email) && !UtilsTool.isEmpty(Mobile) && !UtilsTool.isEmpty(notesBox)) {
                        if (checkEmailValidation(Email)) {
                            if (checkMobileValidation(Mobile)) {
                                UtilsTool.showProgressDialog(Contact_UsActivity.this);
                                ContactUs(mFNmae, mLNmae, mPhone,mEmail, mcommnts);
                            }
                        }
                    } else {
                        UtilsTool.ChackNull(FName);
                        UtilsTool.ChackNull(LName);
                        UtilsTool.ChackNull(Email);
                        UtilsTool.ChackNull(Mobile);
                        UtilsTool.ChackNull(notesBox);
                    }
                } else {
                    UtilsTool.customMessage(Contact_UsActivity.this, "Please check your Internet connection!");
                }

            }
        });


    }


    private void ContactUs(String fname, String lname, String mobile, String mail, String comments) {
        API.getAPIService().ContactUs(SharePrefarence.ENGLISH,fname, lname, mobile, mail, comments).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ContectModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.hideProgressDialog();
                        UtilsTool.custoAlert(Contact_UsActivity.this, e.getMessage());
                    }

                    @Override
                    public void onNext(ContectModel response) {
                        UtilsTool.hideProgressDialog();
                        if (response.getStatus()) {
                            UtilsTool.custoAlert(Contact_UsActivity.this, "Thank you for contacting us.");
                            finish();

                        }
                    }
                });
    }

    private void initView() {
        linner2 = (LinearLayout) findViewById(R.id.linner2);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        FName = (TextInputEditText) findViewById(R.id.F_name);
        LName = (TextInputEditText) findViewById(R.id.L_name);
        Mobile = (TextInputEditText) findViewById(R.id.Mobile);
        Email = (TextInputEditText) findViewById(R.id.Email);
        notesBox = (EditText) findViewById(R.id.notes_box);
        BtSubmit = (Button) findViewById(R.id.Bt_Submit);
    }
}
