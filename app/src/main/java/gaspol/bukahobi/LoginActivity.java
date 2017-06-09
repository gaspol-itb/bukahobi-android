package gaspol.bukahobi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by USER on 6/6/2017.
 */

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    String USER_ID = "USER_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
    }

    public void buttonLoginOnClickHandler(View view) {
        Snackbar.make(view, "Go to home page", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        //send request to backend here!
        //request -> if err (output err) else continue

        Intent intent = new Intent(this, HomeActivity.class);
        //put user id in this intent
        //intent.putExtra(USER_ID, request.user_id);
        startActivity(intent);
    }

    public void buttonRegisterOnClickHandler(View view) {
        Snackbar.make(view, "Go to register page", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
