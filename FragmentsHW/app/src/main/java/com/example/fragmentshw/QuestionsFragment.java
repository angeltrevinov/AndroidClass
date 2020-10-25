package com.example.fragmentshw;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionsFragment extends Fragment {

    Question[] questions = new Question[5];
    int intIndex = 0;
    TextView tvHolder;
    TextView tvCounter;
    Button btnNext;
    Button btnPrev;
    Button checkAnswer;
    RadioGroup radioGroup;
    RadioButton radioTrue;
    RadioButton radioFalse;
    boolean bAnswer;

    private static final String ARG_PARAM1 = "TYPE";

    private String strTypeQuestionare;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuestionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionsFragment newInstance() {
        QuestionsFragment fragment = new QuestionsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.strTypeQuestionare = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(
                R.layout.fragment_questions,
                container,
                false
        );
        this.fillQuestions();

        radioGroup = rootView.findViewById(R.id.radioGroup);
        radioTrue = rootView.findViewById(R.id.radioTrue);
        radioFalse = rootView.findViewById(R.id.radioFalse);

        tvHolder = rootView.findViewById(R.id.tvQuestion);
        tvHolder.setText(this.questions[this.intIndex].strQuestion);

        tvCounter = rootView.findViewById(R.id.tvCounter);
        String strCounter = "[" + (this.intIndex + 1) + "/" + this.questions.length + "]";
        tvCounter.setText(strCounter);

        checkAnswer = rootView.findViewById(R.id.btnCheck);
        checkAnswer.setVisibility(View.INVISIBLE);

        btnPrev = rootView.findViewById(R.id.btnPrev);
        btnNext = rootView.findViewById(R.id.btnNext);
        if (this.intIndex == 0) {
            btnPrev.setEnabled(false);
        }

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer.setVisibility(View.INVISIBLE);
                radioGroup.clearCheck();
                intIndex--;
                if (intIndex == 0) {
                    btnPrev.setEnabled(false);
                    intIndex = 0;
                }
                tvHolder.setText(questions[intIndex].strQuestion);
                btnNext.setEnabled(true);
                String strCounter = "[" + (intIndex + 1) + "/" + questions.length + "]";
                tvCounter.setText(strCounter);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer.setVisibility(View.INVISIBLE);
                radioGroup.clearCheck();
                intIndex++;
                if (intIndex == questions.length-1) {
                    btnNext.setEnabled(false);
                    intIndex = 4;
                }
                tvHolder.setText(questions[intIndex].strQuestion);
                btnPrev.setEnabled(true);
                String strCounter = "[" + (intIndex + 1) + "/" + questions.length + "]";
                tvCounter.setText(strCounter);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);

                switch (index) {
                    case 0:
                        bAnswer = true;
                        checkAnswer.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        bAnswer = false;
                        checkAnswer.setVisibility(View.VISIBLE);
                        break;
                    default:
                        checkAnswer.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bAnswer == questions[intIndex].bAnswer) {
                    showToast("Correct!");
                } else if (bAnswer != questions[intIndex].bAnswer) {
                    showToast("Wrong!");
                }
            }
        });

        return rootView;
    }

    // -----------------------------------------------------
    void showToast(
            // helps us display a toast message
            String strMessage
    ){
        Context context = getActivity().getBaseContext();
        Toast toast = Toast.makeText(context, strMessage, Toast.LENGTH_SHORT);
        toast.show();
    }

    // -----------------------------------------------------
    public void fillQuestions() {
        this.intIndex = 0;
        if (this.strTypeQuestionare.equals("Tech")) {
            questions[0] = new Question("Apple is made by windows", false);
            questions[1] = new Question("Linux is the same as Unix", false);
            questions[2] = new Question("The RTX 3080 is more powerful and cheaper than an RTX 2080 TI", true);
            questions[3] = new Question("You download more RAM", false);
            questions[4] = new Question("AI is going to take over the world", true);
        } else if (this.strTypeQuestionare.equals("Deportes")) {
            questions[0] = new Question("Checo Perez deserve more from Racing Point", true);
            questions[1] = new Question("Tigres is better than Rayados", false);
            questions[2] = new Question("The Tampico-Madero have won the league before", true);
            questions[3] = new Question("Santos Laguna are going to win the league", true);
            questions[4] = new Question("Chicharito is trash", true);
        }
    }
}