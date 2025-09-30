package Strategy;

import java.util.List;

public class ExamenExtra implements CalculoNota{
  private int notaExamen;


    @Override
    public double CalcularPromedio(List<Integer> notas) {
        int suma=0;
        for (int n: notas){
            suma += n;

        }
        double promedio =(double) suma/notas.size();
        return ((promedio)+ (notaExamen))/2;
    }
}
