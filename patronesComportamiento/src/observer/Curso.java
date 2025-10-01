package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Curso implements Subject {
    private final String nombre;
    private final List<Observer> observers = new ArrayList<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /** Baja por nombre (si el Observer es Alumno) */
    public boolean removeObserverByName(String nombreAlumno) {
        for (int i = 0; i < observers.size(); i++) {
            Observer o = observers.get(i);
            if (o instanceof Alumno a && a.getNombre().equalsIgnoreCase(nombreAlumno)) {
                observers.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void notifyObservers(String msg) {
        // Antes de notificar, armamos el resumen (quiénes recibirán)
        List<String> destinatarios = observers.stream()
            .map(o -> (o instanceof Alumno a) ? a.getNombre() : o.toString())
            .collect(Collectors.toList());

        if (destinatarios.isEmpty()) {
            System.out.println("   (Sin inscriptos en " + nombre + ")");
        } else {
            System.out.println("   → Reciben (" + nombre + "): " + String.join(", ", destinatarios));
        }

        // Disparo real a los observers (silencioso en Alumno para no spamear)
        for (Observer o : observers) {
            o.update("[" + nombre + "] " + msg);
        }
    }

    public List<String> getNombresInscriptos() {
        return observers.stream()
                .map(o -> (o instanceof Alumno a) ? a.getNombre() : o.toString())
                .collect(Collectors.toList());
    }

    // Acciones de dominio
    public void cambiarHorario(String nuevoHorario) {
        System.out.println(" • Nuevo horario: " + nuevoHorario);
        notifyObservers("Nuevo horario: " + nuevoHorario);
    }

    public void publicarAviso(String aviso) {
        System.out.println(" • Aviso: " + aviso);
        notifyObservers("Aviso: " + aviso);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
