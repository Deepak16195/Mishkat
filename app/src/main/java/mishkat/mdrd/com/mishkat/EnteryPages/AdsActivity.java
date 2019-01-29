package mishkat.mdrd.com.mishkat.EnteryPages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import mishkat.mdrd.com.mishkat.R;

public class AdsActivity extends AppCompatActivity {

    private ImageView Ads;
    private ImageView Adsclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        initView();


    }

    private void initView() {
        Ads = (ImageView) findViewById(R.id.Ads);
        Adsclose = (ImageView) findViewById(R.id.Adsclose);
    }
}
