package Mediator;
import Facultad.*;


public interface ChatMediator {
    void enviarMensaje(String msj, Usuario usuario);
    void agregarUsuario(Usuario usuario);
}
