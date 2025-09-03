package Factory;

 public abstract class LogisticaLibro {

     public abstract Libro crearLibro();
     public void FormatoLibro(){
         Libro libro=crearLibro();
         libro.MostrarInfo();
     }

     public static Libro crearLibro(String tipo, String titulo, String autor, String edicion, String formato) {
         switch (tipo) {
                 case "LibroFisico": return new LibroFisico(titulo, autor, edicion);
                 case "LibroDigital": return new LibroDigital(titulo, autor, formato);
                 default: throw new IllegalArgumentException("Tipo desconocido");
         }
     }

}
