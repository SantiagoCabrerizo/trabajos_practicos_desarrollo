package Factory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "titulo: " + titulo + "autor: " + autor + "edicion: " + edicion;
    }
}
