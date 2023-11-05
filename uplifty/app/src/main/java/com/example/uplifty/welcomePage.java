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
    String name = getIntent().getStringExtra("Name");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        continueToDashboard = findViewById(R.id.goToDashBoard);
        greetingText = findViewById(R.id.text_greet);
        String greeting = "Hello, " + name + "!";
        greetingText.setText(greeting);


        continueToDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });
    }


    private void openDashboard(){
        Intent dashboard = new Intent(this, dashboard.class);
        dashboard.putExtra("Name", name);
        startActivity(dashboard);
    }


}