package Template;

import Facultad.Alumno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReporteCurso extends ReporteAcademico{
     private String nombreCurso;
     private List<Alumno> alumnos;


    @Override
    protected void generarContenido() {
        System.out.println("Curso: "+ nombreCurso);
        System.out.println("Cantidad de alumnos: "+alumnos.size());


        double sumaNotas=0;
        for (Alumno alumno: alumnos){
            double notaFinal=alumno.calcularNotaFinal();

            sumaNotas+=notaFinal;
        }
        double promedioCurso= alumnos.isEmpty()? 0 : sumaNotas/alumnos.size();
        System.out.println("Promedio del curso: " + promedioCurso);
    }
}
