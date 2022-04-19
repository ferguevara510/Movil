package com.example.iniciosesion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    ListView listV_Peliculas;
    ArrayList<String> listpelis_string;
    ArrayAdapter<String> adaptador;
    private DatabaseReference bdpeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        bdpeliculas = FirebaseDatabase.getInstance().getReference();
        Query query = bdpeliculas.child("Peliculas2022");
        listV_Peliculas = (ListView) findViewById(R.id.listaPeliculas);
        listpelis_string = new ArrayList<String>(0);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot peli: snapshot.getChildren()){
                        String titulo = peli.child("titulo").getValue().toString();
                        String genero = peli.child("genero").getValue().toString();
                        listpelis_string.add(titulo+" - "+ genero);
                        adaptador = new ArrayAdapter<String>(MainActivity6.this, android.R.layout.simple_list_item_1,listpelis_string);
                        listV_Peliculas.setAdapter(adaptador);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}