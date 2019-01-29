package mishkat.mdrd.com.mishkat.DeskBoardsPages;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import mishkat.mdrd.com.mishkat.Adapters.ItemListAdapter;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class Item_list_Activity extends AppCompatActivity {

    ImageView popup;
    Spinner Sp_country;
    List<String> cuntryArray = new ArrayList<>();
    List<VendorDetailModel.ResultEntity> VendorDetailDeta = new ArrayList<>();
    RecyclerView VendorDetails;
    public static int Vanderid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_);
        VendorDetails = findViewById(R.id.Row1);
        GetVendorDetail(Vanderid+"");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        popup = findViewById(R.id.popup);
        cuntryArray = new ArrayList<>();
        cuntryArray.add("Category");
        cuntryArray.add("Abdullah Al Salem");
        cuntryArray.add("Adaitiya");
        cuntryArray.add("Bneid Al Qar");
        cuntryArray.add("Daiya");
        cuntryArray.add("Deepak");

        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(Item_list_Activity.this, R.style.BottomSheetDialog);
                dialog.setContentView(R.layout.lay_item_list);
                dialog.show();
                Sp_country = dialog.findViewById(R.id.sp_country);
               /* ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                        SearchActivity.this, R.layout.spinner_item, cuntryArray);
                adapter2.setDropDownViewResource(R.layout.spinner_itemc);*/

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                        Item_list_Activity.this, R.layout.spinner_item, cuntryArray);
                adapter2.setDropDownViewResource(R.layout.spinner_itemc);
                Sp_country.setAdapter(adapter2);

            }
        });
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
                            VendorDetailDeta.add(response.getResult());
                            VendorDetails.setAdapter(new ItemListAdapter(Item_list_Activity.this,VendorDetailDeta));
                        }
                    }
                });
    }
}
