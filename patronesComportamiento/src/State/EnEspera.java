package State;

public class EnEspera implements EstadoInscripcion{
    public void inscribir(Inscripcion inscripcion){
        System.out.println("Realizando inscripción desde Espera");
        inscripcion.setEstado(new Inscripto());
    }
    public void cancelar(Inscripcion inscripcion){
        System.out.println("Cancelando Inscripción desde Espera");
        inscripcion.setEstado(new Cancelado());
    }
    public void enEspera(Inscripcion inscripcion){
        System.out.println("La inscripción ya está en espera");
    }

}
