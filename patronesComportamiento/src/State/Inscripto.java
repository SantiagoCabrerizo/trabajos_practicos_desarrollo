package State;

public class Inscripto implements EstadoInscripcion{
    public void inscribir(Inscripcion inscripcion){
        System.out.println("La inscripción ya está realizada");
        inscripcion.setEstado(new Inscripto());
    }
    public void cancelar(Inscripcion inscripcion){
        System.out.println("Cancelando Inscripción");
        inscripcion.setEstado(new Cancelado());
    }
    public void enEspera(Inscripcion inscripcion){
        System.out.println("Poniendo en Espera la inscripción");
        inscripcion.setEstado(new EnEspera());
    }
}
