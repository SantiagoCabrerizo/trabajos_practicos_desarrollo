package Singleton;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

    public class Database {
        private static volatile Database instance;
        private List<Factory.Libro> libros = new ArrayList<>();

        private Database() {
            System.out.println("Accediendo a la base de datos...");
        }

        public static Database getInstance() {
            if (instance == null) { //Primera verificacion (sin lock)
                synchronized (Database.class) {
                    if (instance == null) {
                        instance = new Database();
                    }
                }
            } return instance;
        }

        public void agregarLibro(Factory.Libro libro) {
            libros.add(libro);
        }

        public List<Factory.Libro> getLibros() {
            return libros;
        }
    }
