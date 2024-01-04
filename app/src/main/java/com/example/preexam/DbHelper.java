package com.example.preexam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, MeubleContract.DB_NAME, null, MeubleContract.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(MeubleContract.MeubleEntry.SQL_CREATE_ENTRIES);
        db.execSQL(MeubleContract.CategoryEntry.SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(MeubleContract.MeubleEntry.SQL_DELETE_ENTRIES);
        db.execSQL(MeubleContract.CategoryEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public Cursor getMeublesCursor() {
        // Define the columns you want to retrieve
        String[] projection = {
                MeubleContract.MeubleEntry._ID,
                MeubleContract.MeubleEntry.COLUMN_NAME,
                MeubleContract.MeubleEntry.COLUMN_PRICE,
                MeubleContract.MeubleEntry.COLUMN_DESCRIPTION
        };

        // Query the database
        return this.getReadableDatabase().query(
                MeubleContract.MeubleEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
    public ArrayList<Meuble> getMeubles() {
        ArrayList<Meuble> meubles = new ArrayList<>();

        // Define the columns you want to retrieve
        String[] projection = {
                MeubleContract.MeubleEntry.COLUMN_NAME,
                MeubleContract.MeubleEntry.COLUMN_PRICE,
                MeubleContract.MeubleEntry.COLUMN_DESCRIPTION
        };

        // Query the database
        try (Cursor cursor = this.getReadableDatabase().query(
                MeubleContract.MeubleEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        )) {
            // Iterate through the cursor
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(MeubleContract.MeubleEntry.COLUMN_NAME));
                String price = cursor.getString(cursor.getColumnIndexOrThrow(MeubleContract.MeubleEntry.COLUMN_PRICE));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(MeubleContract.MeubleEntry.COLUMN_DESCRIPTION));

                // Create a Meuble object and add it to the list
                meubles.add(new Meuble(name, price, description));
            }
        }

        return meubles;
    }

}
