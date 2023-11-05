package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button continueBtn;
    private EditText nameSpace;
    private TextView askName;

    //setting fields to their respective IDs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueBtn = findViewById(R.id.continueBtn);
        nameSpace = findViewById(R.id.nameSpace);
        askName = findViewById(R.id.askName);




        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Anonymous class created for the continueBtn Button
             * opens the welcome page
             * @param the continueBtn button
             */
            public void onClick(View v) {
                openWelcomePage();
            }
        });

    }

    //opens the welcomepage
    private void openWelcomePage(){
        String name = nameSpace.getText().toString();
        Intent welcomePage = new Intent(this, welcomePage.class);
        welcomePage.putExtra("Name", name);
        startActivity(welcomePage);
    }



}