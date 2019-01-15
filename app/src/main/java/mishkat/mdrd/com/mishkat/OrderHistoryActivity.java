package mishkat.mdrd.com.mishkat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import mishkat.mdrd.com.mishkat.Adapters.CartListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.OrderhistoryListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.TeacherListAdapter;


/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        RecyclerView verticalRecycle2 = findViewById(R.id.Row1);
        verticalRecycle2.setAdapter(new OrderhistoryListAdapter());

    }
}
