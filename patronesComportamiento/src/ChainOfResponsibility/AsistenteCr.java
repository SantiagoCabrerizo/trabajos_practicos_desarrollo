package ChainOfResponsibility;

public class AsistenteCr implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) { this.next = next; }

    @Override
    public void handle(SolicitudCr s) {
        if (s.getNivel() == 1) {
            System.out.println("Asistente maneja la solicitud: " + s.getDescripcion());
        } else if (next != null) {
            next.handle(s);
        }
    }
}
