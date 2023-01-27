package com.example.plank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String url = "https://run.mocky.io/v3/85cf9aaf-aa4f-41bf-b10c-308f032f7ccc";

    FirebaseAuth auth;
    Button button;
    Button otherButton;
    TextView textview;
    FirebaseUser user;
    private Spinner spinner;
    private static final String[] paths = {" " ,"Fitness And Health info", "BMI", "IBW", "CalorieCalculator"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        button = findViewById(R.id.logout);
        user = auth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
//           textview.setText(user.getEmail());
        }


        button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext() , Login.class);
            startActivity(intent);
            finish();
        });


        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        otherButton = findViewById(R.id.health);

        otherButton.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext() , Tips.class);
            startActivity(intent);
            finish();
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position) {
            case 1:
                Intent intent0 = new Intent(getApplicationContext() , HealthWeb.class);
                startActivity(intent0);
                finish();

                break;
            case 2:
                // Whatever you want to happen when the first item gets selected
                Intent intent = new Intent(getApplicationContext() , BMI.class);
                startActivity(intent);
                finish();


                break;
            case 3:
                // Whatever you want to happen when the second item gets selected
                Intent intent2 = new Intent(getApplicationContext() , IBW.class);
                startActivity(intent2);
                finish();
                break;
            case 4:
                // Whatever you want to happen when the thrid item gets selected
                Intent intent3 = new Intent(getApplicationContext() , Calorie.class);
                startActivity(intent3);
                finish();
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }







}
