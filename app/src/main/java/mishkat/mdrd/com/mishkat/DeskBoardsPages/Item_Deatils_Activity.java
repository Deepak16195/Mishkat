package mishkat.mdrd.com.mishkat.DeskBoardsPages;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import mishkat.mdrd.com.mishkat.Adapters.ItemDetilsviewpage;
import mishkat.mdrd.com.mishkat.CartActivity;
import mishkat.mdrd.com.mishkat.Model.Singer;
import mishkat.mdrd.com.mishkat.R;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class Item_Deatils_Activity extends AppCompatActivity {

    Button Bt_Addtocart;
    Intent i;
    ViewPager viewPager;
    ItemDetilsviewpage adapter;
    List<Singer> singers;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int dotscount;
    private ImageView[] dots;
    LinearLayout sliderDotspanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__deatils_);
        Bt_Addtocart = findViewById(R.id.Bt_Addtocart);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        Bt_Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Item_Deatils_Activity.this, CartActivity.class);
                startActivity(i);
            }
        });
        singers = new ArrayList<>();
        singers.add(new Singer(R.drawable.tech, "Riya", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.tech, "Riya Passaranan", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.image, "Riya Mi", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.face2, "Riya ", "Hôm này trời đẹp"));
        adapter = new ItemDetilsviewpage(this, singers);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int position) {


            }
        });

    }



}
