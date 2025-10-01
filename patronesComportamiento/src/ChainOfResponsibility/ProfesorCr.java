package ChainOfResponsibility;

public class ProfesorCr implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) { this.next = next; }

    @Override
    public void handle(SolicitudCr s) {
        if (s.getNivel() == 2) {
            System.out.println("Profesor maneja la solicitud: " + s.getDescripcion());
        } else if (next != null) {
            next.handle(s);
        }
    }
}
