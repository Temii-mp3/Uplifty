package com.example.uplifty;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "mantras.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_NAME = "my_mantras";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_MANTRAS = "mantras";

    /**
     *private static final String COLUMN_ALL_ID = "_appID";
     *private static final String TABLE_ALL_MANTRAS = "all_mantras";
     *private static final String COLUMN_ALL_MANTRAS = "app_mantras";
      */

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "  (" + COLUMN_ID + " INTEGER PRIMARY KEY , " +
                        COLUMN_MANTRAS + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//TODO figure out how to add in multiple tables so users can have a "Favourite mantras" option

//    void addMantra(String mantra){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(COLUMN_MANTRAS, mantra);
//
//       long result = db.insert(TABLE_NAME, null, cv);
//
//       if (result == -1){
//           Toast.makeText(context, "Failed to add mantra", Toast.LENGTH_SHORT).show();
//       }else{
//           Toast.makeText(context, "Added to your list", Toast.LENGTH_SHORT).show();
//       }
//    }

    void addAllMantras(String n){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MANTRAS, n);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1){
            Toast.makeText(context, "Failed to add mantra", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added to your list", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    Cursor readAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = null;

        //check if database is not null
        if(db != null){
           cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void resetPrimaryKey(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        db.close();
    }

    void deleteALlData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
