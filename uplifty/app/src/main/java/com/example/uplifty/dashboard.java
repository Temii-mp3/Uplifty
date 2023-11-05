package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
    private TextView dashboardInfo;
    String name = getIntent().getStringExtra("Name");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dashboardInfo = findViewById(R.id.displayDashInfo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        String dashBoard = "Hello, " + name + "welcome to your dashboard";
        dashboardInfo.setText(dashBoard);
    }


}