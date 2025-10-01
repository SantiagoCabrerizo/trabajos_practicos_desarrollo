package Visitor;

public class AlumnoBecado {
    private String nombre;
    private double cuota;
    private double porcentajeBeca; // ej. 0.5 = 50% de descuento

    public AlumnoBecado(String nombre, double cuota, double porcentajeBeca) {
        this.nombre = nombre;
        this.cuota = cuota;
        this.porcentajeBeca = porcentajeBeca;
    }

    public String getNombre() { return nombre; }
    public double getCuota() { return cuota; }
    public double getPorcentajeBeca() { return porcentajeBeca; }
    //METODO ACEPTAR
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}