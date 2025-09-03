package main.java.factory;

import lombok.*;

@Data
@AllArgsConstructor
public class LibroFisico implements Libro{
    private String  titulo;
    private String autor;

    @Override
    public String getTipo(){
        return "Físico";
    }

    @Override
    public String toString(){
        return "Libro Físico: " + titulo + ", " + autor;}
}