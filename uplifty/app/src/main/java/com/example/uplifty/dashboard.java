package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
    private TextView dashboardInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        String name = getIntent().getStringExtra("Name"); //recover User Name
        dashboardInfo = findViewById(R.id.displayDashInfo);
        String dashBoard = "Hello, " + name + " welcome to your dashboard";
        dashboardInfo.setText(dashBoard); //Display Dashboard
    }


}