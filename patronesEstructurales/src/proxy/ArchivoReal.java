package proxy;

public class ArchivoReal implements Archivo {
    private String nombre;

    public ArchivoReal(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void abrirArchivo() {
        System.out.println("Abriendo el archivo " + nombre);
    }
}
