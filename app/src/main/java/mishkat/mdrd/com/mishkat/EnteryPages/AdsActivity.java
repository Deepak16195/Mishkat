package mishkat.mdrd.com.mishkat.EnteryPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mishkat.mdrd.com.mishkat.EnteryPages.Model.AdsModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.SplashModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AdsActivity extends AppCompatActivity {

    private ImageView Ads;
    private ImageView Adsclose;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        initView();
        GetAds();
        Adsclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(AdsActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }

    private void initView() {
        Ads = (ImageView) findViewById(R.id.Ads);
        Adsclose = (ImageView) findViewById(R.id.Adsclose);
    }

    private void GetAds() {
        API.getAPIService().GetAds().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AdsModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(AdsModel response) {
                        if (response.getStatus()) {
                            if (response.getResult().size() > 0) {
                                Glide.with(AdsActivity.this).load(response.getResult().get(0).toString()).placeholder(R.drawable.logo).error(R.drawable.logo).into(Ads);
                            }
                        }
                    }
                });
    }
}
