package ChainOfResponsibility;

public class CoordinadorCr implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) { this.next = next; }

    @Override
    public void handle(SolicitudCr s) {
        if (s.getNivel() == 3) {
            System.out.println("Coordinador maneja la solicitud: " + s.getDescripcion());
        } else {
            System.out.println("Solicitud no puede ser atendida.");
        }
    }
}
