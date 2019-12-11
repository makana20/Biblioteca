package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class Github_act extends AppCompatActivity {
    private Spinner spn;
    private TextView tx;
    private String[] libro;
    private String[] precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spn = (Spinner)findViewById(R.id.spinner2);
        tx = (TextView)findViewById(R.id.message_text);

        Bundle dato = getIntent().getExtras();
        libro = dato.getStringArray("libros");
        precio = dato.getStringArray("precios");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, libro);
        spn.setAdapter(adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                tx.setText("El valor de " + item.toString() + " es: " + precio[pos]);
            }

            public void onNothingSelected(AdapterView<?> parent){}
        });
    }
}
