package com.example.farenheitcelsius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Execute every time the activity is shown.
    // -----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gets the reference of the submit btn
        Button btnConvert = findViewById(R.id.btnConvert);

        // Create an event listener to transform celsius to
        //  Fahrenheit
        // -------------------------------------------------
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gets the input from string to double
                EditText tvInputText = findViewById(R.id.ptInitTemp);
                double dCelsius = Double.parseDouble(
                        tvInputText.getText().toString()
                );
                // Formula C to -> F
                double dFahrenheit = (dCelsius * 9/5) + 32;

                // display it in a text view
                TextView tvResult = findViewById(R.id.tvResult);
                String strResult = "" + dFahrenheit;
                tvResult.setText(strResult);
            }
        });
    }
}