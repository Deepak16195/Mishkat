package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class ProfileActivity extends AppCompatActivity {

    Button Bt_myAddress;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bt_myAddress = findViewById(R.id.Bt_myAddress);
        Bt_myAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ProfileActivity.this, My_AddressActivity.class);
                startActivity(intent);
            }
        });

    }
}
