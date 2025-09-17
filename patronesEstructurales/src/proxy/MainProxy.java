package proxy;

public class MainProxy {
    public static void main(String[] args) {
        Usuario admin = new Usuario("Admin", true);
        Usuario user = new Usuario("User", false);

        Archivo archivo1 = new ArchivoProxy("DatosPrivados.txt", admin);
        Archivo archivo2 = new ArchivoProxy("DatosPrivados2.txt", user);

        // Caso 1: El usuario tiene permisos para abrir el archivo porque es admin.
        archivo1.abrirArchivo();
        System.out.println(" ----------- ");
        // Caso 2: El usuario no tiene permisos para abrir el archivo, porque no es admin.
        archivo2.abrirArchivo();

    }
}
