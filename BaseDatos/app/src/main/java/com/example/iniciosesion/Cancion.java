package com.example.iniciosesion;

public class Cancion {

    int id;
    String titulo;
    String cantante;

    public Cancion(int id, String titulo, String cantante) {
        this.id = id;
        this.titulo = titulo;
        this.cantante = cantante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

}
