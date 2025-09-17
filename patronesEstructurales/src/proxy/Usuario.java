package proxy;

public class Usuario {
    private String nombre;
    private Boolean permiso;

    public  Usuario(String nombre, Boolean permiso) {
        this.nombre = nombre;
        this.permiso = permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean permiso() {
        return permiso;
    }
}
