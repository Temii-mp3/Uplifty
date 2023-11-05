package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomePage extends AppCompatActivity {
    private TextView greetingText;
    private Button continueToDashboard;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        name = getIntent().getStringExtra("Name"); //recovering User Name
        continueToDashboard = findViewById(R.id.goToDashBoard);
        greetingText = findViewById(R.id.text_greet);
        String greeting = "Hello, " + name + "!";
        greetingText.setText(greeting); //Set greeting

        /**
         * Lambda expression to open the dashboard page
         * @param v the button that is clicked, which is "Continue"
         */
        continueToDashboard.setOnClickListener(v ->{
            Intent dashboard = new Intent(this, dashboard.class);
            dashboard.putExtra("Name", name);
            startActivity(dashboard);
        });

    }


}