package com.group5.lab2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

enum MONTHS
{
    January, February, March, April, May, June, July, August, Septempber, October, November, December;
}
public class MainActivity extends AppCompatActivity {
    GregorianCalendar cal;
    MONTHS[] arrayOfMonths;

    //Values Inputted
    private Double homeValue;
    private Double downPayment;
    private Double APR;
    private Double taxRate;
    private Integer terms;

    //Values Calculated
    private Double monthPayment;
    private Double principalAmt;
    private Double interestRate;
    private Integer numPayments;


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


    private String numberFormatter(String number){
        String formattedNum = "";

        return formattedNum;
    }

    /**
     * TaxPaid = (HomeValue*Tax%)Terms
     * @return taxPaid amount to be paid
     */
    private double TotalTaxPaid(){
        double taxPaid = 0;

        taxPaid = homeValue*taxRate;
        taxPaid = taxPaid*terms;

        return taxPaid;
    }

    private double TotalInterestPaid(){
        double interestPaid = 0;

        return interestPaid;
    }
    /**
     * This method calculates the amount to paid each month
     * @return MonthlyPayment amount paid each month
     */
    private double calcNumPayments(){
        double MonthlyPayment = 0;
        double powerCalc;
        double dividend;
        double divisor;

        //Calculate (1 + i)^n
        powerCalc = 1 + interestRate;
        powerCalc = Math.pow(powerCalc, numPayments);

        //Calculate dividend of mortgage formula
        dividend = interestRate*powerCalc;

        //Calculate divisor of mortgage formula
        divisor = powerCalc - 1;

        //Calculate Monthly Payment
        MonthlyPayment = dividend/divisor;
        MonthlyPayment = principalAmt*MonthlyPayment;

        return MonthlyPayment;
    }

    /**
     * Sets date to be printed
     * @return date string of month and year
     */
    private String payOffDate() {
        String date = "";
        cal = new GregorianCalendar();
        arrayOfMonths = MONTHS.values();

        cal.add(Calendar.MONTH, terms);

        date = "" + arrayOfMonths[cal.get(Calendar.MONTH)] + " " +
                    cal.get(Calendar.YEAR);

        return date;
    }

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
