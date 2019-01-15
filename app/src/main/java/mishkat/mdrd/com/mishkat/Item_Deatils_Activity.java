package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class Item_Deatils_Activity extends AppCompatActivity {

    Button Bt_Addtocart;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__deatils_);
        Bt_Addtocart = findViewById(R.id.Bt_Addtocart);
        Bt_Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Item_Deatils_Activity.this, CartActivity.class);
                startActivity(i);
            }
        });
    }
}
