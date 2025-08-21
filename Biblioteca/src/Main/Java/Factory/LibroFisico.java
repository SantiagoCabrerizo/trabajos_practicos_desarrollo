package Main.Java.Factory;

public class LibroFisico implements Libro{
    private String titulo;
    private String autor;
    private String edicion;

    public LibroFisico(String titulo, String autor, String edicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
    }
    @Override
    public void MostrarInfo(){

        System.out.println("Libro Físico: "+edicion);
    }

}
