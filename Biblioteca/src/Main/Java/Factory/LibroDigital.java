package Factory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LibroDigital implements Libro{
  private String titulo;
  private String autor;
  private String formato;

    public LibroDigital(String titulo, String autor, String formato) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
    }



    @Override
    public void MostrarInfo(){
            System.out.println(" Libro Digital: "+ titulo +" Formato: "+formato+" Autor: "+autor);
    }
}
