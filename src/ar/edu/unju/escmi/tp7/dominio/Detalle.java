package ar.edu.unju.escmi.tp7.dominio;

public class Detalle {

    // Atributos de cada detalle de la factura
	private int cantidad;
    private double importe;
    private Producto producto;
    private boolean estadoAhora30; // true = pertenece al programa Ahora 30, false = producto normal

    // Constructor vacío
    public Detalle() {
    }

    // Constructor con parámetros
    public Detalle(int cantidad, double importe, Producto producto, boolean estadoAhora30) {
        this.cantidad = cantidad;
        this.importe = importe;
        this.producto = producto;
        this.estadoAhora30 = estadoAhora30;
    }

    // Getters y setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEstadoAhora30() {
        return estadoAhora30;
    }

    public void setEstadoAhora30(boolean estadoAhora30) {
        this.estadoAhora30 = estadoAhora30;
    }

    // Muestra la información completa del detalle
    @Override
    public String toString() {
        return "--- PRODUCTO ---" + producto + 
            "\nCANTIDAD: " + cantidad +
            "\nIMPORTE: $" + importe + 
            "\n" + (estadoAhora30 ? "PERTENECE AL PROGRAMA AHORA 30" : "PRODUCTO NORMAL");
   
        }

}