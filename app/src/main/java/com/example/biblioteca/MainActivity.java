package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private EditText tx1;
    private EditText tx2;
    private ProgressBar pbar;
    private Button btn;
    private String[] datos = {"Farenheit", "Revival", "El Alquimista"};
    private String[] datos2 = {"5000", "12000", "45000", "88000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = (EditText)findViewById(R.id.txUsuario);
        tx2 = (EditText)findViewById(R.id.txPassword);
        pbar = (ProgressBar)findViewById(R.id.progressBarLogin);
        btn = (Button)findViewById(R.id.btn_login);

        pbar.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new Tack().execute(tx1.getText().toString());
            }
        });
    }


    public void gitHub(View view){
        Intent i = new Intent(getBaseContext(), Github_act.class);
        i.putExtra("libros", datos);
        i.putExtra("precios", datos2);
        startActivity(i);
    }

    public void location(View view){
        Intent i = new Intent(getBaseContext(), MapsActivity.class);
        startActivity(i);
    }



    class Tack extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            pbar.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(3000);
                mostrar();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pbar.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
            Toast.makeText(getBaseContext(), "Acceso Concedido", Toast.LENGTH_SHORT).show();
        }

        public void mostrar(){
            Intent i = new Intent(getBaseContext(), HOME_ACT.class);
            i.putExtra("nombre", tx1.getText().toString());
            i.putExtra("password", tx2.getText().toString());
            startActivity(i);
        }
    }
}
