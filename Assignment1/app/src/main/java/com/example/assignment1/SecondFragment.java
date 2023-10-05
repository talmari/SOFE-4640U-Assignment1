package com.example.assignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.appcompat.app.AppCompatActivity;
import com.example.assignment1.databinding.FragmentSecondBinding;

public class SecondFragment extends AppCompatActivity {

    private FragmentSecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //get EMI value from passed Intent
        double emi = getIntent().getDoubleExtra("emi", 0.0);
        //check if the passed value is null
        if (emi != 0.0)
            {
                //display the EMI
                binding.resultTextView.setText(String.format("Based on the inputs, your monthly EMI is: $%.2f", emi));
            }
            else
            {
                //if the calculation failed or values were empty
                binding.resultTextView.setText("Sorry unable to calculate EMI please try again");
            }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish the current fragment and go back to the previous fragment
                finish();
            }
        });
    }
}