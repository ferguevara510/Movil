package com.example.iniciosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private MiOpenHelper BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        BD = new MiOpenHelper(this);
        ArrayList<Cancion> listaCanc = BD.consultarCanciones();
        ArrayList<String> listaCancString = new ArrayList<>(listaCanc.size());
        for (Cancion c: listaCanc){
            listaCancString.add(c.getTitulo()+ "-"+ c.getCantante());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaCancString);
        ListView listaview = (ListView) findViewById(R.id.listaCanciones);
        listaview.setAdapter(adaptador);
    }

}