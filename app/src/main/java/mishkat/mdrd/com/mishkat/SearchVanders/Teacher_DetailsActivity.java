package mishkat.mdrd.com.mishkat.SearchVanders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import mishkat.mdrd.com.mishkat.Adapters.TeacherListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.VanderCatsListAdapter;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.VendorDetailModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.SearchVanders.Models.GetAllVenderModel;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */


public class Teacher_DetailsActivity extends AppCompatActivity {
    RecyclerView verticalRecycle2;
    private List<VendorDetailModel.CategoriesEntity> CategoriesData = new ArrayList<>();
    private RoundedImageView Banner;
    private RoundedImageView VanderLogo;
    private LinearLayout row1;
    private TextView vandername;
    private MaterialRatingBar rating;
    private TextView text;
    private TextView AboutMe;
    private ImageButton fb;
    private ImageButton snap;
    private ImageButton intra;
    private ImageButton share;
    private ImageButton fav;
    private RecyclerView Row1;
    List<VendorDetailModel.ResultEntity> VendorDetailDeta = new ArrayList<>();
    RecyclerView VendorDetails;
    public static int Vanderid;
    private TextView MiniOrder;
    private TextView Openstatus;
    private TextView DTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__details);
       // GetAllVenderData();
        verticalRecycle2 = findViewById(R.id.Row1);
        initView();
        GetVendorDetail(Vanderid + "");


    }

    private void GetAllVenderData() {
        API.getAPIService().GetAllVender().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetAllVenderModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(GetAllVenderModel response) {
                        if (response.getStatus()) {
                            if (response.getResult().size() > 0) {
                              /*  AllVendeData = response.getResult();
                                verticalRecycle2.setAdapter(new TeacherListAdapter(Teacher_DetailsActivity.this, AllVendeData));*/
                            }
                        }
                    }
                });
    }

    private void initView() {
        Banner = (RoundedImageView) findViewById(R.id.Banner);
        VanderLogo = (RoundedImageView) findViewById(R.id.VanderLogo);
        row1 = (LinearLayout) findViewById(R.id.row1);
        vandername = (TextView) findViewById(R.id.vandername);
        rating = (MaterialRatingBar) findViewById(R.id.rating);
        text = (TextView) findViewById(R.id.text);
        AboutMe = (TextView) findViewById(R.id.About_me);
        fb = (ImageButton) findViewById(R.id.fb);
        snap = (ImageButton) findViewById(R.id.snap);
        intra = (ImageButton) findViewById(R.id.intra);
        share = (ImageButton) findViewById(R.id.share);
        fav = (ImageButton) findViewById(R.id.fav);
        Row1 = (RecyclerView) findViewById(R.id.Row1);
        MiniOrder = (TextView) findViewById(R.id.Mini_Order);
        Openstatus = (TextView) findViewById(R.id.Openstatus);
        DTime = (TextView) findViewById(R.id.D_Time);
    }


    private void GetVendorDetail(String Userid) {
        API.getAPIService().GetVendorDetails(Userid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VendorDetailModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(VendorDetailModel response) {
                        if (response.getStatus()) {
                            vandername.setText(response.getResult().getName());
                            MiniOrder.setText("Minimum Order : " + response.getResult().getMin_order() + "");
                            DTime.setText("Delivery Time: " + response.getResult().getDelivery_time() + "");
                            rating.setRating(Integer.valueOf(response.getResult().getRate()));
                            Glide.with(Teacher_DetailsActivity.this).load(response.getResult().getLogo()).placeholder(R.drawable.tlogo).error(R.drawable.tlogo).into(VanderLogo );
                            Glide.with(Teacher_DetailsActivity.this).load(response.getResult().getBanner()).placeholder(R.drawable.tech).error(R.drawable.tech).into(Banner);
                            String Open = response.getResult().getOpen_status();
                            if (Open.equalsIgnoreCase("1")) {
                                Openstatus.setText("Close");
                            }
                            CategoriesData = response.getResult().getCategories();
                            verticalRecycle2.setAdapter(new VanderCatsListAdapter(Teacher_DetailsActivity.this, CategoriesData));


                        }
                    }
                });
    }
}
