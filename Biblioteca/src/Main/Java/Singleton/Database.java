package Main.Java.Singleton;

import java.util.ArrayList;
import java.util.List;

import Main.Java.Factory.Libro;

    public class Database {
        private static Database instance;
        private List<Libro> libros;

        private Database() {
            libros = new ArrayList<>();
        }

        public static synchronized Database getInstance() {
            if (instance == null) {
                instance = new Database();
            }
            return instance;
        }

        public void agregarLibro(Libro libro) {
            libros.add(libro);
        }

        public List<Libro> getLibros() {
            return libros;
        }
    }
