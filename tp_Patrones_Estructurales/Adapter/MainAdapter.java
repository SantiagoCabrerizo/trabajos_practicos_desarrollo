package Adapter;
import Adapter.Impresora;
import Adapter.ImpresoraPDF;

public class MainAdapter {
    public static void main(String[] args) {
        System.out.println("--------ADAPTER--------");
        //impresora de pdf existente
        Impresora impresora = new ImpresoraPDF();
        impresora.imprimir("documento.pdf");
        impresora.imprimir("texto.txt");
        impresora.imprimir("word.doc");//no se imprimiria

    }
}