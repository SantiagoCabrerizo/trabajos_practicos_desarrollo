package Template;

abstract class ReporteAcademico {

    public final void generarReporte(){
        publicarNotas();
        actualizarEstadoAcademico();
        calcularPromedio();
    }
    protected abstract void publicarNotas();
    protected void actualizarEstadoAcademico(){
        System.out.println("Actualizando Estado Academico");
    }
    protected abstract void calcularPromedio();





}
