package mishkat.mdrd.com.mishkat.EnteryPages;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mishkat.mdrd.com.mishkat.Data.SharePrefarence;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.DeskboardActivity;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.LoginModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.VerifyModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.UtilsTools.UtilsTool;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class LoginActivity extends AppCompatActivity {

    TextView Createnew;
    Button Login;
    Intent i;
    EditText mobile;
    boolean bl;
    int Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Createnew = findViewById(R.id.Createnew);
        Login = findViewById(R.id.Login);
        mobile = findViewById(R.id.mobile);
        Createnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ip = UtilsTool.getDeviceMacAddress();

                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo wInfo = wifiManager.getConnectionInfo();
                String macAddress = wInfo.getMacAddress();
                String mPhone = mobile.getText().toString().trim();
                if (UtilsTool.isInternetOn(LoginActivity.this)) {
                    if (!UtilsTool.isEmpty(mobile)) {
                        if (UtilsTool.checkMobileValidation(mobile)) {
                            {
                                LoginUser(SharePrefarence.ENGLISH, mobile.getText().toString());
                            }
                        }
                    } else {
                        if (mPhone == null || mPhone.equalsIgnoreCase("null") || mPhone.length() == 0) {
                            mobile.setError("Cannot be empty !");
                        }
                    }

                } else {
                    UtilsTool.customMessage(LoginActivity.this, "Please check your Internet connection!");
                }

            }
        });


    }

    private void LoginUser(String lang, String mobile) {
        API.getAPIService().LoginUser(lang, mobile).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.custoAlert(LoginActivity.this, e.toString());

                    }
                    @Override
                    public void onNext(LoginModel response) {
                        if (response.getStatus()) {
                            SharePrefarence.getmInstance(LoginActivity.this).setMobile(response.getResult().getMobile());
                            String Code = response.getResult().getCode();
                            VerifyNumber(response.getResult().getMobile().toString(), response.getResult().getCode().toString(), "123456789");
                        }
                    }
                });
    }


    private void VerifyNumber(String mobile, String code, String device_id) {
        UtilsTool.showProgressDialog(LoginActivity.this);
        API.getAPIService().VerifyRegister(mobile, code, device_id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VerifyModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.custoAlert(LoginActivity.this, e.getMessage());
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
                                i = new Intent(LoginActivity.this, DeskboardActivity.class);
                                startActivity(i);
                            } else {
                                UtilsTool.custoAlert(LoginActivity.this, "Something Worng?");
                            }


                        }
                    }
                });
    }


}
