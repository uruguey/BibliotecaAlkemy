package com.miapp.biblioteca;

public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private boolean disponible;

    //CONSTRUCTORES
    public Libro(String titulo, String autor, String ISBN, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.disponible = true;
    }
    public Libro() {
    }

    //GETTERS AND SETTERS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    //@TOSTRING

    @Override
    public String toString() {
        return "Este libro corresponde: " +
                "Titulo: " + titulo +
                ", su Autor: " + autor +
                ", ISBN: " + ISBN +
                ", su Genero: " + genero +
                "y su estados es:" + disponible+".";
    }
}
