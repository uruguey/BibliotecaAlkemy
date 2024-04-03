package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String id;
    private ArrayList<Libro> librosPrestados;

    //CONSTRUCTORES


    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public Usuario() {
    }

    //GETTERS AND SETTRES

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }
    //TOSTRING

    @Override
    public String toString() {
        return "Usuario:" +
                "Nombre:" + nombre +
                ", Id: " + id +'.';
    }
}
