package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LIBROS_ACT extends AppCompatActivity {
    private Spinner spn;
    private TextView txV;
    private EditText tx1, tx2;
    private String[] precios = new String[]{"5000", "12000", "25000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros__act);

        spn = (Spinner)findViewById(R.id.spinner);
        txV = (TextView)findViewById(R.id.tx_resultado);
        tx1 = (EditText)findViewById(R.id.tx_stock);
        tx2 = (EditText)findViewById(R.id.tx_prestamo);

        Bundle dato = getIntent().getExtras();
        String[] libro = dato.getStringArray("libros");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, libro);
        spn.setAdapter(adapter);
    }

    public void calcular(View view){
        if(spn.getSelectedItem().equals("Farenheit")){
            String precio = precios[0];
            int st = Integer.parseInt(tx1.getText().toString());
            int cp = Integer.parseInt(tx2.getText().toString());
            int pc = Integer.parseInt(precio);
            int resultado = pc * st + cp;

            txV.setText("Stock disponible: "+ st + "\n"
                    + "Precio final: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Revival"))
        {
            String precioRevival = precios[1];

            int stock = Integer.parseInt(tx1.getText().toString());
            int costo = Integer.parseInt(tx2.getText().toString());
            int precioLibro = Integer.parseInt(precioRevival);

            int resultado = precioLibro*stock+costo;

            txV.setText("Stock disponible: " +stock+ "\n"
                    +"el precio final es: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Tesla"))
        {
            String precioTesla = precios[2];

            int stock = Integer.parseInt(tx1.getText().toString());
            int costo = Integer.parseInt(tx2.getText().toString());
            int precioLibro = Integer.parseInt(precioTesla);

            int resultado = precioLibro*stock+costo;

            txV.setText("Stock disponible: " +stock+ "\n"
                    +"el precio final es: "+ resultado);
        }
    }
}
