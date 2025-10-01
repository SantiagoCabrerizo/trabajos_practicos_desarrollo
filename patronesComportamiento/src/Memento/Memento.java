package Memento;

// Memento guarda el estado de las respuestas
public class Memento {
    private final java.util.List<String> respuestas;

    public Memento(java.util.List<String> respuestas) {
        this.respuestas = new java.util.ArrayList<>(respuestas);
    }

    public java.util.List<String> getRespuestas() {
        return respuestas;
    }
}

