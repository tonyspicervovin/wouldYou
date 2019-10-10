package com.tony.wouldyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SurveyFragment.ShowResultsListener {

    private ResultFragment resultFragment;
    private SurveyFragment surveyFragment;
    private ConfigurationFragment configurationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // creating new fragments
        resultFragment = new ResultFragment();
        surveyFragment = new SurveyFragment();
        configurationFragment = new ConfigurationFragment();

        //show fragments
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, surveyFragment);
        ft.commit();

    }
    @Override
    public void showResults(int caveCount, int treeCount) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, resultFragment);
        ft.commit();
    }
}