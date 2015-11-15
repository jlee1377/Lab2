package com.group5.lab2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FormFragment.OnCalculateClickedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            FormFragment firstFragment = new FormFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    @Override
    public void onCalculateClicked() {
        System.out.println("test");

        ResultsFragment resultsFrag = (ResultsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);

        if (resultsFrag == null) {
            ResultsFragment newResultsFrag = new ResultsFragment();
            Bundle args = new Bundle();
            newResultsFrag.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newResultsFrag);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            resultsFrag.showResults();
        }
    }
}
