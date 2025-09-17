package Adapter;
//Clase existente que imprime documentos en formato pdf
public class ImpresoraPDF implements Impresora {
    private ImpresoraTextoAdapter impresoraTextoAdapter;
    public void imprimir(String documento) {
        if (documento.equalsIgnoreCase("documento.pdf")) {
            System.out.println("Imprimiendo documento pdf: " + documento);
        } else {
            impresoraTextoAdapter = new ImpresoraTextoAdapter();
            impresoraTextoAdapter.imprimir(documento);
        }
    }
}

