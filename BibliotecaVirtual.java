/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecavirtual;

import java.util.ArrayList;
import java.util.Scanner;

class Libro {
    String titulo;
    String autor;
    int antiguedadDePublicacion;
    String genero;
    boolean disponible; 
    String comentario;
    int calificacion;

    public Libro(String t, String a, int antiguedad, String g) {
        titulo = t;
        autor = a;
        antiguedadDePublicacion = antiguedad;
        genero = g;
        disponible = true;
        comentario = "";
        calificacion = 0;
    }
}

public class BibliotecaVirtual {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();

        System.out.println("Bienvenidos a la biblioteca virtual");

        int opcion;
        do {
            System.out.println("Menu de opciones:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Agregar comentario a un libro");
            System.out.println("7. Ver comentario de un libro");
            System.out.println("8. Calificar un libro");
            System.out.println("9. Ver calificacion promedio de los libros");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Antiguedad de publicacion: ");
                    int antiguedad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Genero: ");
                    String genero = scanner.nextLine();
                    libros.add(new Libro(titulo, autor, antiguedad, genero));
                    System.out.println("Libro agregado con exito.");
                    break;

                case 2:
                    System.out.print("Introduce el titulo o autor a buscar: ");
                    String busqueda = scanner.nextLine();
                    boolean encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.titulo.contains(busqueda) || libro.autor.contains(busqueda)) {
                            System.out.println("Titulo: " + libro.titulo + " | Autor: " + libro.autor + " | Fecha en que fue publicado: " + libro.antiguedadDePublicacion);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontraron libros disponibles con ese titulo o autor.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce el titulo del libro que se va prestar: ");
                    String prestar = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.titulo.equalsIgnoreCase(prestar)) {
                            if (libro.disponible) {
                                libro.disponible = false;
                                System.out.println("El libro se ha prestado exitosamente.");
                            } else {
                                System.out.println("El libro ya esta prestado y no se puede prestar de nuevo.");
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El libro no se encuentra disponible.");
                    }
                    break;

                case 4: 
                    System.out.print("Introduce el titulo del libro a devolver: ");
                    String devolver = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.titulo.equalsIgnoreCase(devolver)) {
                            if (!libro.disponible) {
                                libro.disponible = true;
                                System.out.println("El libro ha sido devuelto a la Biblioteca Virtual.");
                            } else {
                                System.out.println("El libro ya estaba disponible para ser prestado.");
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro el libro disponible.");
                    }
                    break;

                case 5: 
                    boolean hayLibros = false;
                    for (Libro libro : libros) {
                        if (libro.disponible) {
                            System.out.println("Libro " + libro.titulo + " | Autor: " + libro.autor + " | Antiguedad: " + libro.antiguedadDePublicacion);
                            hayLibros = true;
                        }
                    }
                    if (!hayLibros) {
                        System.out.println("No hay libros disponibles.");
                    }
                    break;

                case 6:
                    System.out.print("Introduce el titulo del libro: ");
                    String libroComentario = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.titulo.equalsIgnoreCase(libroComentario)) {
                            System.out.print("Escribe tu comentario: ");
                            libro.comentario = scanner.nextLine();
                            System.out.println("Comentario agregado.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro el libro disponible.");
                    }
                    break;

                case 7:
                    System.out.print("Introduce el titulo del libro: ");
                    String libroVerComentario = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.titulo.equalsIgnoreCase(libroVerComentario)) {
                            if (libro.comentario.isEmpty()) {
                                System.out.println("Este libro no tiene comentarios.");
                            } else {
                                System.out.println("Comentario: " + libro.comentario);
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro el libro disponible.");
                    }
                    break;

                case 8:
                    System.out.print("Introduce el titulo del libro: ");
                    String libroCalificacion = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : libros) {
                        if (libro.titulo.equalsIgnoreCase(libroCalificacion)) {
                            System.out.print("Introduce una calificacion (1-10): ");
                            libro.calificacion = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("⭐ Calificacion agregada.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro el libro disponible.");
                    }
                    break;

                case 9:
                    int suma = 0, cantidad = 0;
                    for (Libro libro : libros) {
                        if (libro.calificacion > 0) {
                            suma += libro.calificacion;
                            cantidad++;
                        }
                    }
                    if (cantidad == 0) {
                        System.out.println("No hay calificaciones para este libro.");
                    } else {
                        System.out.println("Califaciones: " + (suma / (double) cantidad));
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}