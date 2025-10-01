package Template;

import Facultad.Alumno;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

public class ReporteAlumno extends ReporteAcademico {
     private Alumno alumno;


    @Override
    protected void generarContenido() {
        System.out.println("Alumno: "+ alumno.getNombreApellido());
        System.out.println("Notas: "+ alumno.getNotas());
        System.out.println("Promedio: "+ alumno.calcularNotaFinal());
        System.out.println("Estado: "+ (alumno.calcularNotaFinal()>=6? "Aprobado":"Desaprobado"));


    }
}

