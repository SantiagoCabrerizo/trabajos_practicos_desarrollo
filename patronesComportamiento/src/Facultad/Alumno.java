package Facultad;

import Memento.Memento;
import Strategy.CalculoNota;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
@Setter

public class Alumno extends Usuario{
  private List<Integer> notas;
  private CalculoNota estrategia;

    public Alumno(int legajo, String dni, String nombreApellido, String mail, String telefono) {
        super(legajo, dni, nombreApellido, mail, telefono);
    }
    //Strategy


    public Alumno(int legajo, String dni, String nombreApellido, String mail, String telefono, CalculoNota estrategia) {
        super(legajo, dni, nombreApellido, mail, telefono);
        this.estrategia= estrategia;
        this.notas=new ArrayList<>();

    }



    public void cargarNotas(Integer... nuevasNotas){
        notas.addAll(Arrays.asList(nuevasNotas));
    }

    public void setEstrategia(CalculoNota estrategia) {
        this.estrategia = estrategia;
    }
    public  double calcularNotaFinal(){
        return estrategia.CalcularPromedio(notas);
    }




    //.......





    //Mediator
    public void enviar(String mensaje) {
        System.out.println("\n" +nombreApellido + " (Estudiante) envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
    public void recibir(String mensaje) {
        System.out.println(nombreApellido + " (Estudiante) recibe: " + mensaje);
    }


    //Memento
    private java.util.Stack<Memento> historial = new java.util.Stack<>();

    public void responder(Examen examen,String respuesta) {
        System.out.println(nombreApellido + " realiza " + respuesta + " del Examen Nº" + examen.getNumeroExamen());
        examen.responder(respuesta);
    }

    public void guardarProgreso(Examen examen) {
        historial.push(examen.save());
    }

    public void restaurarProgreso(Examen examen) {
        if (!historial.isEmpty()) {
            examen.restore(historial.pop());
        }
    }
}
