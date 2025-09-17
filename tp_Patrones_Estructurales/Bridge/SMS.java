package Bridge;

public class SMS implements Envio {

    @Override
   //Devuelve SMS
    public String enviarpor() {
        return "SMS";
    }
}
