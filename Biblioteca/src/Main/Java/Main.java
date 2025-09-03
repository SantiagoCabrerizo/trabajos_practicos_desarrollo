import Factory.Libro;
import Factory.LibroFisico;
import Singleton.Database;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Singleton
        Database db1 = Database.getInstance(); // Obtener instancia de la base de datos
        db1.agregarLibro(new LibroFisico("El Quijote", "Miguel de Cervantes", "tercera edicion"));

        Database db2 = Database.getInstance();          // Obtener otra "instancia" (en realidad es la misma)
        db2.agregarLibro(new LibroFisico("Cien Años de Soledad", "Gabriel García Márquez", "segunda edicion"));

        System.out.println(db1.getLibros());


    }

}