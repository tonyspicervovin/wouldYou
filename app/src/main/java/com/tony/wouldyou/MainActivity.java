package com.tony.wouldyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button mCaveButton;
    Button mTreeHouseButton;
    Button mResetButton;
    TextView mCaveCounter;
    TextView mTreeHouseCounter;
    private Button mNewQuestionButton;
    private TextView mQuestionText;

    private static final String TAG ="MAIN_ACTIVITY";

    private static int caveCount = 0;
    private static int treeCount = 0;
    private String question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCaveButton = findViewById(R.id.cave_button);
        mTreeHouseButton = findViewById(R.id.treehouse_button);
        mResetButton = findViewById(R.id.reset_button);
        mCaveCounter = findViewById(R.id.cave_counter);
        mTreeHouseCounter = findViewById(R.id.treehouse_counter);
        mNewQuestionButton = findViewById(R.id.addQuestionButton);
        // finding ui components'
        mQuestionText = findViewById(R.id.questionText);

        getCounts();

        mCaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caveCount = caveCount + 1;
                getCounts();
                //when user clicks cave button it will add one to the cavecounter and show
            }
        });

        mTreeHouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                treeCount = treeCount + 1;
                getCounts();
                //when user clicks treehouse button it will add one to the treecount and show
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                treeCount = 0;
                caveCount = 0;
                getCounts();
                //when reset button is pressed both counts are reset to 0 and counters are refreshed
            }
        });


        mNewQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AnswerClass.class);
                startActivityForResult(i,0);
            }
        });

    }

    public void getCounts(){
        mTreeHouseCounter.setText(String.valueOf(treeCount));
        mCaveCounter.setText(String.valueOf(caveCount));
        //method to set counters to value of votes
    }
    @Override
    public void onSaveInstanceState(Bundle outBundle) {
        // Required to call superclass method first
        super.onSaveInstanceState(outBundle);
        outBundle.putInt("tree-count",treeCount);
        outBundle.putInt("cave-count",caveCount);

        // saving counts of each answer with keys
    }
    @Override
    protected void onRestoreInstanceState(Bundle outBundle) {
        super.onRestoreInstanceState(outBundle);
        treeCount = outBundle.getInt ("tree-count");
        caveCount = outBundle.getInt("cave-count");
        //when instance state is loaded counts are retrieved with keys
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (data.hasExtra("question")){
                question = data.getExtras().getString("question");
                mQuestionText.setText(question);
            }
        }
    }

}
