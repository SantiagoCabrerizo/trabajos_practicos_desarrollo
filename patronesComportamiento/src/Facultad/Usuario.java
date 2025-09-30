package Facultad;
import Mediator.ChatMediator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter




public abstract class Usuario {
    protected int legajo;
    protected String dni;
    protected String nombreApellido;
    protected String mail;
    protected String telefono;


    public Usuario(int legajo, String dni, String nombreApellido, String mail, String telefono) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.mail = mail;
        this.telefono = telefono;
    }

    //Mediator
    protected ChatMediator mediator;
    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void enviar(String mensaje);
    public abstract void recibir(String mensaje);

}
