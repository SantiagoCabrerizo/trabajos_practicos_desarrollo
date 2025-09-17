package Bridge;

public class Recordatorio extends Tipo {

    public Recordatorio(Envio envio) {
        super(envio);
    }

    @Override
    void enviar() {
        System.out.println("Enviando un recordatorio en forma:"+this.envio.enviarpor() );

    }
}
