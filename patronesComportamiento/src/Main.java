import ChainOfResponsibility.*;
import Command.*;
import Facultad.*;
import Iterator.Curso;
import Iterator.CursoIterator;
import Mediator.*;
import State.Inscripcion;
import Strategy.*;
import Template.*;
import Visitor.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Patrones de Comportamientos");
        // ====================== Chain of Responsibility
        System.out  .println("---- Chain of Responsibility ----");
        Handler asistente = new AsistenteCr();
        Handler profesor = new ProfesorCr();
        Handler coordinador = new CoordinadorCr();

        asistente.setNext(profesor);
        profesor.setNext(coordinador);

        SolicitudCr s1 = new SolicitudCr("Explicación de ejercicio básico", 1);
        SolicitudCr s2 = new SolicitudCr("Consulta sobre parcial", 2);
        SolicitudCr s3 = new SolicitudCr("Cambio de fecha de examen", 3);

        asistente.handle(s1);
        asistente.handle(s2);
        asistente.handle(s3);

        //Creamos Alumnos
        Usuario a1 = new Alumno(1, "12345678", "Ana Rodriguez", "anaR@mail.com", "111-111");
        Usuario a2 = new Alumno(2, "23456789", "Marta Suarez", "martaSuarez@mail.com", "222-222");
        Usuario a3 = new Alumno(3, "34567890", "Juan Gallardo", "juangallardo@mail.com", "333-333");
        Usuario a4 = new Alumno(4, "45678901", "Lucía Lencina", "lucialencina@mail.com", "444-444");

        //Creamos Profesores
        Usuario p1 = new Profesor(100, "87654321", "Luis Perez", "luisperez@mail.com", "555-555");
        Usuario p2 = new Profesor(101, "98765432", "Paola Avellaneda", "paolaAv@mail.com", "666-666");


        // =================== Command
        System.out.println("---- COMMAND ----");
        Invoker invoker = new Invoker();

        Command inscribirse = new InscribirseCursoCommand(a1, "Programación");
        Command abandonar = new AbandonarCursoCommand(a1, "Matemática");
        Command certificado = new SolicitarCertificadoCommand(a1, "Física");

        invoker.runCommand(inscribirse);
        invoker.runCommand(abandonar);
        invoker.runCommand(certificado);

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

        System.out.println("\n6) Observer-----------------------------");
        // Crear cursos para el patrón Observer (usando las clases existentes)
        Curso cursoDS = new Curso("Desarrollo de Software");
        Curso cursoEDD = new Curso("Estructuras de Datos");
        
        // Crear alumnos para el patrón Observer (usando la clase Alumno existente)
        Alumno alumnoAna = new Alumno(10, "12345678", "Ana Rodriguez", "ana@mail.com", "111-111");
        Alumno alumnoBruno = new Alumno(11, "23456789", "Bruno Gonzalez", "bruno@mail.com", "222-222");
        Alumno alumnoCarla = new Alumno(12, "34567890", "Carla Perez", "carla@mail.com", "333-333");
        Alumno alumnoDiego = new Alumno(13, "45678901", "Diego Martinez", "diego@mail.com", "444-444");
        Alumno alumnoEva = new Alumno(14, "56789012", "Eva Lopez", "eva@mail.com", "555-555");
        
        // Inscripciones
        System.out.println("Inscribiendo alumnos...");
        cursoDS.addObserver(alumnoAna);
        cursoDS.addObserver(alumnoBruno);
        cursoDS.addObserver(alumnoCarla);
        cursoEDD.addObserver(alumnoDiego);
        cursoEDD.addObserver(alumnoEva);
        
        System.out.println("Inscriptos en " + cursoDS.getNombre() + ": " + String.join(", ", cursoDS.getNombresInscriptos()));
        System.out.println("Inscriptos en " + cursoEDD.getNombre() + ": " + String.join(", ", cursoEDD.getNombresInscriptos()));
        
        // Notificaciones
        System.out.println("\nEnviando notificaciones...");
        cursoDS.cambiarHorario("Lunes 18:00-20:00 (Aula 12)");
        cursoDS.publicarAviso("Parcial 1 el 15/10");
        
        cursoEDD.cambiarHorario("Miércoles 10:00-12:00 (Lab B)");
        cursoEDD.publicarAviso("TP#1 publicado en el campus");
        
        // Desinscripciones
        System.out.println("\nProcesando bajas...");
        cursoDS.removeObserverByName("Bruno Gonzalez");
        System.out.println("Inscriptos en " + cursoDS.getNombre() + " después de la baja: " + String.join(", ", cursoDS.getNombresInscriptos()));
        
        // Demostrar que el alumno dado de baja ya no recibe notificaciones
        System.out.println("\nEnviando nueva notificación después de las bajas...");
        cursoDS.publicarAviso("Bruno ya no recibirá esta notificación - Recordatorio: Entrega del TP2 el viernes");

//State
        System.out.println("\n7) State-----------------------------");
        Inscripcion inscripcion1 = new Inscripcion();

        inscripcion1.inscribir();
        inscripcion1.enEspera();
        inscripcion1.cancelar();
        inscripcion1.inscribir();

        Inscripcion inscripcion2 = new Inscripcion();

        inscripcion2.cancelar();
        inscripcion2.enEspera();

//Strategy
        System.out.println("Strategy--------------------------------------------");
        Alumno alumno = new Alumno(1234, "3245", "Juan Pepe", "juanpepe@email.com", "2345674", new PromedioSimple());
        alumno.cargarNotas(7, 8, 9);

        System.out.println(alumno.getNombreApellido() + " Promedio simple:" + alumno.calcularNotaFinal());


        Alumno alumno1 = new Alumno(1234, "3245", "Pepe Juan", "juanpepe@email.com", "2345674", new PromedioPonderado(Arrays.asList(7, 2, 1)));
        alumno1.cargarNotas(5, 3, 10);

        System.out.println(alumno1.getNombreApellido() + " Promedio ponderado: " + alumno1.calcularNotaFinal());


//Template
        System.out.println("Template-----------------------------------------------------------------------------------");
        ReporteAcademico reporte1 = new ReporteAlumno(alumno);
        ReporteCurso reporteCurso1 = new ReporteCurso();


        System.out.println("Reporte Alumno");
        reporte1.generarReporte();


        List<Alumno> alumnosCurso = Arrays.asList(alumno, alumno1);
        ReporteAcademico reporteCurso = new ReporteCurso("Desarrollo de Software", alumnosCurso);
        System.out.println("Reporte Curso");
        reporteCurso.generarReporte();

//-------------------------------------------------------------------------------------

//Visitor
        System.out.println(" =====Visitor=====");
        //Creamos alumnos becados y regulares
        AlumnoRegular alumnoRegular1 = new AlumnoRegular("Ana Rodriguez", 50000.0);
        AlumnoRegular alumnoRegular2 = new AlumnoRegular("Marta Suarez", 50000.0);

        AlumnoBecado alumnoBecado1 = new AlumnoBecado("Juan Gallardo", 50000.0, 0.3); // 30% de beca
        AlumnoBecado alumnoBecado2 = new AlumnoBecado("Lucía Lencina", 50000.0, 0.5); // 50% de beca

        //Creación de visitor
        Visitor aplicarBeca = new AplicarBeca();

        alumnoRegular1.aceptar(aplicarBeca);
        alumnoRegular2.aceptar(aplicarBeca);
        alumnoBecado1.aceptar(aplicarBeca);
        alumnoBecado2.aceptar(aplicarBeca);

        System.out.println("");
        System.out.println("-------------------------Prueba Iterator-------------------------");


        Usuario a5 = new Alumno(5, "45678944", "Camila perez", "camiperez@mail.com", "444-466");

        alumno.inscribirCurso(new Curso("Analisis Numerico"));
        alumno.inscribirCurso(new Curso("Commputacion Paralela"));
        alumno.inscribirCurso(new Curso("Bases de Datos"));

        System.out.println("Cursos de " + a5.getNombreApellido() + ":");

        // Recorremos usando el Iterator propio
        CursoIterator it = alumno.iterator();
        while (it.hasNext()) {
            Curso c = it.next();
            System.out.println("- " + c.getNombre());
        }




    }
}