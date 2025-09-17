package Bridge;

import lombok.Getter;
import lombok.Setter;


    @Getter
    @Setter

    public abstract class Tipo {

        protected Envio envio;

        public Tipo (Envio envio){this.envio=envio;}
        abstract void enviar();
    }
