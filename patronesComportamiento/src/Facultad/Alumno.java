package Facultad;

public class Alumno extends Usuario{

    public Alumno(int legajo, String dni, String nombreApellido, String mail, String telefono) {
        super(legajo, dni, nombreApellido, mail, telefono);
    }

    public void enviar(String mensaje) {
        System.out.println("\n" +nombreApellido + " (Estudiante) envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
    public void recibir(String mensaje) {
        System.out.println(nombreApellido + " (Estudiante) recibe: " + mensaje);
    }

}
