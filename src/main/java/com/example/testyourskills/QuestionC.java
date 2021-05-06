package com.example.testyourskills;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionC extends AppCompatActivity {

    private TextView optionA, optionB, optionC, optionD;
    private TextView questionNumber, question, score;
    private TextView chechkout1, checkout2;
    int currentIndex;
    int mscore = 0;
    int qn = 1;
    ProgressBar progressBar;

    int CurrentQuestion, CurrentOptionA, CurrentOptionB, CurrentOptionC, CurrentOptionD;

    private Answer[] questions = new Answer[]{
            new Answer(R.string.questionC_1, R.string.questionC_1A, R.string.questionC_1B, R.string.questionC_1C, R.string.questionC_1D, R.string.answerC_1),
            new Answer(R.string.questionC_2, R.string.questionC_2A, R.string.questionC_2B, R.string.questionC_2C, R.string.questionC_2D, R.string.answerC_2),
            new Answer(R.string.questionC_3, R.string.questionC_3A, R.string.questionC_3B, R.string.questionC_3C, R.string.questionC_3D, R.string.answerC_3),
            new Answer(R.string.questionC_4, R.string.questionC_4A, R.string.questionC_4B, R.string.questionC_4C, R.string.questionC_4D, R.string.answerC_4),
            new Answer(R.string.questionC_5, R.string.questionC_5A, R.string.questionC_5B, R.string.questionC_5C, R.string.questionC_5D, R.string.answerC_5)
    };

    final int PROGRESS_BAR = (int) Math.ceil(100 / questions.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_c);


        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        questionNumber = findViewById(R.id.QuestionNumber);

        chechkout1 = findViewById(R.id.selectoption);
        checkout2 = findViewById(R.id.CorrectAnswer);
        progressBar = findViewById(R.id.progress_bar);

        CurrentQuestion = questions[currentIndex].getQuestionID();
        question.setText(CurrentQuestion);
        CurrentOptionA = questions[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB = questions[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC = questions[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD = questions[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionA);
                updateQuestion();

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);
                updateQuestion();


            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);
                updateQuestion();


            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionD);
                updateQuestion();

            }
        });
    }

    private void checkAnswer(int userSelection) {
        int correctanswer = questions[currentIndex].getAnswerID();
        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);
        String m = chechkout1.getText().toString().trim();
        String n = checkout2.getText().toString().trim();

        if (m.equals(n)) {
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        } else {
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }
    }


    private void updateQuestion() {
        currentIndex = (currentIndex + 1) % questions.length;
        if (currentIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("You completed quiz on app made by Neha Sharma & Srishty Gagneja");
            alert.setCancelable(false);
            alert.setMessage("Your Score: " + mscore + "/5 points");
            alert.setPositiveButton("Change subject", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("Start again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("Score" + mscore + "/" + questions.length);
                    questionNumber.setText(qn + "/" + questions.length + "Question");
                }
            }).show();
        }

        CurrentQuestion = questions[currentIndex].getQuestionID();
        question.setText(CurrentQuestion);
        CurrentOptionA = questions[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB = questions[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC = questions[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD = questions[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        qn = qn + 1;

        if (qn <= questions.length) {
            questionNumber.setText("Question " + qn + "/" + questions.length);
        }
        score.setText("Score " + mscore + "/" + questions.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);
    }
}