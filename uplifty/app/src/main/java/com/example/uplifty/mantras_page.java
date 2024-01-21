package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class mantras_page extends AppCompatActivity {
    private ImageButton mantra1, mantra2, mantra3, mantra4;

    private TextView getMantra1, getMantra2, getMantra3, getMantra4;
    private boolean isDoubleClick = false;

    private ArrayList<String> messages = new ArrayList<>();
    private Handler onclickhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantras_page);


        mantra1 = findViewById(R.id.mantraclick3);
        mantra2 = findViewById(R.id.mantraclick2);
        mantra3 = findViewById(R.id.mantraclick1);
        mantra4 = findViewById(R.id.mantraclick);

        getMantra1 = findViewById(R.id.mantraview3);
        getMantra2 = findViewById(R.id.mantraview2);
        getMantra3 = findViewById(R.id.mantraview1);
        getMantra4 = findViewById(R.id.mantraview);

        ArrayList <ImageButton> buttons = new ArrayList<>();

        buttons.add(mantra1);
        buttons.add(mantra2);
        buttons.add(mantra3);
        buttons.add(mantra4);

        for (ImageButton b : buttons){
            b.setOnClickListener(V->{
                if(isDoubleClick){
                    b.setBackgroundColor(Color.GRAY);
                    isDoubleClick = false;
                    Toast.makeText(this, "Unadded from your list", Toast.LENGTH_SHORT).show();
                }else{
                    b.setBackgroundColor(Color.GREEN);
                    isDoubleClick = true;

                    Toast.makeText(this, "Added to your list", Toast.LENGTH_SHORT).show();
                    onclickhandler.postDelayed(()->{
                        if(isDoubleClick){
                            b.setBackgroundColor(Color.GRAY);
                            isDoubleClick = false;
                        }
                    }, 1000000);
                }
            });
        }

    }
}