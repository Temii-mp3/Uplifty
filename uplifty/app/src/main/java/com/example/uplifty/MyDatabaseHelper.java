package com.example.uplifty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "mantras.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_mantras";

    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_MANTRAS = "mantras";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "  (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_MANTRAS + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    void addMantra(String mantra){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MANTRAS, mantra);

       long result = db.insert(TABLE_NAME, null, cv);

       if (result == -1){
           Toast.makeText(context, "Failed to add mantra", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(context, "Added to your list", Toast.LENGTH_SHORT).show();
       }
    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        //check if database is not null
        if(db != null){
            db.rawQuery(query, null);
        }
        return cursor;
    }
}