package mishkat.mdrd.com.mishkat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mishkat.mdrd.com.mishkat.Adapters.TeacherListAdapter;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.GetAllVenderModel;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */


public class Teacher_DetailsActivity extends AppCompatActivity {
    RecyclerView verticalRecycle2;
    private List<GetAllVenderModel.ResultEntity> AllVendeData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__details);
        GetAllVenderData();
        verticalRecycle2 = findViewById(R.id.Row1);

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
                                verticalRecycle2.setAdapter(new TeacherListAdapter(Teacher_DetailsActivity.this, AllVendeData));
                            }
                        }
                    }
                });
    }
}
