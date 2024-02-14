package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button continueBtn;
    private EditText nameSpace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting fields to their respective IDs
        continueBtn = findViewById(R.id.continueBtn);
        nameSpace = findViewById(R.id.nameSpace);

        final String btnTxt = "Continue";
        continueBtn.setText(btnTxt); //Display Continue

        final String txtHint = "Name";
        nameSpace.setHint(txtHint); //Display "Name" hint

        /*
          Lambda expression to open the welcome page
          @param v the button that is clicked
         */
        continueBtn.setOnClickListener(v->{
            String name = nameSpace.getText().toString();
            Intent welcomePage = new Intent(this, welcomePage.class);
            welcomePage.putExtra("Name", name);
            startActivity(welcomePage);
        });

    }

    public String getNameSpace(){
        return nameSpace.getText().toString();
    }
}