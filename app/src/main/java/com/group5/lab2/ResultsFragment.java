package com.group5.lab2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ResultsFragment extends Fragment {

    private EditText monthlyPaymentInput;
    private EditText totalInterestInput;
    private EditText totalPropertyInput;
    private EditText payOffDateInput;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        monthlyPaymentInput = (EditText) view.findViewById(R.id.input_montly_payment_amount);
        totalInterestInput = (EditText) view.findViewById(R.id.input_total_interest_paid);
        totalPropertyInput = (EditText) view.findViewById(R.id.input_total_property_tax_paid);
        payOffDateInput = (EditText) view.findViewById(R.id.input_pay_off_date);

        return view;
    }

    public void showResults() {
        System.out.println("hi");
    }
}
