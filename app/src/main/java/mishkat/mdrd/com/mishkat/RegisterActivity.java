package mishkat.mdrd.com.mishkat;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class RegisterActivity extends AppCompatActivity {

    Button Register;
    Intent i;
    TextView terms;
    private BottomSheetBehavior mBottomSheetBehavior1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Register = findViewById(R.id.Register);
        terms = findViewById(R.id.terms);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(RegisterActivity.this, DeskboardActivity.class);
                startActivity(i);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new TeamsSheetDialog().show(getSupportFragmentManager(), "Dialog");

                BottomSheetDialog dialog = new BottomSheetDialog(RegisterActivity.this, R.style.BottomSheetDialog);
                dialog.setContentView(R.layout.lay_terms);
                dialog.show();

            }
        });

    }
}
