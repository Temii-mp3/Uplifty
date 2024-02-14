package com.example.uplifty;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class mantras_page extends AppCompatActivity {
    private ImageButton mantra1, mantra2, mantra3, mantra4;

    private MyDatabaseHelper myDB;

    private TextView getMantra1, getMantra2, getMantra3, getMantra4;
    private boolean isDoubleClick = false;

    private ArrayList<String> mantras = new ArrayList<>();
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
        ArrayList <TextView> mantras = new ArrayList<>();

        mantras.add(getMantra1);
        mantras.add(getMantra2);
        mantras.add(getMantra3);
        mantras.add(getMantra4);


        buttons.add(mantra1);
        buttons.add(mantra2);
        buttons.add(mantra3);
        buttons.add(mantra4);


        for(int i = 0; i < mantras.size(); i++){
            final int index = i;
            ImageButton b = buttons.get(index);
            b.setOnClickListener(V->{
                MyDatabaseHelper myDB = new MyDatabaseHelper(mantras_page.this);
                myDB.addMantra(mantras.get(index).getText().toString());
                System.out.println(mantras.get(index).toString());

                if(isDoubleClick){
                    b.setBackgroundColor(Color.GRAY);
                    isDoubleClick = false;
                    Toast.makeText(this, "Unadded from your list", Toast.LENGTH_SHORT).show();
                }else{
                    b.setBackgroundColor(Color.GREEN);
                    isDoubleClick = true;
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

    private void storeData(MyDatabaseHelper db){
        Cursor cursor = db.readAllData();

        //check if there are any mantras stored
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Mantra to display", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                mantras.add(cursor.getString(0));
            }
        }
    }
    public String getDat(){
        Random randomGen = new Random();
        int randManta = randomGen.nextInt(4);

        return mantras.get(randManta);
    }
}