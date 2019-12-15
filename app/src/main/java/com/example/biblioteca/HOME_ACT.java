package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HOME_ACT extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] images = {R.drawable.android1, R.drawable.android2, R.drawable.android3};
    private ImageButton btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++){
            instrucciones(images[i]);
        }
    }

    public void instrucciones(int i){
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

        btn1 = (ImageButton)findViewById(R.id.btn_libros);
        btn2 = (ImageButton)findViewById(R.id.btn_db);
        btn3 = (ImageButton)findViewById(R.id.btn_segurity);
        btn4 = (ImageButton)findViewById(R.id.btn_info);
    }

    public void libros(View view){
        String[] datos = {"Farenheit", "Revival", "EL Alquimista"};
        Intent i = new Intent(this, LIBROS_ACT.class);
        i.putExtra("libros", datos);
        startActivity(i);
    }

    public void info(View view){
        Intent i = new Intent(this, INFO_ACT.class);
        startActivity(i);
    }

    public void db(View view){
        Intent i = new Intent(this, SQL_Lite_Act.class);
        startActivity(i);
    }

    public void security(View view){
        Intent i = new Intent(this, Security_ACT.class);
        startActivity(i);
    }
}
