package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

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
             * asks the user for thier name and replaces askName variable with greeting using person's name
             * @param the continueBtn button
             */
            public void onClick(View v) {
                askName.setText("Hello " + nameSpace.getText().toString());
            }
        });

    }



}