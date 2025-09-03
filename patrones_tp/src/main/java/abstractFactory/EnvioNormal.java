package main.java.abstractFactory;

public class EnvioNormal implements MetodoEnvio{
    @Override
    public void enviar(String paquete){
        System.out.println("Envío normal de: " + paquete);
    }
}
