package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SQL_Lite_Act extends AppCompatActivity {
    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql__lite_);

        et1 = (EditText)findViewById(R.id.ingCodigo);
        et2 = (EditText)findViewById(R.id.ingNombre);
        et3 = (EditText)findViewById(R.id.ingPrecio);
    }
}
