import Builder.Usuario;
import Factory.Libro;
import Factory.LibroFisico;
import Singleton.Database;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        //Singleton
        Database db1 = Database.getInstance(); // Obtener instancia de la base de datos
        db1.agregarLibro(new LibroFisico("El Quijote", "Miguel de Cervantes", "tercera edicion"));

        Database db2 = Database.getInstance();          // Obtener otra "instancia" (en realidad es la misma)
        db2.agregarLibro(new LibroFisico("Cien Años de Soledad", "Gabriel García Márquez", "segunda edicion"));

        System.out.println(db1.getLibros());



        //Builder
        Usuario user1 = new Usuario.Builder()
                .setNombreUsuario("Pedro Gomez")
                .setDireccion("Colon 812")
                .setEmail("pgomez@gmail.com")
                .setTelefono("2618834946")
                .setFechaNacimiento(LocalDate.of(2005,9,3))
                .build();

        Usuario user2 = new Usuario.Builder()
                .setNombreUsuario("Laura Castillo")
                .setDireccion("Fray Luis Beltran 902")
                .setEmail("laura_castillo@gmail.com")
                .setTelefono("2612983740")
                .setFechaNacimiento(LocalDate.of(2000,12,18))
                .build();

        System.out.println(user1);
        System.out.println(user2);


    }

}