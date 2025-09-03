package Singleton;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import Factory.Libro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
    public class Database {
        private static volatile Database instance;
        private List<Libro> libros = new ArrayList<>();

        private Database() {
            System.out.println("Accediendo a la base de datos...");
        }

        public static Database getInstance() {
            if (instance == null) { //Primera verificacion (sin lock)
                synchronized (Database.class) {
                    if (instance == null) {
                        instance = new Database();
                        System.out.println("conexion establecida...");

                    }
                }
            } return instance;
        }



        public void agregarLibro(Libro libro) {

            libros.add(libro);
            System.out.println("libro añadido");
        }


        public List<Libro> getLibros() {
            System.out.println("lista de libros a continuacion...");
            return libros;
        }
    }
