package com.example.preexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddMeubleActivity extends AppCompatActivity {

    DbHelper dbHelper;
    SQLiteDatabase db;
    Button addButton;
    TextView name;
    TextView price;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meuble);  // Move setContentView here
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();
        addButton = findViewById(R.id.addButton);
        name = findViewById(R.id.nameEditText);
        price = findViewById(R.id.priceEditText);
        description = findViewById(R.id.descriptionEditText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(MeubleContract.MeubleEntry.COLUMN_NAME, name.getText().toString());
                values.put(MeubleContract.MeubleEntry.COLUMN_PRICE, price.getText().toString());
                values.put(MeubleContract.MeubleEntry.COLUMN_DESCRIPTION, description.getText().toString());
                db.insert(MeubleContract.MeubleEntry.TABLE_NAME, null, values);
                finish();
            }
        });
    }
}
