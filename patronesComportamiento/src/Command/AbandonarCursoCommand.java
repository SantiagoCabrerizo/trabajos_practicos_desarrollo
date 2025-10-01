package Command;

import Facultad.Alumno;
import Facultad.Usuario;

public class AbandonarCursoCommand implements Command {
    private Usuario alumno;
    private String curso;

    public AbandonarCursoCommand(Usuario alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    public void execute() {
        alumno.abandonar(curso);
    }
}
