package com.group5.lab2;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Date;

public class FormFragment extends Fragment {

    private EditText homeValueInput;
    private EditText downPaymentInput;
    private EditText interestRateInput;
    private EditText propertyTaxRateInput;
    private Spinner termsSpinner;

    private OnCalculateClickedListener mCallback;

    public interface OnCalculateClickedListener {
//        void onCalculateClicked(double monthly, double interest, double property, Date date);
        void onCalculateClicked();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        homeValueInput = (EditText) view.findViewById(R.id.input_home_value);
        downPaymentInput = (EditText) view.findViewById(R.id.input_down_payment);
        interestRateInput = (EditText) view.findViewById(R.id.input_interest_rate);
        propertyTaxRateInput = (EditText) view.findViewById(R.id.input_property_tax_rate);

        termsSpinner = (Spinner) view.findViewById(R.id.spinner_terms);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.terms_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        termsSpinner.setAdapter(adapter);

        Button calculateBtn = (Button) view.findViewById(R.id.btn_calculate);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        ImageButton resetBtn = (ImageButton) view.findViewById(R.id.btn_reset);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context c) {
        super.onAttach(c);

        Activity a = (Activity) c;

        try {
            mCallback = (OnCalculateClickedListener) a;
        } catch (ClassCastException e) {
            throw new ClassCastException(a.toString() + " must implement OnCalculateClickedListener");
        }
    }

    private void calculate() {
        // Do calculations here and pass as args into onCalculateClicked()
        // Uncomment the method in the interface with args and delete the other.
        mCallback.onCalculateClicked();
    }

    private void reset() {
        homeValueInput.setText("");
        downPaymentInput.setText("");
        interestRateInput.setText("");
        propertyTaxRateInput.setText("");
        termsSpinner.setSelection(0);
    }
}
