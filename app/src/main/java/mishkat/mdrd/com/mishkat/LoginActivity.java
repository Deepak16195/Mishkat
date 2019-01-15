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

public class LoginActivity extends AppCompatActivity {

    TextView Createnew;
    Button Login;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Createnew = findViewById(R.id.Createnew);
        Login = findViewById(R.id.Login);

        Createnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(LoginActivity.this, DeskboardActivity.class);
                startActivity(i);
            }
        });


    }
}
