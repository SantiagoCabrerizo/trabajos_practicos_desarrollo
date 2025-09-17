package Adapter;
//Adaptador para ImpresoraTexto
public class ImpresoraTextoAdapter implements Impresora {
    private ImpresoraTexto impresoraTexto;

    public ImpresoraTextoAdapter() {
        impresoraTexto =  new ImpresoraTexto();
    }

    @Override
    public void imprimir(String documento) {
        if (documento.equalsIgnoreCase("texto.txt")) {
            impresoraTexto.imprimirTexto(documento);
        } else {
            System.out.println("No se puede imprimir " + documento + " por su formato.");
        }
    }
}

