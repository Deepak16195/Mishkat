package mishkat.mdrd.com.mishkat.EnteryPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mishkat.mdrd.com.mishkat.EnteryPages.Model.SplashModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */


public class SplashActivity extends AppCompatActivity {

    String Userid;
    Intent i;
    ImageView ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView = findViewById(R.id.Logo);
        GetSpalsh();

        //        final int id =SharePrefarence.getmInstance(this).getUserId();
//        if (!(id==0)) {
//            i= new Intent(this,DashBoardActivity.class);//DashBoardActivity
//
//        }else {
//            i= new Intent(this,IntroActivity.class);
//        }
        i = new Intent(this, AdsActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();
    }

    private void GetSpalsh() {
        API.getAPIService().Getsplash().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SplashModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(SplashModel response) {
                        if (response.getStatus()) {
                            if(response.getResult().size() > 0)
                            {
                                Glide.with(SplashActivity.this).load(response.getResult().get(0).toString()).placeholder(R.drawable.logo).error(R.drawable.logo).into(ImageView);
                            }
                           }
                    }
                });
    }
}
