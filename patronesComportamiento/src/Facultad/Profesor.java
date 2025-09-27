package Facultad;

public class Profesor extends Usuario{

    public Profesor(int legajo, String dni, String nombreApellido, String mail, String telefono) {
        super(legajo, dni, nombreApellido, mail, telefono);
    }


    //Mediator
    public void enviar(String mensaje) {
        System.out.println("\n" + nombreApellido + " (Docente) envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
    public void recibir(String mensaje) {
        System.out.println(nombreApellido + " (Docente) recibe: " + mensaje);
    }
}
