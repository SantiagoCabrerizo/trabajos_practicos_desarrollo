import Factory.Libro;
import Factory.LibroFisico;
import Prototype.Prestamo;
import Singleton.Database;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Singleton
        System.out.println("------------PARTE 1 ---------------");

        Database db1 = Database.getInstance(); // Obtener instancia de la base de datos
        db1.agregarLibro(new LibroFisico("El Quijote", "Miguel de Cervantes", "tercera edicion"));

        Database db2 = Database.getInstance();          // Obtener otra "instancia" (en realidad es la misma)
        db2.agregarLibro(new LibroFisico("Cien Años de Soledad", "Gabriel García Márquez", "segunda edicion"));

        System.out.println(db1.getLibros());

        System.out.println("");
        System.out.println("------------PARTE 5 ---------------");
        //Prototype

        // Creamos un préstamo original
        Prestamo prestamo1 = new Prestamo(db1.getLibro(1), "Usuario1", LocalDateTime.now(), LocalDateTime.now().plusDays(7)
        );

        // Clonamos el préstamo 2 veces
        Prestamo prestamo2 = prestamo1.clone();
        Prestamo prestamo3 = prestamo1.clone();


        //Modifico atributos de prestamo 2 y 3
        prestamo2.setUsuario("Usuario2");
        prestamo3.setUsuario("Usuario3");


        // Mostramos ambos préstamos
        System.out.println("Préstamo original:");
        prestamo1.mostrar();

        System.out.println("\nPréstamo clonado:");
        prestamo2.mostrar();

        System.out.println("\nPréstamo clonado:");
        prestamo3.mostrar();

        // Verificamos si son el mismo objeto
        System.out.println("\n¿prestamo1 y prestamo2 son el mismo objeto? " + (prestamo1 == prestamo2));
        System.out.println("\n¿prestamo2 y prestamo3 son el mismo objeto? " + (prestamo2 == prestamo3));

    }

}