package com.example.androidquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// =========================================================
public class MainActivity extends AppCompatActivity {
    Question questions [] = new Question[5];
    int indexQuestions = 0;
    // HELPERS
    // -----------------------------------------------------
    void createQuestions() {
        questions[0] = new Question("Messi is leaving Barcelona", true);
        questions[1] = new Question("Porcupines can float", true);
        questions[2] = new Question("Goldfish only have a memory of three seconds", false);
        questions[3] = new Question("Napoleon was of below-average height", false);
        questions[4] = new Question("According to Scottish law, it is illegal to be drunk in charge of a cow", true);
    }
    // -----------------------------------------------------
    void showQuestion(int id) {
        TextView displayQuestion = findViewById(R.id.strQuestionHolder);
        displayQuestion.setText(questions[id].strQuestion);
    }
    // -----------------------------------------------------
    void showToast(String strMessage){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, strMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
    // Lifecycle
    // -----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.createQuestions();
        this.showQuestion(indexQuestions);
    }
    // -----------------------------------------------------
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", indexQuestions);
    }
    // -----------------------------------------------------
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        indexQuestions = savedInstanceState.getInt("index");
        showQuestion(indexQuestions);
    }

    // Click events
    // -----------------------------------------------------
    public void onClickNext(View view) {
        indexQuestions++;
        if(
                // don't go out of bounds
                indexQuestions >= 5
        ) {
            indexQuestions = 0;
        }

        this.showQuestion(indexQuestions);
    }
    // -----------------------------------------------------
    public void onClickTrue(View view) {
        if(questions[indexQuestions].bAnswer) {
            showToast("Correct!");
        } else {
            showToast("Wrong >:C");
        }
    }
    // -----------------------------------------------------
    public void onClickFalse(View view) {
        if(!questions[indexQuestions].bAnswer) {
            showToast("Correct!");
        } else {
            showToast("Wrong >:C");
        }
    }
}