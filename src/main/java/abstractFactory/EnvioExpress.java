package main.java.abstractFactory;

public class EnvioExpress implements MetodoEnvio{
    @Override
    public void enviar(String paquete) {
        System.out.println("Envío express de: " + paquete);
    }
}
