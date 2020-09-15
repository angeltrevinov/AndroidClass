package com.example.datatransmissiont3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// =========================================================
public class MainActivity extends AppCompatActivity {

    // to store our instance
    public static final String CURRRENT_COUNTER =
            "com.example.twoact.extra.CURRENT_COUNTER";

    // A handler for the count down
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            intCount++;
            tvCounter.setText("" + intCount);
            handler.postDelayed(this, 1000);
        }
    };

    private int intCount;

    TextView tvCounter;
    Button btnCount;
    // -----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get componentes
        tvCounter = findViewById(R.id.tvCounter);
        btnCount = findViewById(R.id.btnCount);

        intCount = 0;
        tvCounter.setText("" + intCount);
    }
    // -----------------------------------------------------
    public void onClickCount(
            // Starts the counter
            View view
    ) {

        btnCount.setEnabled(false);
        handler.postDelayed(runnable, 1000);
    }
    // -----------------------------------------------------
    public void LaunchActivityB(
            // Change to the activity B
            View view
    ) {
        // save our data to send it to activity B
        Intent intent = new Intent(MainActivity.this, ActivityB.class);
        intent.putExtra(CURRRENT_COUNTER, intCount);
        // For when we want to receive data from the activity b
        startActivityForResult(intent, 1);
    }

    // -----------------------------------------------------
    @Override
    protected void onActivityResult(
            // When returning from activity B, get the data
            int requestCode,
            int resultCode,
            @Nullable Intent data
    ) {
        super.onActivityResult(requestCode, resultCode, data);
        intCount = data.getIntExtra(ActivityB.NEW_COUNTER, 0);
        tvCounter.setText("" + intCount);
        handler.removeCallbacks(runnable);
        btnCount.setEnabled(true);
    }
}