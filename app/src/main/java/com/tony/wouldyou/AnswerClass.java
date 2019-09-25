package com.tony.wouldyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class AnswerClass extends Activity {
    private EditText mNewQuestion;
    private EditText mNewAnswerOne;
    private EditText mNewAnswerTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_question);

        mNewQuestion = findViewById(R.id.questionName);
        mNewAnswerOne = findViewById(R.id.answerOne);
        mNewAnswerTwo = findViewById(R.id.answerTwo);

        String question = mNewQuestion.getText().toString();
        String answerOne = mNewAnswerOne.getText().toString();
        String answerTwo = mNewAnswerOne.getText().toString();

        Intent data = new Intent();
        data.putExtra("question", question);
        data.putExtra("answerOne", answerOne);
        data.putExtra("answerTwo", answerTwo);
        setResult(RESULT_OK, data);
        finish();


    }
}
