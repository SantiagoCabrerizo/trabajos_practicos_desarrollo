package State;

public class Cancelado implements EstadoInscripcion{
    public void inscribir(Inscripcion inscripcion){
        System.out.println("No se puede realizar la inscripción porque está cancelada");
    }
    public void cancelar(Inscripcion inscripcion){
        System.out.println("La Inscripción ya está cancelada");
    }
    public void enEspera(Inscripcion inscripcion) {
        System.out.println("No se puede poner en espera porque ya esta cancelada");
    }
}
