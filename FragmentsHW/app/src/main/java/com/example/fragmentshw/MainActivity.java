package com.example.fragmentshw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // -----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.displayInitialFragment();
    }

    // -----------------------------------------------------
    public void displayInitialFragment() {
        // create the instance of our initial fragment
        InitialFragment initialFragment = InitialFragment.newInstance();

        // Fragment manager for utilizing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // add the fragment
        fragmentTransaction.add(
                R.id.fragment_container,
                initialFragment
        ).addToBackStack(null).commit();
    }

    // -----------------------------------------------------
    public void replaceFragment(String strQuestionare) {

        Bundle bundle = new Bundle();
        bundle.putString("TYPE", strQuestionare);

        QuestionsFragment questionsFragment = QuestionsFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        questionsFragment.setArguments(bundle);

        fragmentTransaction.replace(
                R.id.fragment_container,
                questionsFragment
        ).addToBackStack(null).commit();
    }
}