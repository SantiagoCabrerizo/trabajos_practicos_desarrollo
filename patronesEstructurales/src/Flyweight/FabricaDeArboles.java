package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeArboles {
    private Map<String, Arbol> arboles= new HashMap<>();

    public Arbol obtenerArbol(String tipo,String color, String textura){
        Arbol arbol = arboles.get(tipo);
        if (arbol == null){
            arbol = new ArbolConcreto(textura,tipo,color);
            arboles.put(tipo,arbol);
        }
        return arbol;
    }
}
