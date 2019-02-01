package mishkat.mdrd.com.mishkat.Address;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import mishkat.mdrd.com.mishkat.Adapters.ItemListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.MyAddressListAdapter;
import mishkat.mdrd.com.mishkat.Address.Model.MyAddressModel;
import mishkat.mdrd.com.mishkat.Data.SharePrefarence;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Item_list_Activity;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.VendorDetailModel;
import mishkat.mdrd.com.mishkat.My_FavouriteActivity;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.UtilsTools.UtilsTool;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class My_AddressActivity extends AppCompatActivity {


    Button Bt_AddnewAddress;
    Intent intent;
    int Userid;
    RecyclerView RE_Address;
    private List<MyAddressModel.ResultEntity> AddressList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__address);
        RE_Address = findViewById(R.id.Row1);
        Userid = SharePrefarence.getmInstance(getApplication()).getUserId();

        Bt_AddnewAddress = findViewById(R.id.Bt_AddnewAddress);
        Bt_AddnewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(My_AddressActivity.this, Add_AddressActivity.class);
                startActivity(intent);
            }
        });


        GetVendorAddresss(Userid + "");

    }

    private void GetVendorAddresss(String userid) {
        UtilsTool.showProgressDialog(My_AddressActivity.this);
        API.getAPIService().GETMyAddress(userid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyAddressModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.hideProgressDialog();
                        UtilsTool.custoAlert(My_AddressActivity.this, e.getMessage());
                    }

                    @Override
                    public void onNext(MyAddressModel response) {
                        UtilsTool.hideProgressDialog();
                        if (response.getStatus()) {
                            AddressList = response.getResult();
                            //  VendorDetails.setAdapter(new ItemListAdapter(My_AddressActivity.this,VendorDetailDeta));
                            RE_Address.setAdapter(new MyAddressListAdapter(My_AddressActivity.this, AddressList));
                        }
                    }
                });
    }


}
