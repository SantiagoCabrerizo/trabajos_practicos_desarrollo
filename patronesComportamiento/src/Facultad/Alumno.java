package Facultad;

import Iterator.Curso;
import Iterator.CursoIterator;
import Iterator.ListaCursosIterator;
import Memento.Memento;
import Strategy.CalculoNota;
import observer.Observer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
@Setter


public class Alumno extends Usuario implements Observer{
  private List<Integer> notas;
  private CalculoNota estrategia;
  //Atributos para implementar iterator
  private java.util.List<Curso> cursos = new java.util.ArrayList<>();

    public Alumno(int legajo, String dni, String nombreApellido, String mail, String telefono) {
        super(legajo, dni, nombreApellido, mail, telefono);
    }
    //Strategy


    public Alumno(int legajo, String dni, String nombreApellido, String mail, String telefono, CalculoNota estrategia) {
        super(legajo, dni, nombreApellido, mail, telefono);
        this.estrategia= estrategia;
        this.notas=new ArrayList<>();

    }



    public void cargarNotas(Integer... nuevasNotas){
        notas.addAll(Arrays.asList(nuevasNotas));
    }

    public void setEstrategia(CalculoNota estrategia) {
        this.estrategia = estrategia;
    }
    public  double calcularNotaFinal(){
        return estrategia.CalcularPromedio(notas);
    }




    //Mediator
    public void enviar(String mensaje) {
        System.out.println("\n" +nombreApellido + " (Estudiante) envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
    public void recibir(String mensaje) {
        System.out.println(nombreApellido + " (Estudiante) recibe: " + mensaje);
    }


    //Memento
    private java.util.Stack<Memento> historial = new java.util.Stack<>();

    public void responder(Examen examen,String respuesta) {
        System.out.println(nombreApellido + " realiza " + respuesta + " del Examen Nº" + examen.getNumeroExamen());
        examen.responder(respuesta);
    }

    public void guardarProgreso(Examen examen) {
        historial.push(examen.save());
    }

    public void restaurarProgreso(Examen examen) {
        if (!historial.isEmpty()) {
            examen.restore(historial.pop());
        }
    }

    //Atributos para implementar iterator
    public void inscribirCurso(Curso curso) {
        cursos.add(curso);
    }

    // Devuelve un iterador para recorrer los cursos
    public CursoIterator iterator() {
        return new ListaCursosIterator(cursos);
    }

    // Observer - implementación del método update
    @Override
    public void update(String msg) {
        // Silencioso para no llenar la consola. El Subject (Curso) imprime el resumen agrupado.
        // Si querés ver por-alumno, descomentá la línea de abajo:
        // System.out.println("   · (" + nombreApellido + ") <- " + msg);
    }

}
