package State;

public interface EstadoInscripcion {
    void inscribir(Inscripcion inscripcion);
    void cancelar(Inscripcion inscripcion);
    void enEspera(Inscripcion inscripcion);
}
