package main.java.prototype;


import lombok.*;
import main.java.builder.Usuario;
import main.java.factory.Libro;

@Data
@AllArgsConstructor
@Builder
@ToString
public class Prestamo implements Cloneable{
    private Libro libro;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;

    @Override
    public Prestamo clone(){
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
