package Command;

import Facultad.Alumno;
import Facultad.Usuario;

public class SolicitarCertificadoCommand implements Command {
    private Usuario alumno;
    private String curso;

    public SolicitarCertificadoCommand(Usuario alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    public void execute() {
        alumno.solicitarCertificado(curso);
    }
}
