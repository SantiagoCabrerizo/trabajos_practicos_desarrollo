package proxy;

public class ArchivoProxy implements Archivo {

    private String nombre;
    private ArchivoReal archivoReal;
    private Usuario usuario;

    public ArchivoProxy(String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    @Override
    public void abrirArchivo() {
        if(usuario.permiso()){
            if(archivoReal == null){
                archivoReal = new ArchivoReal(nombre);
            }
            System.out.println("Acceso permitido a: " + usuario.getNombre());
            archivoReal.abrirArchivo();
        } else {
            System.out.println("El usuario no tiene permisos para el archivo " + nombre);
        }
    }
}
