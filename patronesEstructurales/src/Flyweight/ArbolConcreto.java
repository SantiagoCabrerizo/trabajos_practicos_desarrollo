package Flyweight;

public class ArbolConcreto implements Arbol {
    private final String tipo;
    private final String textura;
    private final String color;

    public ArbolConcreto(String textura, String tipo, String color) {
        this.textura = textura;
        this.tipo = tipo;
        this.color = color;
        System.out.println("Creando objeto para el abrol tipo "+tipo+ ", de textura "+textura+" y color "+color+"." );
    }
    @Override
    public  void dibujar(int x, int y){
        System.out.println("Dibujando el árbol "+tipo+" en la posición: ("+x+ ","+y+").");
    }
}
