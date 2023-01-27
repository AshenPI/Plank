package com.example.plank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calorie extends AppCompatActivity {

    private Button button4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);


        button4 = findViewById(R.id.button4);


        button4.setOnClickListener(view -> {
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
                final EditText ageText=findViewById(R.id.age);
                String ageStr = ageText.getText().toString();
                double agge = Double.parseDouble(ageStr);

                double IBW = (height - 100) - (height * 0.10);
                double BMI = (weight) / (heightM * heightM);
                double Calorie  = (66.5 + (13.75 * weight))+((5.003 * height) - (6.75 * agge));

                DecimalFormat df = new DecimalFormat("#.#");
                double Calorie_trimmed = Double.parseDouble(df.format(Calorie));

                final TextView CalorieResult = findViewById(R.id.result);

                CalorieResult.setText("Calories " + Double.toString(Calorie_trimmed));

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