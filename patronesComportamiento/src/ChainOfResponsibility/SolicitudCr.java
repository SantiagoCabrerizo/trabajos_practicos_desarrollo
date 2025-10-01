package ChainOfResponsibility;

public class SolicitudCr {
    private String descripcion;
    private int nivel;
    // 1: simple (asistente), 2: media (profesor), 3: compleja (coordinador)

    public SolicitudCr(String descripcion, int nivel) {
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public String getDescripcion() { return descripcion; }
    public int getNivel() { return nivel; }
}
