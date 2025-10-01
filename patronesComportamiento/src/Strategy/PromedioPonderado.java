package Strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota {




    private List<Integer> pesos;   // guarda los "pesos" de cada nota

    // Constructor: recibe la lista de pesos
    public PromedioPonderado(List<Integer> pesos) {
        this.pesos = pesos;
    }

    @Override
    public double CalcularPromedio(List<Integer> notas) {
        int suma = 0;
        int sumaPesos = 0;

        // Recorre todas las notas y multiplica cada nota por su peso
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i) * pesos.get(i);  // acumulamos la nota ponderada
            sumaPesos += pesos.get(i);            // sumamos el total de pesos
        }

        // El promedio ponderado es: suma ponderada / suma de los pesos
        return (double) suma / sumaPesos;
    }
}