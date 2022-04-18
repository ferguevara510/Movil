package com.example.iniciosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String apodo = (String) getIntent().getExtras().getSerializable("apodo");
        bienvenida = findViewById(R.id.txtview_bienvenida);
        bienvenida.append(" "+apodo);
    }
}