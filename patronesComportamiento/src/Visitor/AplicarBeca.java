package Visitor;
public class AplicarBeca implements Visitor {
    @Override
    public void visitar(AlumnoRegular a) {
        System.out.println("Alumno Regular: " + a.getNombre() +
                " - Cuota final: $" + a.getCuota());
    }

    @Override
    public void visitar(AlumnoBecado a) {
        double cuotaFinal = a.getCuota() * (1 - a.getPorcentajeBeca());
        System.out.println("Alumno Becado: " + a.getNombre() +
                " - Beca del " + (a.getPorcentajeBeca() * 100) + "%" +
                " - Cuota final: $" + cuotaFinal);
    }
}
