package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void anadirLibro(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty()){

            ContentValues registro = new ContentValues();

            registro.put("codigo", Integer.valueOf(et1.getText().toString()));
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", Float.parseFloat(et3.getText().toString()));
            BaseDeDatos.insert("LIBROS", null, registro);
            BaseDeDatos.close();
            Toast.makeText(this, "Se a ingresado un nuevo libro", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Complete los campos vacios", Toast.LENGTH_LONG).show();
        }
    }


    public void eliminarLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty()){
            String codigo = et1.getText().toString();
            BaseDeDatos.delete("LIBROS", "codigo=" + codigo, null);
            BaseDeDatos.close();
            Toast.makeText(this, "Datos eliminado", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Complete el campo codigo se encuentra vacio", Toast.LENGTH_LONG).show();
        }
    }


    public void modificarLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();
            String codigo = et1.getText().toString();

            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            BaseDeDatos.update("LIBROS", registro,"codigo=" + codigo, null);

            BaseDeDatos.close();

            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Complete el campo codigo se encuentra vacio", Toast.LENGTH_LONG).show();
        }
    }
}
