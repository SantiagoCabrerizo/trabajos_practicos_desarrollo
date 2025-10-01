package Strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota{


    @Override
    public double CalcularPromedio(List<Integer> notas) {
      int suma=0;
      for(int n:notas){
          suma+=n;
      }


        return (double) suma/notas.size();
    }
}
