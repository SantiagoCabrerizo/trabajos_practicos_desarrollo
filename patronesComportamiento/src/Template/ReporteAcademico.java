package Template;

public abstract class ReporteAcademico {

    public final void generarReporte(){
       generarEncabezado();
       generarContenido();
       generarPie();
    }

    private void generarEncabezado(){
        System.out.println("Reporte Academico");



    }
    protected abstract void generarContenido();

    private void  generarPie(){
        System.out.println("Fin del Reporte Academico");
    }



}
