package Bridge;
public class BridgeMain {
    public static void main(String[] args) {
       //Creamos los distintos medios de envio

        Envio email = new Email();
        Envio sms = new SMS();
        //Creamos los distintos tipos de mensajes
        Tipo alerta=new Alerta(email);
        Tipo promo= new Promocion(sms);
        Tipo recordatorio = new Recordatorio(email);
//Ejecutamos el metodo enviar
        alerta.enviar();
        promo.enviar();
        recordatorio.enviar();

    }
}