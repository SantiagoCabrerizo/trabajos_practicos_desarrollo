package main.java.builder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
}
