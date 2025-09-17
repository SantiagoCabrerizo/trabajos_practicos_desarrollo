package Bridge;

public class Email implements Envio {
    @Override
    public String enviarpor() {
        return "Email";
    }
}
