package com.example.iniciosesion;

public class Pelicula {

    public String _id;
    public String titulo;
    public String genero;

    public Pelicula(String _id, String titulo, String genero) {
        this._id = _id;
        this.titulo = titulo;
        this.genero = genero;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
