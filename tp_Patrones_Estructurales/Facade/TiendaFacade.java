package Facade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class TiendaFacade {
    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade(Carrito carrito, Pago pago, Envio envio) {
        this.carrito = carrito;
        this.pago = pago;
        this.envio = envio;
    }

    public void comprar(String producto, double monto) {
        carrito.agregarProducto(producto);
        carrito.revisarCarrito();
        pago.procesarPago(monto);
        envio.coordinarEnvio(producto);
        System.out.println("Compra finalizada con éxito.");
    }
}