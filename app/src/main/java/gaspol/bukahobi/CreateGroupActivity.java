package gaspol.bukahobi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by USER on 6/9/2017.
 */

public class CreateGroupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        Spinner spinnerCreateGroupCategory;
        spinnerCreateGroupCategory = (Spinner) findViewById(R.id.spinnerCreateGroupCategory);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.group_categories, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCreateGroupCategory.setAdapter(spinnerAdapter);
    }

    public void buttonCreateGroupOnClickHandler(View view) {
        Snackbar.make(view, "Go to home page", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
