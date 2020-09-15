package com.example.datatransmissiont3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

// =========================================================
public class ActivityB extends AppCompatActivity {

    public static final String NEW_COUNTER =
            "com.example.twoact.extra.NEW_COUNTER";

    TextView tvCount;
    EditText etCounter;
    int intCounter;

    // -----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // get components
        tvCount = findViewById(R.id.tvCount);
        etCounter = findViewById(R.id.etCounter);

        // get intent from activity A
        Intent intent = getIntent();
        intCounter = intent.getIntExtra(MainActivity.CURRRENT_COUNTER, 0);
        tvCount.setText("" + intCounter);
    }

    // -----------------------------------------------------
    public void saveCounter() {
        String strNewCount = etCounter.getText().toString();
        if (!strNewCount.equals("")) {
            intCounter = Integer.parseInt(strNewCount);
        }
        // To send data back
        Intent BackIntent = new Intent();
        BackIntent.putExtra(NEW_COUNTER, intCounter);
        setResult(RESULT_OK, BackIntent);
        finish();
    }

    // -----------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(
            // System application menu, one at the top
            MenuItem item
    ) {
        switch (item.getItemId()) {
            case android.R.id.home:
                saveCounter();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed(
            // For system ui button, the one that is at the
            // bottom
    ) {
        saveCounter();
    }
}