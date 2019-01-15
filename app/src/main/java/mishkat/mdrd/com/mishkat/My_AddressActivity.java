package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import mishkat.mdrd.com.mishkat.Adapters.MyAddressListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.TeacherListAdapter;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class My_AddressActivity extends AppCompatActivity {


    Button Bt_AddnewAddress;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__address);
        RecyclerView verticalRecycle2 = findViewById(R.id.Row1);
        verticalRecycle2.setAdapter(new MyAddressListAdapter());
        Bt_AddnewAddress = findViewById(R.id.Bt_AddnewAddress);
        Bt_AddnewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(My_AddressActivity.this, Add_AddressActivity.class);
                startActivity(intent);
            }
        });

    }
}
