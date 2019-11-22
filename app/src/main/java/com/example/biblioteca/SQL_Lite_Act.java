package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SQL_Lite_Act extends AppCompatActivity {
    private EditText et1, et2, et3;

    // Creamos instancia de nuestra clase.
    private AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);

    // Sobreescribimos nuestra base de datos
    private SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql__lite_);

        et1 = (EditText)findViewById(R.id.ingCodigo);
        et2 = (EditText)findViewById(R.id.ingNombre);
        et3 = (EditText)findViewById(R.id.ingPrecio);
    }

    // Añade ordenadores a nuestra tabla.
    public void anadirLibro(View view){

        // Comprobamos que nuestros registro no esta vacio.
        if(!et1.getText().toString().isEmpty()){
            // Contendra nuestros registros a ingresar.
            ContentValues registro = new ContentValues();

            // Agregamos nuestros datos extraidos.
            registro.put("codigo", Integer.valueOf(et1.getText().toString()));
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", Float.parseFloat(et3.getText().toString()));

            // Agregamos el registro a nuestra base de datos.
            baseDeDatos.insert("libros", null, registro);

            // Cerramos nuestra base de datos.
            baseDeDatos.close();

            // Mensaje validando la inseccion de Datos.
            Toast.makeText(this, "Se a ingresado un nuevo libro", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Complete los campos vacios", Toast.LENGTH_LONG).show();
        }
    }

    // Modificamos datos de nuestra tabla.
    public void modificarLibro(View view){

        if(!et1.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", Integer.valueOf(et1.getText().toString()));
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", Float.parseFloat(et3.getText().toString()));

            baseDeDatos.update("libros", registro, et1.getText().toString(), null);

            baseDeDatos.close();

            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Complete el campo codigo se encuentra vacio", Toast.LENGTH_LONG).show();
        }
    }

    // Eliminar datos de nuestra tabla.
    public void eliminarLibro(View view){

        if(!et1.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", Integer.valueOf(et1.getText().toString()));
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", Float.parseFloat(et3.getText().toString()));

            baseDeDatos.delete("libros", et1.getText().toString(), null);

            baseDeDatos.close();

            Toast.makeText(this, "Datos eliminado", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Complete el campo codigo se encuentra vacio", Toast.LENGTH_LONG).show();
        }
    }
}
