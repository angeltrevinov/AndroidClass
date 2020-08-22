package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gets the reference of the button using the id
        Button btnBotton = findViewById(R.id.btnBotton);
        // changes the text of the button
        btnBotton.setText("Click me!");

        // create a click listener to listing for events
        btnBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "You touch me pervert!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}