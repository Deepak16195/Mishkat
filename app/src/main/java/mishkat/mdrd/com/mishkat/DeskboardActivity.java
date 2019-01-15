package mishkat.mdrd.com.mishkat;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mishkat.mdrd.com.mishkat.Adapters.Adapterviewpage;
import mishkat.mdrd.com.mishkat.Adapters.TeacherListAdapter;
import mishkat.mdrd.com.mishkat.Model.Singer;
import mishkat.mdrd.com.mishkat.banner.BannerView;

import static android.widget.Toast.*;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class DeskboardActivity extends AppCompatActivity {


    TextView Category, mainDesk, tx_profile, tx_Favouraite, Tx_Orderhistory, Tx_contactus, Tx_terms, Tx_privacy, Tx_Aboutus, Tx_Cart;
    AlertDialog dialog;
    Button Search;
    Intent i;
    ViewPager viewPager;
    Adapterviewpage adapter;
    List<Singer> singers;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ImageView acv_drowmenu, Cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskboard);
        Category = findViewById(R.id.Category);
        Search = findViewById(R.id.Search);
        Cart = findViewById(R.id.Cart);
        mainDesk = findViewById(R.id.mainDesk);
        /* initViews();*/
        RecyclerView verticalRecycle2 = findViewById(R.id.Row1);
        verticalRecycle2.setAdapter(new TeacherListAdapter());
        Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlterdilogCreation();
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DeskboardActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(DeskboardActivity.this, CartActivity.class);
                startActivity(i);
            }
        });


        mainDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(DeskboardActivity.this, R.style.BottomSheetDialog);
                dialog.setContentView(R.layout.lay_maindesk);
                dialog.show();
                tx_profile = dialog.findViewById(R.id.tx_profile);
                tx_Favouraite = dialog.findViewById(R.id.tx_Favouraite);
                Tx_Orderhistory = dialog.findViewById(R.id.Tx_Orderhistory);
                Tx_contactus = dialog.findViewById(R.id.Tx_contactus);
                Tx_terms = dialog.findViewById(R.id.Tx_terms);
                Tx_privacy = dialog.findViewById(R.id.Tx_privacy);
                Tx_Aboutus = dialog.findViewById(R.id.Tx_Aboutus);
                Tx_Cart = dialog.findViewById(R.id.Tx_Cart);
                tx_profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, ProfileActivity.class);
                        startActivity(i);
                    }
                });
                tx_Favouraite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, My_FavouriteActivity.class);
                        startActivity(i);
                    }
                });
                Tx_Orderhistory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, OrderHistoryActivity.class);
                        startActivity(i);
                    }
                });
                Tx_terms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, TermsandconditionsActivity.class);
                        startActivity(i);
                    }
                });

                Tx_privacy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, PrivacyActivity.class);
                        startActivity(i);
                    }
                });
                Tx_Cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, CartActivity.class);
                        startActivity(i);
                    }
                });


                Tx_contactus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, Contact_UsActivity.class);
                        startActivity(i);
                    }
                });
                Tx_Aboutus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(DeskboardActivity.this, AboutUsActivity.class);
                        startActivity(i);
                    }
                });


            }
        });


        singers = new ArrayList<>();
        singers.add(new Singer(R.drawable.tech, "Riya", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.tech, "Riya Passaranan", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.image, "Riya Mi", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.face2, "Riya ", "Hôm này trời đẹp"));
        adapter = new Adapterviewpage(this, singers);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(20, 0, 30, 0);
        Integer[] color_temp = {getResources().getColor(R.color.white),
                getResources().getColor(R.color.almostTransparentColor),
                getResources().getColor(R.color.almostTransparentColor),
                getResources().getColor(R.color.almostTransparentColor)};
        colors = color_temp;
        //  viewPager.setCurrentItem(1);
       /* viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });*/


    }

     /*  private void initViews() {
        List<BannerView.BannerItem> bannerItems = new ArrayList<>();
        BannerView.BannerItem item1 = new BannerView.BannerItem("First Step", "http://2017.repairingtheruins.org/wp-content/uploads/2016/12/chalkboard_slider.jpg");
        BannerView.BannerItem item2 = new BannerView.BannerItem("second Step", "http://2017.repairingtheruins.org/wp-content/uploads/2016/12/chalkboard_slider.jpg");
        bannerItems.add(item1);
        bannerItems.add(item2);
        bannerItems.add(item1);
        bannerItems.add(item2);
        BannerView bannerView = (BannerView) findViewById(R.id.banner);
        bannerView.setTitleEnabled(true);
        bannerView.setBannerItems(bannerItems);
        bannerView.startLoop();
        bannerView.setOnItemClickListener(new BannerView.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                makeText(getApplicationContext(), "You click " + String.valueOf(position), LENGTH_SHORT).show();
            }
        });

        bannerView.setImageLoadder(new BannerView.ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Glide.with(imageView.getContext())
                        .load(url)
                        .placeholder(R.drawable.photo_holder_72dp)
                        .dontAnimate()
                        .dontTransform()
                        .into(imageView);
            }
        });
    }*/

    public void AlterdilogCreation() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(DeskboardActivity.this);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        dialog = alert.create();
        dialog.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        // Set the alert dialog window width and height
        // Set alert dialog width equal to screen width 90%
        // int dialogWindowWidth = (int) (displayWidth * 0.9f);
        // Set alert dialog height equal to screen height 90%
        // int dialogWindowHeight = (int) (displayHeight * 0.9f);
        // Set alert dialog width equal to screen width 70%
        int dialogWindowWidth = (int) (displayWidth * 0.81f);
        // Set alert dialog height equal to screen height 70%
        //int dialogWindowHeight = (int) (displayHeight * 0.5f);
        // Set the width and height for the layout parameters
        // This will bet the width and height of alert dialog
        layoutParams.width = dialogWindowWidth;
        //  layoutParams.height = dialogWindowHeight;
        // Apply the newly created layout parameters to the alert dialog window
        dialog.getWindow().setAttributes(layoutParams);


    }

    ;
}
