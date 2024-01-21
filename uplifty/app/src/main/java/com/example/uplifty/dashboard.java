package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {
    private TextView dashboardInfo;
    private LinearLayout settings, helpLine, dailyFeelings, mantras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        String name = getIntent().getStringExtra("Name"); //recover User Name
        dashboardInfo = findViewById(R.id.displayDashInfo);
        String dashBoard = "Hello, " + name + " welcome to your dashboard";
        dashboardInfo.setText(dashBoard); //Display Dashboard

        //set each respective button to its square on dashboard
        settings = findViewById(R.id.settings);
        helpLine = findViewById(R.id.helpline);
        dailyFeelings = findViewById(R.id.dailyfeelings);
        mantras = findViewById(R.id.mantras);

        mantras.setOnClickListener(v->{
            Intent mantrasPage = new Intent(this,mantras_page.class);
            startActivity(mantrasPage);
        });
    }


}