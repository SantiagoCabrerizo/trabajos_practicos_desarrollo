package Bridge;

public class Promocion extends Tipo {





    public Promocion(Envio envio) {
        super(envio);
    }

    @Override
    void enviar() {
        System.out.println("Enviando una Promocion en forma:"+this.envio.enviarpor() );

    }
}
