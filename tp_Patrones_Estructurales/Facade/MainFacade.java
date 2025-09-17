package Facade;
public class MainFacade {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        Pago pago = new Pago();
        Envio envio = new Envio();

        TiendaFacade tienda = new TiendaFacade(carrito, pago, envio);

        tienda.comprar("Laptop", 1500.00);
    }
}