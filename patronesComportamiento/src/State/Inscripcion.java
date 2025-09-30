package State;

public class Inscripcion {
    //Mantiene el estado actual
    private EstadoInscripcion estado;

    public Inscripcion() {
       estado= new EnEspera();
    }
    public void setEstado(EstadoInscripcion estado){
        this.estado=estado;
    }
    public void inscribir(){ estado.inscribir(this);}
    public void cancelar(){estado.cancelar(this);}
    public void enEspera(){estado.enEspera(this);}

}
