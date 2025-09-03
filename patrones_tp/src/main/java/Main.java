package main.java;

import main.java.builder.Usuario;
import main.java.factory.*;
import main.java.prototype.Prestamo;
import main.java.singleton.Database;
import main.java.abstractFactory.*;

public class Main {
    public static void main(String[] args) {

        // Singleton && Factory Method

        Database db = Database.getInstance();

        Libro libro1 = LogisticaLibro.crearLibro("El Quijote", "Cervantes", "Físico");
        Libro libro2 = LogisticaLibro.crearLibro("1984", "George Orwell", "Digital");

        db.agregarLibro(libro1);
        db.agregarLibro(libro2);

        System.out.println("Libros en la base de datos:");
        for (Libro l : db.getLibros()) {
            System.out.println("- " + l.getTitulo() + " de " + l.getAutor() + ", de tipo " + l.getTipo());
        }

        // AbstractFactory

        AbstractFactory adminFactory = new AdminFactory();
        AbstractFactory usuarioFactory = new UsuarioFactory();

        InterfazUI adminUI = adminFactory.crearUI();
        MetodoEnvio adminEnvio = adminFactory.crearEnvio();

        adminUI.mostrarUI();
        adminEnvio.enviar(String.valueOf(libro2));

        InterfazUI usuarioUI = usuarioFactory.crearUI();
        MetodoEnvio usuarioEnvio = usuarioFactory.crearEnvio();

        usuarioUI.mostrarUI();
        usuarioEnvio.enviar(String.valueOf(libro1));

        // Builder

        Usuario usuario1 = Usuario.builder()
                .nombre("Santiago")
                .email("santi@gmail.com")
                .telefono("2614455787")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Juan")
                .email("juan@gmail.com")
                .direccion("Luján de Cuyo")
                .build();

        System.out.println(" ");
        System.out.println("Usuarios creados:");
        System.out.println(usuario1);
        System.out.println(usuario2);


        // Prototype
        Prestamo prestamoPrototype = Prestamo.builder()
                .libro(libro1)
                .usuario(usuario1)
                .fechaInicio("2025-09-03")
                .fechaFin("2025-09-10")
                .build();

        Prestamo prestamo1 = prestamoPrototype.clone();
        prestamo1.setUsuario(usuario2);
        prestamo1.setFechaFin("2025-09-08");

        Prestamo prestamo2 = prestamoPrototype.clone();
        prestamo2.setLibro(libro2);

        System.out.println(" ");
        System.out.println("Préstamos:");
        System.out.println(prestamo1);
        System.out.println(prestamo2);

    }
}