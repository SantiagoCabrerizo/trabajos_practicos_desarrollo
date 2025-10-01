package Facultad;

import Memento.Memento;

public class Examen {
    private int numeroExamen;
    private java.util.List<String> respuestas = new java.util.ArrayList<>();

    public Examen(int nro) {
        numeroExamen = nro;
    }

    public int getNumeroExamen() {
        return numeroExamen;
    }

    public void responder(String respuesta) {
        respuestas.add(respuesta);
    }

    public void mostrar() {
        System.out.println("Respuestas actuales: " + respuestas);
    }

    public Memento save() {
        System.out.println("El progreso hasta ahora se guardó exitosamente.\n");
        return new Memento(respuestas);
    }

    public void restore(Memento m) {
        System.out.println("El último progreso guardado se restauró correctamente.");
        respuestas = new java.util.ArrayList<>(m.getRespuestas());
    }
}

