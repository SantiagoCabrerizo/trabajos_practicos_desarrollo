package Singleton;

import java.util.ArrayList;
import java.util.List;

    public class Database {
        private static Database instance;
        private List<Main.Java.Factory.Libro> libros;

        private Database() {
            libros = new ArrayList<>();
        }

        public static synchronized Database getInstance() {
            if (instance == null) {
                instance = new Database();
            }
            return instance;
        }

        public void agregarLibro(Main.Java.Factory.Libro libro) {
            libros.add(libro);
        }

        public List<Main.Java.Factory.Libro> getLibros() {
            return libros;
        }
    }
