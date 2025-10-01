package ChainOfResponsibility;

public interface Handler {
    void setNext(Handler next);
    void handle(SolicitudCr s);
}
