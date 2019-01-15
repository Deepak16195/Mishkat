package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */


public class SplashActivity extends AppCompatActivity {

    String Userid;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //        final int id =SharePrefarence.getmInstance(this).getUserId();
//        if (!(id==0)) {
//            i= new Intent(this,DashBoardActivity.class);//DashBoardActivity
//
//        }else {
//            i= new Intent(this,IntroActivity.class);
//        }
        i = new Intent(this, LoginActivity.class);
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
}
