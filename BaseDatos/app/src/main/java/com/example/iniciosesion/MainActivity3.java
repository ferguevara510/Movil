package com.example.iniciosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private MiOpenHelper miBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText ed_titulo = findViewById(R.id.et_pelicula);
        final EditText ed_cantante = findViewById(R.id.et_cantante);
        final Button btn_guardarC = findViewById(R.id.bt_guardar);

        miBD = new MiOpenHelper(this);

        btn_guardarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = ed_titulo.getText().toString();
                String cantante = ed_cantante.getText().toString();
                miBD.insertarCancion(titulo,cantante);
                Toast.makeText(MainActivity3.this,"Se guardó la canción", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this,MainActivity5.class);
                startActivity(intent);
            }
        });
    }

}