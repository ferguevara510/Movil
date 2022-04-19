package com.example.iniciosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String apodo = (String) getIntent().getExtras().getSerializable("apodo");
        bienvenida = findViewById(R.id.txtview_bienvenida);
        guardarApodo(apodo);
        mostrarApodo();
        final Button btnCanciones = findViewById(R.id.btn_canciones);
        final Button btnPeliculas = findViewById(R.id.btn_peliculas);
        btnCanciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        btnPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(intent);
            }
        });

    }

    public void guardarApodo (String apodo){
        SharedPreferences miPreferenciaCOmpartida = getSharedPreferences("MisDatos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = miPreferenciaCOmpartida.edit();
        editor.putString("apodo",apodo);
        editor.commit();
        Toast.makeText(MainActivity2.this,"Se guardó el apodo", Toast.LENGTH_LONG).show();
    }

    public void mostrarApodo (){
        SharedPreferences miPreferenciaCOmpartida = getSharedPreferences("MisDatos", Context.MODE_PRIVATE);
        String apodo = miPreferenciaCOmpartida.getString("apodo","");
        bienvenida.append(" "+apodo);
    }

}