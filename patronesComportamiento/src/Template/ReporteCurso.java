package Template;

public class ReporteCurso extends ReporteAcademico{

    protected void publicarNotas() {
        System.out.println("publicando notas del curso");
    }

    protected void calcularPromedio() {
        System.out.println("Calcular promedio del curso");
    }
}
