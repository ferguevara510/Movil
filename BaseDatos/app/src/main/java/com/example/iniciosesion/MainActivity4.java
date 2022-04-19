package com.example.iniciosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {

    EditText edtxt_titulo;
    EditText sp_genero;
    Button btnGuardar;
    private DatabaseReference bdpeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        edtxt_titulo = findViewById(R.id.et_pelicula);
        sp_genero = findViewById(R.id.et_genero);
        btnGuardar = findViewById(R.id.bn_guardar2);
        bdpeliculas = FirebaseDatabase.getInstance().getReference("Peliculas2022");
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarPelicula();
            }
        });
    }

    public void registrarPelicula(){
        String titulo = edtxt_titulo.getText().toString();
        String genero = sp_genero.getText().toString();
        String _id = bdpeliculas.push().getKey();
        Pelicula peli = new Pelicula(_id,titulo,genero);
        bdpeliculas.child(_id).setValue(peli);
        Toast.makeText(this,"Película registrada", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity4.this,MainActivity6.class);
        startActivity(intent);
    }

}