package mishkat.mdrd.com.mishkat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import mishkat.mdrd.com.mishkat.Adapters.CartListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.SearchListAdapter;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class CartActivity extends AppCompatActivity {

    TextView tx_Address, tx_Payments;
    Button bt_Confirm;
    AlertDialog dialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        RecyclerView verticalRecycle2 = findViewById(R.id.Row1);
        tx_Address = findViewById(R.id.tx_Address);
        tx_Payments = findViewById(R.id.tx_Payments);
        bt_Confirm = findViewById(R.id.bt_Confirm);
        verticalRecycle2.setAdapter(new CartListAdapter());

        tx_Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowAddress();

            }
        });


        tx_Payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowPayments();

            }
        });
        bt_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);

            }
        });

    }


    public void ShowAddress() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertLayout = inflater.inflate(R.layout.lay_address, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(CartActivity.this);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        dialog = alert.create();
        dialog.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        // Set the alert dialog window width and height
        // Set alert dialog width equal to screen width 90%
        // int dialogWindowWidth = (int) (displayWidth * 0.9f);
        // Set alert dialog height equal to screen height 90%
        // int dialogWindowHeight = (int) (displayHeight * 0.9f);
        // Set alert dialog width equal to screen width 70%
        int dialogWindowWidth = (int) (displayWidth * 0.81f);
        // Set alert dialog height equal to screen height 70%
        //int dialogWindowHeight = (int) (displayHeight * 0.5f);
        // Set the width and height for the layout parameters
        // This will bet the width and height of alert dialog
        layoutParams.width = dialogWindowWidth;
        //  layoutParams.height = dialogWindowHeight;
        // Apply the newly created layout parameters to the alert dialog window
        dialog.getWindow().setAttributes(layoutParams);
    }

    ;

    public void ShowPayments() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View alertLayout = inflater.inflate(R.layout.lay_payment, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(CartActivity.this);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        dialog = alert.create();
        dialog.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        // Set the alert dialog window width and height
        // Set alert dialog width equal to screen width 90%
        // int dialogWindowWidth = (int) (displayWidth * 0.9f);
        // Set alert dialog height equal to screen height 90%
        // int dialogWindowHeight = (int) (displayHeight * 0.9f);
        // Set alert dialog width equal to screen width 70%
        int dialogWindowWidth = (int) (displayWidth * 0.81f);
        // Set alert dialog height equal to screen height 70%
        //int dialogWindowHeight = (int) (displayHeight * 0.5f);
        // Set the width and height for the layout parameters
        // This will bet the width and height of alert dialog
        layoutParams.width = dialogWindowWidth;
        //  layoutParams.height = dialogWindowHeight;
        // Apply the newly created layout parameters to the alert dialog window
        dialog.getWindow().setAttributes(layoutParams);
    }

    ;

}
