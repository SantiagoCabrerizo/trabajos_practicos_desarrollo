package observer;

public class Alumno implements Observer {
    private final String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void update(String msg) {
        // Silencioso para no llenar la consola. El Subject (Curso) imprime el resumen agrupado.
        // Si querés ver por-alumno, descomentá la línea de abajo:
        // System.out.println("   · (" + nombre + ") <- " + msg);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
