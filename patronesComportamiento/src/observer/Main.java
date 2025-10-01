package observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    // Estética (podés poner USE_COLORS=false si tu consola no soporta ANSI)
    private static final boolean USE_COLORS = true;
    private static final String R = USE_COLORS ? "\u001B[0m"  : "";
    private static final String B = USE_COLORS ? "\u001B[34m" : "";
    private static final String C = USE_COLORS ? "\u001B[36m" : "";
    private static final String Y = USE_COLORS ? "\u001B[33m" : "";

    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        header("SISTEMA DE NOTIFICACIONES - CURSOS (Observer)");

        // ─────────────────────────────────────────────────────────────
        // 1) Crear cursos
        Curso ds  = new Curso("Desarrollo de Software");
        Curso edd = new Curso("Estructuras de Datos");
        block("CREACIÓN DE CURSOS", () -> {
            line("[" + now() + "] Se crearon: " + Y + ds.getNombre() + R + ", " + Y + edd.getNombre() + R);
        });

        // ─────────────────────────────────────────────────────────────
        // 2) Crear alumnos e inscribir
        Alumno ana   = new Alumno("Ana");
        Alumno bruno = new Alumno("Bruno");
        Alumno carla = new Alumno("Carla");
        Alumno diego = new Alumno("Diego");
        Alumno eva   = new Alumno("Eva");

        Alumno fede  = new Alumno("Fede");
        Alumno gina  = new Alumno("Gina");
        Alumno hernan= new Alumno("Hernán");
        Alumno ivana = new Alumno("Ivana");

        block("INSCRIPCIONES", () -> {
            inscribir(ds, ana, bruno, carla, diego, eva);
            inscribir(edd, fede, gina, hernan, ivana);
            listarInscriptos(ds, edd);
        });

        // ─────────────────────────────────────────────────────────────
        // 3) Notificaciones - Ronda 1
        block("NOTIFICACIONES · RONDA 1", () -> {
            tituloCurso(ds);
            ds.cambiarHorario("Lunes 18:00-20:00 (Aula 12)");
            ds.publicarAviso("Parcial 1 el 15/10");

            tituloCurso(edd);
            edd.cambiarHorario("Miércoles 10:00-12:00 (Lab B)");
            edd.publicarAviso("TP#1 publicado en el campus");
        });

        // ─────────────────────────────────────────────────────────────
        // 4) Bajas
        block("BAJAS / DESINSCRIPCIONES", () -> {
            baja(ds, "Bruno");
            baja(edd, "Gina");
            listarInscriptos(ds, edd);
        });

        // ─────────────────────────────────────────────────────────────
        // 5) Notificaciones - Ronda 2
        block("NOTIFICACIONES · RONDA 2", () -> {
            tituloCurso(ds);
            ds.publicarAviso("Trabajo práctico 2 subido al campus");

            tituloCurso(edd);
            edd.cambiarHorario("Miércoles 10:30-12:30 (Lab B) - Ajuste de horario");
        });

        footer("Demostración finalizada");
    }

    // ─────────────────────────── Helpers estéticos ───────────────────────────

    private static void header(String titulo) {
        System.out.println(B + "════════════════════════════════════════════════════════════════════" + R);
        System.out.println(B + "  " + titulo + R);
        System.out.println(B + "════════════════════════════════════════════════════════════════════" + R);
    }

    private static void footer(String msg) {
        System.out.println(B + "════════════════════════════════════════════════════════════════════" + R);
        System.out.println(B + "  ✔ " + msg + R);
        System.out.println(B + "════════════════════════════════════════════════════════════════════" + R);
    }

    private static void block(String titulo, Runnable content) {
        System.out.println("\n" + C + "────────────────────────────────────────────────────────────────────" + R);
        System.out.println(C + "  " + titulo + R);
        System.out.println(C + "────────────────────────────────────────────────────────────────────" + R);
        content.run();
    }

    private static void line(String s) {
        System.out.println("  " + s);
    }

    private static void tituloCurso(Curso c) {
        System.out.println(Y + "\n▶ " + c.getNombre() + R);
    }

    private static String now() {
        return LocalDateTime.now().format(TS);
    }

    // ─────────────────────────── Lógica de demo ───────────────────────────

    private static void inscribir(Curso c, Alumno... alumnos) {
        for (Alumno a : alumnos) c.addObserver(a);
        line("[" + now() + "] Inscriptos en " + Y + c.getNombre() + R + ": " + String.join(", ", c.getNombresInscriptos()));
    }

    private static void listarInscriptos(Curso... cursos) {
        for (Curso c : cursos) {
            line("Inscriptos en " + Y + c.getNombre() + R + ": " + String.join(", ", c.getNombresInscriptos()));
        }
    }

    private static void baja(Curso c, String nombreAlumno) {
        boolean ok = c.removeObserverByName(nombreAlumno);
        if (ok) {
            line("[" + now() + "] Baja en " + Y + c.getNombre() + R + ": " + nombreAlumno);
        } else {
            line("[" + now() + "] Baja en " + Y + c.getNombre() + R + ": " + nombreAlumno + " (no estaba inscripto)");
        }
    }
}
