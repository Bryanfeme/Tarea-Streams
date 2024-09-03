package org.example.EjercicioSeccion3;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        // Películas estrenadas en el siglo XXI
        List<Pelicula> sigloXXI = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .collect(Collectors.toList());
        System.out.println("\nPelículas del siglo XXI:");
        sigloXXI.forEach(System.out::println);

        // Títulos de películas de Steven Spielberg
        List<String>  titulosSpielberg = peliculas.stream()
                .filter(p -> p.getDirector().equals("Steven Spielberg"))
                .map(Pelicula::getTitulo)
                .collect(Collectors.toList());
        System.out.println("\nPelículas de Steven Spielberg: ");
        titulosSpielberg.forEach(System.out::println);

        // Nombres de películas ordenados alfabéticamente
        List<String> titulosOrdenados = peliculas.stream()
                .map(Pelicula::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\nPelículas ordenadas alfabéticamente:");
        titulosOrdenados.forEach(System.out::println);

        // Año de estreno más reciente
        OptionalInt añoMasReciente = peliculas.stream()
                .mapToInt(Pelicula::getEstreno)
                .max();
        if (añoMasReciente.isPresent()) {
            System.out.println("\nAño de estreno más reciente: \n" + añoMasReciente.getAsInt());
        } else {
            System.out.println("No hay películas en la lista.");
        }
    }
}
