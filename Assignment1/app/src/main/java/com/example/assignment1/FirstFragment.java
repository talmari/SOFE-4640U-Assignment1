package com.example.assignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.assignment1.databinding.FragmentFirstBinding;

public class FirstFragment extends AppCompatActivity {

    private FragmentFirstBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pull input values from the text boxes
                String principalString = binding.principalEditText.getText().toString();
                String amortizationString = binding.AmortizationEditText.getText().toString();
                String interestRateString = binding.interestEditText.getText().toString();

                //make sure all the text boxes have been filled in
                if (!principalString.isEmpty() && !amortizationString.isEmpty() && !interestRateString.isEmpty())
                {
                    //Set variables to values within the text boxes
                    double emi;
                    double Principal = Double.parseDouble(principalString);
                    double monthlyPayments = Double.parseDouble(amortizationString) * 12; // Assuming tenure is in years
                    double interestRate = (Double.parseDouble(interestRateString) / 12) / 100;

                    //calculate the EMI
                    emi = (Principal * interestRate * Math.pow(1 + interestRate, monthlyPayments)) /
                            (Math.pow(1 + interestRate, monthlyPayments) - 1);

                    //use an Intent to send the resulting EMI to the second fragment
                    Intent intent = new Intent(FirstFragment.this, SecondFragment.class);
                    intent.putExtra("emi", emi);
                    startActivity(intent);
                }
            }
        });
    }
}