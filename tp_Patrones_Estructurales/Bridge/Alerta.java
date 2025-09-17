package Bridge;

public class Alerta extends Tipo {
    public Alerta(Envio envio) {
        super(envio);
    }

    @Override
    void enviar() {
        System.out.println("Enviando una Alerta en forma:"+this.envio.enviarpor() );

    }
}