package Prototype;

import Factory.Libro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Factory.Libro;

public class Prestamo implements Cloneable {
    private Libro Libro;
    private String usuario;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    public Prestamo(Factory.Libro libro, String usuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Libro = libro;
        this.usuario = usuario;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    @Override
    public Prestamo clone(){
        try{
            return (Prestamo) super.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }
 public void mostrar(){
     System.out.println("el libro: "+ Libro + "sera prestado al Usuario: "+usuario+ "hasta: "+ fechaHoraFin);
 }
}
