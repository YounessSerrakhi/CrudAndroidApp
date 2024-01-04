package com.example.preexam;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MeubleAdapter extends CursorAdapter {
    public MeubleAdapter(Context context, Cursor meubles) {
        super(context, meubles, 0);
    }

    @Override
    public View newView(Context context, android.database.Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
    }

    @Override
    public void bindView(View view, Context context, android.database.Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndexOrThrow(MeubleContract.MeubleEntry.COLUMN_NAME));
        String price = cursor.getString(cursor.getColumnIndexOrThrow(MeubleContract.MeubleEntry.COLUMN_PRICE));
        String description = cursor.getString(cursor.getColumnIndexOrThrow(MeubleContract.MeubleEntry.COLUMN_DESCRIPTION));
        String text = name + " " + price + " " + description;
        TextView t= view.findViewById(android.R.id.text1);
        t.setText(text);
    }


}
