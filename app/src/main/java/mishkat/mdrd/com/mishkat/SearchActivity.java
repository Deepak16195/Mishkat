package mishkat.mdrd.com.mishkat;

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

import mishkat.mdrd.com.mishkat.Adapters.SearchListAdapter;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */


public class SearchActivity extends AppCompatActivity {
    ImageView popup;

    Spinner Sp_country;
    List<String> cuntryArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        RecyclerView verticalRecycle2 = findViewById(R.id.Row1);
        popup = findViewById(R.id.popup);
        cuntryArray = new ArrayList<>();
        cuntryArray.add("Kuwait City (Capital)");
        cuntryArray.add("Abdullah Al Salem");
        cuntryArray.add("Adaitiya");
        cuntryArray.add("Bneid Al Qar");
        cuntryArray.add("Daiya");
        cuntryArray.add("Deepak");


        verticalRecycle2.setAdapter(new SearchListAdapter());
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
}
