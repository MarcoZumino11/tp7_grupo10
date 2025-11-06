package ar.edu.unju.escmi.tp7.dominio;

public class ClienteMayorista extends Cliente {

    private String cuit;
    private double descuento;

    public ClienteMayorista(String nombre, String direccion, String cuit, double descuento) {
        super(nombre, direccion, "Mayorista");
        this.cuit = cuit;
        this.descuento = descuento;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente Mayorista");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("CUIT: " + cuit);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
    }
}
