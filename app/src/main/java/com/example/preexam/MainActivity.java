package com.example.preexam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;
    Button addButton;
    Cursor meubles;
    ListView listView;
    MeubleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables inside onCreate
        dbHelper = new DbHelper(this);
        addButton = findViewById(R.id.addMeubleButton);
        meubles = dbHelper.getMeublesCursor();
        listView = findViewById(R.id.meubleListView);
        adapter = new MeubleAdapter(this, meubles);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMeubleActivity.class);
                startActivity(intent);
            }
        });
    }

    // Other lifecycle methods...
}
