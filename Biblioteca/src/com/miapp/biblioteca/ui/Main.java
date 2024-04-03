package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblioteca= new ArrayList<>();
        ArrayList<Usuario> usuarios= new ArrayList<>();
        LibroServicio libroService= new LibroServicio(biblioteca);
        UsuarioServicio usuarioService= new UsuarioServicio(usuarios);
        Scanner scanner= new Scanner(System.in);
        int opcion;

        do{
            System.out.println("====BIBLIOTECA VIRTUAL====");
            System.out.println("1-Crear Libro");
            System.out.println("2-Listar Libros");
            System.out.println("3-Buscar libro por ISBN");
            System.out.println("4-Buscar libro por Titulo");
            System.out.println("5-Actualizar Libro");
            System.out.println("6-Eliminar libro");
            System.out.println("7-Prestamos");
            System.out.println("8-Devoluciones");
            System.out.println("9-Crear Usuario");
            System.out.println("10-Ver Usuarios");
            System.out.println("11-Salir");
            System.out.print("Seleccione una Opcion: ");
            opcion= scanner.nextInt();
            scanner.nextLine();


            switch (opcion){
                case 1:
                    System.out.println("Ingrese el Titulo");
                    String titulo= scanner.nextLine();
                    System.out.println("Ingrese el Autor");
                    String autor= scanner.nextLine();
                    System.out.println("Ingrese el ISBN");
                    String ISBN= scanner.nextLine();
                    System.out.println("Ingrese el Genero");
                    String genero= scanner.nextLine();
                    libroService.crearLibro(titulo, autor, ISBN, genero);
                    break;
                case 2:
                    ArrayList<Libro> listaLibros= libroService.verLibros();
                    for(Libro libro: listaLibros){
                        System.out.println(libro.getTitulo()+" - "+ libro.getGenero()+"( "+libro.getISBN()+" )");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar= scanner.nextLine();
                    Libro libroISBN= libroService.buscarLibroPorISBN(isbnBuscar);
                    if(libroISBN !=null) {
                        System.out.println("Libro encontrado: " + libroISBN.getTitulo());
                    }else{
                        System.out.println("Libro no encontrado");}
                    break;


                case 4:
                    System.out.print("Ingrese el Titulo del libro a buscar: ");
                    String tituloBuscar= scanner.nextLine();
                    ArrayList<Libro> librosPorTitulos= libroService.buscarLibroPorTitulo(tituloBuscar);
                      if(!librosPorTitulos.isEmpty()){
                          System.out.println("Libros Encontrados: ");
                          for (Libro libro: librosPorTitulos){
                              System.out.println(libro.getTitulo());
                          }
                      }else{
                          System.out.println("Ningun libro se esncontro con ese Titulo");}
                      break;
                case 5:
                    System.out.println("Ingrese el ISBN del libro a Actualizar");
                    String isbnActualizar= scanner.nextLine();
                    System.out.println("Ingrese el Nuevo Titulo");
                    String tituloActualizado= scanner.nextLine();
                    System.out.println("Ingrese el Nuevo Autor");
                    String autorActualizado= scanner.nextLine();
                    System.out.println("Ingrese el NUevo Genero");
                    String generoActualizado= scanner.nextLine();
                    libroService.actualizarLibro(isbnActualizar,tituloActualizado,autorActualizado,generoActualizado);
                    break;
                case 6:
                    System.out.println("Ingrese el ISBN del LIbro a ELIMINAR");
                    String isbnEliminar= scanner.nextLine();
                    libroService.eliminarLibro(isbnEliminar);
                    break;
                case 7:
                    System.out.println("Ingrese el numero de identificacion del Usuario: ");
                    String idUsuario= scanner.nextLine();
                    Usuario usuarioPrestamo= usuarioService.buscarUsuarioPorId(idUsuario);
                    if(usuarioPrestamo !=null){
                        System.out.println("Ingrese el ISBN del Libro a prestar");
                        String isbnPrestamo=scanner.nextLine();
                        Libro libroPrestamo= libroService.buscarLibroPorISBN(isbnPrestamo);
                        if(libroPrestamo !=null){
                            if(libroService.disponibilidad(libroPrestamo)){
                                usuarioService.prestarLibro(usuarioPrestamo,libroPrestamo);
                                System.out.println("Prestamo exitoso. El libro ha sido prestado a "+usuarioPrestamo.getNombre());
                            }else{
                                System.out.println("El Libro no se encuentra disponible para su Prestamo.");
                            }
                        }else{
                            System.out.println("Libro no encontrado");
                        }
                    }else{
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el numero de identificacion del Usuario");
                    String idUsuario1= scanner.nextLine();
                    Usuario usuarioDevolucion= usuarioService.buscarUsuarioPorId(idUsuario1);
                    if(usuarioDevolucion !=null){
                        System.out.println("Ingrese el ISBN del libro a Devolver");
                        String isbnDevolucion=scanner.nextLine();
                        Libro libroDevolucion= libroService.buscarLibroPorISBN(isbnDevolucion);
                        if(libroDevolucion !=null){
                            usuarioService.devolverLibro(usuarioDevolucion,libroDevolucion);
                            System.out.println("Devolucion Exitosa. El libro ha sido devuelto por "+usuarioDevolucion.getNombre());
                        }else{
                            System.out.println("Libro no encontrado");
                        }
                    }else{
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 9:
                    System.out.println("Ingrese Nombre del Usuario");
                    String nombre= scanner.nextLine();
                    System.out.println("Ingrese el DNI del Usuario");
                    String id= scanner.nextLine();
                    usuarioService.crearUsuario(nombre, id);
                    break;
                case 10:
                    ArrayList<Usuario> listaUsuario= usuarioService.verUsuarios();
                    for(Usuario usuario: listaUsuario){
                        System.out.println(usuario.getNombre()+" - "+ usuario.getId());
                    }
                    break;

                case 11:
                    System.out.println("Gracias por utilizar la Biblioteca VIRTUAL.  Hasta pronto !!!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentenuevamente");
                }
        } while (opcion != 11);

    }
}