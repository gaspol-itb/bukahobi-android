package gaspol.bukahobi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by USER on 6/6/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    CheckBox checkBoxRegisterAgreement;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        checkBoxRegisterAgreement = (CheckBox) findViewById(R.id.checkBoxRegisterAgreement);
    }

    public void buttonRegisterSubmitOnClickHandler (View view) {
        Snackbar.make(view, "Checkbox value = " + checkBoxRegisterAgreement.isChecked(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
