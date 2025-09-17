package Facade;

public class Carrito {
    public void agregarProducto(String producto) {
        System.out.println("Producto agregado al carrito: " + producto);
    }
    public void revisarCarrito() {
        System.out.println("Carrito revisado. Todo listo para la compra.");
    }
}