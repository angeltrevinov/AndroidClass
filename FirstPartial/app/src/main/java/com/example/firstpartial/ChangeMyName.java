package com.example.firstpartial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChangeMyName extends AppCompatActivity {

    public static final String NAME =
            "com.example.FirstPartial.extra.NAME";

    EditText ETName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_my_name);
        ETName = findViewById(R.id.ETName);
    }

    public void onClickChange(View view) {
        String strName = ETName.getText().toString();
        if (!strName.equals("")) {
            Intent backIntent = new Intent();
            backIntent.putExtra(NAME, strName);
            setResult(RESULT_OK, backIntent);
            finish();
        }
    }
}