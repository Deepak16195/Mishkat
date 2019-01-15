package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import mishkat.mdrd.com.mishkat.Adapters.CartListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.ChackoutListAdapter;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class CheckoutActivity extends AppCompatActivity {

    Button Bt_Chackout;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Bt_Chackout = findViewById(R.id.Bt_Chackout);
        RecyclerView verticalRecycle2 = findViewById(R.id.Row1);
        verticalRecycle2.setAdapter(new ChackoutListAdapter());

        Bt_Chackout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent = new Intent(CheckoutActivity.this, OrderActivity.class);
                startActivity(intent);


            }
        });


    }
}
