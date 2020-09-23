package com.example.firstpartial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvName;

    private static final String TAG = "StateChange";
    public int IntLifeCycleCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);

        if(savedInstanceState != null) {
            IntLifeCycleCounter = savedInstanceState.getInt("intCounter");
            IntLifeCycleCounter++;
        }

        IntLifeCycleCounter++;
        Log.i(TAG, "OnCreate: " + IntLifeCycleCounter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntLifeCycleCounter++;
        Log.i(TAG, "OnStart: " + IntLifeCycleCounter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntLifeCycleCounter++;
        Log.i(TAG, "OnResume: " + IntLifeCycleCounter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        IntLifeCycleCounter++;
        Log.i(TAG, "OnPause: " + IntLifeCycleCounter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        IntLifeCycleCounter++;
        Log.i(TAG, "OnStop: " + IntLifeCycleCounter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        IntLifeCycleCounter++;
        Log.i(TAG, "OnRestart: " + IntLifeCycleCounter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IntLifeCycleCounter++;
        Log.i(TAG, "OnDestroy: " + IntLifeCycleCounter);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        IntLifeCycleCounter++;
        Log.i(TAG, "onConfigurationChanged");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        IntLifeCycleCounter++;
        Log.i(TAG, "OnSaveInstanceState: " + IntLifeCycleCounter);
        super.onSaveInstanceState(outState);
        outState.putInt("intCounter", IntLifeCycleCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        IntLifeCycleCounter++;
        Log.i(TAG, "onRestoreInstanceState: " + IntLifeCycleCounter);
    }

    public void onClickCalculadora(View View) {
        Intent intent = new Intent(MainActivity.this, Calculadora.class);
        startActivity(intent);
    }

    public void onClickMoney(View view) {
        Intent intent = new Intent(MainActivity.this, Currency.class);
        startActivity(intent);
    }

    public void onClickName(View view){
        Intent intent = new Intent(MainActivity.this, ChangeMyName.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String strName = data.getStringExtra(ChangeMyName.NAME);
        tvName.setText(strName);
    }
}