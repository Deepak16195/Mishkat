package mishkat.mdrd.com.mishkat.AboutApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import mishkat.mdrd.com.mishkat.Model.AboutUsModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class PrivacyActivity extends AppCompatActivity {

    private LinearLayout show;
    private ImageView imageView2;
    private ScrollView linearLayout2;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        initView();
        Getprivacypolicy();
    }

    private void initView() {
        show = (LinearLayout) findViewById(R.id.show);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        linearLayout2 = (ScrollView) findViewById(R.id.linearLayout2);
        content = (TextView) findViewById(R.id.content);
    }

    private void Getprivacypolicy() {
        API.getAPIService().Getprivacypolicy().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AboutUsModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(AboutUsModel response) {
                        if (response.getStatus()) {

                            content.setText(response.getResult().getContent()+"");

                        }
                    }
                });
    }
}
