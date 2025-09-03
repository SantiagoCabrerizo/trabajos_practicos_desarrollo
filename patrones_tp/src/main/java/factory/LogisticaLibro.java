package main.java.factory;

public class LogisticaLibro {
    public static Libro crearLibro(String titulo, String autor, String tipo){
        return switch (tipo) {
            case "Físico" -> new LibroFisico(titulo, autor);
            case "Digital" -> new LibroDigital(titulo, autor);
            default -> throw new IllegalArgumentException("Tipo desconocido");
        };
    }
}
