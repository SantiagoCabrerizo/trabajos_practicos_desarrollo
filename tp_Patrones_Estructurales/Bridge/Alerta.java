package Bridge;
//clase que nos representa una alerta
public class Alerta extends Tipo {

    public Alerta(Envio envio) {
        super(envio);
    }

    @Override

    void enviar() {
    //Muestra el mensaje indicando la alerta y el tipo de envio
        System.out.println("Enviando una Alerta en forma:"+this.envio.enviarpor() );

    }
}
