package Main.Java.Prototype;

public class Prestamo implements Cloneable {
    private String socio;
    private int cantDias;


    public Prestamo(String socio, int cantDias){
        this.socio=socio;
        this.cantDias=cantDias;
    }
     
    @Override

    public Prestamo clone(){
        try{
            return (Prestamo) super.clone();
        }
    catch (CloneNotSupportedException e){
        throw new RuntimeException(e);
    }
}
       public void mostrar(){
        System.out.println("El socio: "+ socio + " pidio prestado un libro durante "+ cantDias +" Dias");
       }
}

