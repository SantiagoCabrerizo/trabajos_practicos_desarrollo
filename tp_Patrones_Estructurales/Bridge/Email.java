package Bridge;

public class Email implements Envio {
    @Override
   //devuelve email
    public String enviarpor() {
        return "Email";
    }
}
