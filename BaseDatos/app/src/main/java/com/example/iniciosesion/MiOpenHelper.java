package com.example.iniciosesion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MiOpenHelper extends SQLiteOpenHelper {

    private static final String CANCIONES_TABLA = "CREATE TABLE canciones (_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, cantante TEXT)";
    private static final String DB_NAME = "canciones.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase BD;

    public MiOpenHelper (Context context){
        super (context, DB_NAME, null, DB_VERSION);
        BD = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CANCIONES_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertarCancion(String titulo, String cantante){
        ContentValues cv = new ContentValues();
        cv.put("titulo",titulo);
        cv.put("cantante",cantante);
        BD.insert("canciones",null,cv);
    }

    public ArrayList<Cancion> consultarCanciones(){
        ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
        Cursor c = BD.rawQuery("SELECT _id, titulo, cantante FROM canciones",null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            do{
                int id = c.getInt(c.getColumnIndexOrThrow("_id"));
                String titulo = c.getString(c.getColumnIndexOrThrow("titulo"));
                String cantante = c.getString(c.getColumnIndexOrThrow("cantante"));
                Cancion canc = new Cancion(id,titulo,cantante);
                listaCanciones.add(canc);
            }while(c.moveToNext());
        }
        c.close();
        return listaCanciones;
    }

}
