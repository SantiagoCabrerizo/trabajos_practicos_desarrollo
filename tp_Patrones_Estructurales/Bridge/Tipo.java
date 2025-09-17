package Bridge;


    public abstract class Tipo {


        protected Envio envio;

        public Tipo (Envio envio){this.envio=envio;}
        abstract void enviar();
    }
