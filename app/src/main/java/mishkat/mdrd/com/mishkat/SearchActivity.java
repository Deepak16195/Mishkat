package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import mishkat.mdrd.com.mishkat.Adapters.SearchListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.TeacherListAdapter;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.GetAllVenderModel;
import mishkat.mdrd.com.mishkat.EnteryPages.Model.AreasModel;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */


public class SearchActivity extends AppCompatActivity {
    ImageView popup;

    Spinner Sp_country;
    List<String> cuntryArray = new ArrayList<>();
    public List<GetAllVenderModel.ResultEntity> AllVendeData = new ArrayList<>();
    public List<AreasModel.ResultEntity> AreasListData = new ArrayList<>();
    RecyclerView VenderDetils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        VenderDetils = findViewById(R.id.Row1);
        popup = findViewById(R.id.popup);
        cuntryArray = new ArrayList<>();
        GetAreas();
        GetAllVenderData();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(SearchActivity.this, R.style.BottomSheetDialog);
                dialog.setContentView(R.layout.lay_search);
                dialog.show();
                Sp_country = dialog.findViewById(R.id.sp_country);
               /* ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                        SearchActivity.this, R.layout.spinner_item, cuntryArray);
                adapter2.setDropDownViewResource(R.layout.spinner_itemc);*/
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                        SearchActivity.this, R.layout.spinner_item, cuntryArray);
                adapter2.setDropDownViewResource(R.layout.spinner_itemc);
                Sp_country.setAdapter(adapter2);
            }
        });

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
                                AllVendeData = response.getResult();
                                VenderDetils.setAdapter(new SearchListAdapter(SearchActivity.this, AllVendeData));
                            }
                        }
                    }
                });
    }

    private void GetAreas() {
        API.getAPIService().GetAreas().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AreasModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(AreasModel response) {
                        if (response.getStatus()) {
                            if (response.getResult().size() > 0) {
                                AreasListData = response.getResult();
                                for (int i = 0; i < AreasListData.size(); i++) {
                                    cuntryArray.add(AreasListData.get(i).getName());
                                }

                            }
                        }
                    }
                });
    }


}
