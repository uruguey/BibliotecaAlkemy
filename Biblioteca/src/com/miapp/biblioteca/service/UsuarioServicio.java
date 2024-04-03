package com.miapp.biblioteca.service;


import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioServicio {
           private ArrayList<Usuario> usuarios;

        //CONSTRUCTOR


    public UsuarioServicio(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void crearUsuario(String nombre, String id){
            Usuario nuevoUsuario = new Usuario(nombre,id);
            usuarios.add(nuevoUsuario);
        }

        public ArrayList<Usuario> verUsuarios() {
            return usuarios;
        }

        public void actualizarUsuario(String id,String nuevoNombre){
            for(Usuario usuario: usuarios){
                if(usuario.getId().equals(id)){
                    usuario.setNombre(nuevoNombre);
                    return;
                }
            }
        }

        public void eliminarUsuario(String id){
            Iterator<Usuario> it= usuarios.iterator();
            while (it.hasNext()){
                if (it.next().getId().equals(id)){
                    it.remove();
                }
            }
        }
        public void prestarLibro(Usuario usuario, Libro libro){
        if(libro.isDisponible()){
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
        } else {
            System.out.println("El Libro no se encuentra diponible para su prestamo");
        }
        }

        public Usuario buscarUsuarioPorId(String id){
        for(Usuario usuario: usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
        }

        public void devolverLibro(Usuario usuario,Libro libro){
        if(usuario.getLibrosPrestados().contains(libro)){
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        }else {
            System.out.println("Este libro no fue prestado a este usuario");
        }
        }
        public ArrayList<Libro> librosPrestados(Usuario usuario){
        return usuario.getLibrosPrestados();
        }
    }


