package Facultad;

import Memento.Memento;

public class Alumno extends Usuario{

    public Alumno(int legajo, String dni, String nombreApellido, String mail, String telefono) {
        super(legajo, dni, nombreApellido, mail, telefono);
    }


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
