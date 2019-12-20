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

        tx = (TextView) findViewById(R.id.text_tipo_vul);
        btn_vul1 = (Button) findViewById(R.id.btn_vul1);
        btn_vul2 = (Button) findViewById(R.id.btn_vul2);
        btn_vul3 = (Button) findViewById(R.id.btn_vul3);
    }

    public void vulnerabilidad_1(View view) {
        String username = "Andres";
        String password = "1234asl";

        msg = "Encriptación de datos:\n" + username + "\n" + password;

        tx.setText(msg);
    }

    public void vulnerabilidad_2(View view) {
        ContentValues datos = new ContentValues();

        datos.put("Andres", "Rolando");
        datos.put("edad", "25");

        msg = "Desbr de Memoria";

        tx.setText(msg);
    }
}