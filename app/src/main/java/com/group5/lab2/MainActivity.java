package com.group5.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FormFragment.OnCalculateClickedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCalculateClicked() {
        System.out.println("test");
        ResultsFragment resultsFrag = (ResultsFragment) getFragmentManager().findFragmentById(R.id.fragment2);

        if (resultsFrag == null) {
            Intent intent = new Intent(this, ResultsActivity.class);
            startActivity(intent);
        } else {
            resultsFrag.showResults();
        }
    }
}
