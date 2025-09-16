package Flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyweightDemo {
    public static void main(String[] args){

        FabricaDeArboles fabrica =new FabricaDeArboles();

        String [] tipos= {"Cerezo","Roble"};
        String [] texturas= {"Sueve","Rugosa"};
        String [] colores= {"Rosado","verde"};

        final int Total = 20;
        Random rand = new Random(42);

        List<Arbol> arbolFlylist = new ArrayList<>(Total);
        List<int[]> posiciones = new ArrayList<>(Total);

        for (int i=0; i<Total; i++){
            int idx = rand.nextInt(tipos.length);
            String tipo = tipos[idx];
            String textura = texturas[idx];
            String color = colores[idx];
            int x = rand.nextInt(10_000);
            int y = rand.nextInt(10_000);

            Arbol arbolFly = fabrica.obtenerArbol(tipo, color, textura);

            arbolFlylist.add(arbolFly);
            posiciones.add(new int[]{x,y});
        }
        for (int i=0; i<arbolFlylist.size();i++){
            Arbol a= arbolFlylist.get(i);
            int[] pos= posiciones.get(i);
            a.dibujar(pos[0],pos[1]);
        }

    }
}

