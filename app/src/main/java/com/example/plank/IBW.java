package com.example.plank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class IBW extends AppCompatActivity {

    private Button button3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibw);

        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext() , MainActivity.class);
            startActivity(intent);
            finish();
        });

        myButtonListenerMethod();


    }

    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText heightText = findViewById(R.id.height);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);
                double heightM = height / 100;
                final EditText weightText = findViewById(R.id.weight);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);
                double IBW = ( (height - 100) - (height * 0.10));
                double BMI = (weight) / (heightM * heightM);

                DecimalFormat df = new DecimalFormat("#.#");

                double IBW_trimmed = Double.parseDouble(df.format(IBW));

                final TextView IBWResult = findViewById(R.id.result1);


                IBWResult.setText("Ideal weight is :" + Double.toString(IBW_trimmed));
                String BMI_Cat;


                if (BMI < 15) {

                    BMI_Cat = "Very severely underweight";
                } else if (BMI >= 15 && BMI < 16) {
                    BMI_Cat = "Severely underweight";
                } else if (BMI >= 16 && BMI < 18.5) {
                    BMI_Cat = "Underweight";
                } else if (BMI >= 18.5 && BMI < 25) {
                    BMI_Cat = "Normal";
                } else if (BMI >= 25 && BMI < 30) {
                    BMI_Cat = "Overweight";
                } else if (BMI >= 30 && BMI < 35) {
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                } else if (BMI >= 35 && BMI < 40) {
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                } else {
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";

                }
                final TextView BMICategory = findViewById(R.id.bmiCat);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}