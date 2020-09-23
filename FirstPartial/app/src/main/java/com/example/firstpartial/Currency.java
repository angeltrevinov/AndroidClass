package com.example.firstpartial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Currency extends AppCompatActivity {

    EditText ETCambio;
    EditText ETInput;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        ETCambio = findViewById(R.id.ETCambio);
        ETInput = findViewById(R.id.ETInput);
        tvResult = findViewById(R.id.tvResult);
    }

    public void onCalcular(View view) {
        int intCambio = 0;
        int intInput = 0;
        int intResult = 0;
        String strCambio = ETCambio.getText().toString();
        String strInput = ETInput.getText().toString();
        if(!strCambio.equals("")) {
            intCambio = Integer.parseInt(strCambio);
        }

        if(!strInput.equals("")) {
            intInput = Integer.parseInt(strInput);
        }

        intResult = intInput / intCambio;
        tvResult.setText("" + intResult + " USD");
    }
}