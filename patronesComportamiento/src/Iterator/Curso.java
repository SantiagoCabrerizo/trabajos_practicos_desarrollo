package Iterator;

import observer.Observer;
import observer.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Curso implements Subject {
    private String nombre;
    private final List<Observer> observers = new ArrayList<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Implementación del patrón Observer
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String msg) {
        System.out.println("   📢 [" + nombre + "] notifica a " + observers.size() + " alumno(s): " + msg);
        for (Observer o : observers) {
            o.update(msg);
        }
    }

    // Métodos específicos para el Observer
    public void cambiarHorario(String nuevoHorario) {
        notifyObservers("Cambio de horario: " + nuevoHorario);
    }

    public void publicarAviso(String aviso) {
        notifyObservers("Aviso: " + aviso);
    }

    public List<String> getNombresInscriptos() {
        return observers.stream()
                .map(o -> {
                    if (o instanceof Facultad.Alumno) {
                        return ((Facultad.Alumno) o).getNombreApellido();
                    }
                    return o.toString();
                })
                .collect(Collectors.toList());
    }

    public boolean removeObserverByName(String nombre) {
        return observers.removeIf(o -> {
            if (o instanceof Facultad.Alumno) {
                return ((Facultad.Alumno) o).getNombreApellido().equals(nombre);
            }
            return o.toString().equals(nombre);
        });
    }
}
