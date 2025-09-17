package Bridge;

public class SMS implements Envio {

    @Override
    public String enviarpor() {
        return "SMS";
    }
}
