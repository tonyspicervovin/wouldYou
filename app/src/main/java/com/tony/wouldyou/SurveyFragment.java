package com.tony.wouldyou;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SurveyFragment extends Fragment {

    public interface ShowResultsListener {
        void showResults(int caveCount,int treeCount);
    }
    private Button mResultButton;
    private Button mAddButton;
    private Button mCaveButton;
    private Button mTreeHouseButton;
    private static int caveCount = 0;
    private static int treeCount = 0;
    private ShowResultsListener mShowResultsListener;

    private String SURVEY_FRAGMENT_TAG = "Survey Fragment";

    public SurveyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ShowResultsListener) {
            mShowResultsListener = (ShowResultsListener) context;
        }else {
            throw new RuntimeException(context.toString());
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_survey, container);

        mResultButton = view.findViewById(R.id.result_button);
        mAddButton = view.findViewById(R.id.add_button);
        mCaveButton = view.findViewById(R.id.cave_button);
        mTreeHouseButton = view.findViewById(R.id.treehouse_button);

        mResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(SURVEY_FRAGMENT_TAG, "result clicked");
                mResultButton.setText("Pressed4");
                mShowResultsListener.showResults(caveCount, treeCount);

            }
        });
        mCaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(SURVEY_FRAGMENT_TAG, "cave clicked");
                caveCount = caveCount + 1;
                //when user clicks cave button it will add one to the cavecounter and show
            }
        });

        mTreeHouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(SURVEY_FRAGMENT_TAG, "tree clicked");
                treeCount = treeCount + 1;
                //when user clicks treehouse button it will add one to the treecount and show
            }
        });



        return inflater.inflate(R.layout.fragment_survey, container, false);
    }




}
