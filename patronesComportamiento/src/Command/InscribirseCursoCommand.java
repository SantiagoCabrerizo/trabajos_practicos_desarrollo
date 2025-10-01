package Command;

import Facultad.Alumno;
import Facultad.Usuario;

public class InscribirseCursoCommand implements Command {
    private Usuario alumno;
    private String curso;

    public InscribirseCursoCommand(Usuario alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    public void execute() {
        alumno.inscribirse(curso);
    }
}
