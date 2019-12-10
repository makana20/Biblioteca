package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Github_act extends AppCompatActivity {
    private Spinner spn;
    private TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spn = (Spinner)findViewById(R.id.spinner2);
        tx = (TextView)findViewById(R.id.message_text);

        Bundle dato = getIntent().getExtras();
        String[] libro = dato.getStringArray("libros");
        String[] precio = dato.getStringArray("precios");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, libro);
        spn.setAdapter(adapter);
    }
}
