import Facultad.*;
import Mediator.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Patrones de Comportamientos");
        //Creamos Alumnos
        Usuario a1 = new Alumno(1, "12345678", "Ana Rodriguez", "anaR@mail.com", "111-111");
        Usuario a2 = new Alumno(2, "23456789", "Marta Suarez", "martaSuarez@mail.com", "222-222");
        Usuario a3 = new Alumno(3, "34567890", "Juan Gallardo", "juangallardo@mail.com", "333-333");
        Usuario a4 = new Alumno(4, "45678901", "Lucía Lencina", "lucialencina@mail.com", "444-444");

        //Creamos Profesores
        Usuario p1 = new Profesor(100, "87654321", "Luis Perez", "luisperez@mail.com", "555-555");
        Usuario p2 = new Profesor(101, "98765432", "Paola Avellaneda", "paolaAv@mail.com", "666-666");


        System.out.println("\n4) Mediator-----------------------------");
        //Crreamos la sala y agregamos a los usuarios asignandoles la sala
        ChatMediator sala1 = new ChatRoom();
        ChatMediator sala2 = new ChatRoom();
        sala1.agregarUsuario(a1);
        sala2.agregarUsuario(a2);
        sala1.agregarUsuario(a3);
        sala2.agregarUsuario(a4);
        sala1.agregarUsuario(p1);
        sala2.agregarUsuario(p2);

        // Mensajes
        a1.enviar("Hola a todos!");
        p1.enviar("Bienvenidos!!");
        a3.enviar("Gracias profe!");
        a2.enviar("¿Alguien tiene apuntes de la última clase?");
        a4.enviar("Sí, ahora los mando.");



        System.out.println("\n5) Memento-----------------------------");
        Examen examen = new Examen(1);

        //Conservamos el polimorfismo (Usuario para todos), pero en un caso particular usamos los métodos de Alumno
        // por eso casteamos y esto le indica al compilador que ese Usuario en realidad es un Alumno.
        ((Alumno) a1).responder(examen, "Respuesta 1");
        ((Alumno) a1).responder(examen, "Respuesta 2");
        examen.mostrar();
        ((Alumno) a1).guardarProgreso(examen);

        ((Alumno) a1).responder(examen, "Respuesta 3");
        examen.mostrar();

        System.out.println("\nRestauramos el progreso antes de hacer la respuesta 3:");
        ((Alumno) a1).restaurarProgreso(examen);
        examen.mostrar();

    }
}