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

        // Small screens will not have both fragments shown
        if (resultsFrag == null) {
            // Replace form fragment with results fragment
            ResultsFragment newResultsFrag = new ResultsFragment();
            Bundle args = new Bundle();

            // Store arguments in args to pass into fragment
            // args.put...
            newResultsFrag.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.replace(R.id.fragment_container, newResultsFrag);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            // Need to edit showResults to take in arguments
            resultsFrag.showResults();
        }
    }
}
