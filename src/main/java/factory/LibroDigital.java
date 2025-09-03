package main.java.factory;

import lombok.*;

@Data
@AllArgsConstructor
public class LibroDigital implements Libro {
    private String titulo;
    private String autor;

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public String toString(){
        return "Libro Digital: " + titulo + ", " + autor;
    }

}