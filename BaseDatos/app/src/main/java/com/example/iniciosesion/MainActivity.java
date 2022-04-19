package com.example.iniciosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre_et;
    EditText contraseña_et;
    EditText apodo_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre_et = findViewById(R.id.et_pelicula);
        contraseña_et = findViewById(R.id.et_contraseña);
        apodo_et = findViewById(R.id.et_apodo);
    }

    public void entrar(View view){
        String nombre = nombre_et.getText().toString();
        String contraseña = contraseña_et.getText().toString();
        String apodo = apodo_et.getText().toString();
        if (nombre.equals("FerGuev") && contraseña.equals("12345")){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("apodo",apodo);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Datos incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}