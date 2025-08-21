package Main.Java.Factory;

 abstract class LogisticaLibro {

     public abstract Libro crearLibro();
     public void FormatoLibro(){
         Libro libro=crearLibro();
         libro.MostrarInfo();
     }

}
