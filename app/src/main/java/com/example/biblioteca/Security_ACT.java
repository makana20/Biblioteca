package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Security_ACT extends AppCompatActivity {
    private TextView tx;
    private Button btn_vul1, btn_vul2, btn_vul3;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security__act);

        tx = (TextView)findViewById(R.id.text_tipo_vul);
        btn_vul1 = (Button)findViewById(R.id.btn_vul1);
        btn_vul2 = (Button)findViewById(R.id.btn_vul2);
        btn_vul3 = (Button)findViewById(R.id.btn_vul3);
    }

    public void vulnerabilidad_1(View view){
        String username = "";
        String password = "";

        // Las variables nunca deben ser visibles si es posible estas deben se encriptadas para
        // evitar su manipulación y desemcriptadas para su utilizacion dentro de un programa.
        msg = "Encriptación de datos:\n" + username + "\n" + password;

        tx.setText(msg);
    }

    public void vulnerabilidad_2(View view){
        ContentValues datos = new ContentValues();

        // Agregar datos sin especificar su tamaño y confirmacion de estado es una vulnerabilidad
        // importante ya que esta puede probocar desbordamiento de memoria y abrir una puerta para
        // vulnerar la seguridad de esta.
        datos.put("nombre", "carlos");
        datos.put("edad", "23");

        msg = "Desbordamiento de Memoria";

        tx.setText(msg);
    }

    public void vulnerabilidad_3(View view){
        String url = "https://www.google.cl";
        String user = "jose";
        String address = "la florida";
        String query = "insert into user where name = " + user;

        // El no utilizar metodos de conexion y validacion de datos para la insercion de estos a
        // una base de datos es una vulnerabilidad grave ja que puede ser sujeta a una inserción
        // de sql, el utilizar los metodos proporcionados por los frame o api de conexion nos,
        // permitiran validar los datos de entrada y tambien evitar realizar ingreso de query de
        // forma manual las que pueden ser manipuladas si son vulneradas.
        msg = "Injeccion de SQL";

        tx.setText(msg);
    }
}
