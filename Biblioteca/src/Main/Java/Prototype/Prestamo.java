package Prototype;

import java.time.LocalDateTime;

public class Prestamo implements Cloneable {
    private String libro;
    private String usuario;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;



    public Prestamo(String libro, String usuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.libro = libro;
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
     System.out.println("el libro: "+ libro+ "sera prestado al Usuario: "+usuario+ "hasta: "+ fechaHoraFin);
 }
}
