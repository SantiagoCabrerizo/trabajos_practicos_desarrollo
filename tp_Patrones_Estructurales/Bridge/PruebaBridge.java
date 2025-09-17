package Bridge;

public class PruebaBridge {
    public static void main(String[] args) {
        Envio email = new Email();
        Envio sms = new SMS();
        Tipo alerta=new Alerta(email);
        Tipo promo= new Promocion(sms);
        Tipo recordatorio = new Recordatorio(email);

        alerta.enviar();
        promo.enviar();
        recordatorio.enviar();

    }
}