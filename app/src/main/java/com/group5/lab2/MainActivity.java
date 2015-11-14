package com.group5.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
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

    private String payOffDate(){
        String date = "";


        return date;
    }
}
