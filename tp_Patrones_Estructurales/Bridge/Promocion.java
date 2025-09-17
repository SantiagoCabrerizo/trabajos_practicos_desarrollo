package Bridge;

public class Promocion extends Tipo {
    //constructor
    public Promocion(Envio envio) {
        super(envio);
    }


    @Override
  //implementa el metodo
    void enviar() {
        System.out.println("Enviando una Promocion en forma:"+this.envio.enviarpor() );

    }
}
