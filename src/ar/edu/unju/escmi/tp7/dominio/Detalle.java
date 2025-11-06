package ar.edu.unju.escmi.tp7.dominio;

public class Detalle {

    private Producto producto;
    private int cantidad;
    private double importe;

    public Detalle(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = producto.getPrecioUnitario() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.importe = producto.getPrecioUnitario() * cantidad;
    }

    public double getImporte() {
        return importe;
    }

    // Muestra el detalle de un producto dentro de una factura
    public void mostrarDetalle() {
        System.out.println(producto.getDescripcion() + " x" + cantidad + " = $" + importe);
    }

    @Override
    public String toString() {
        return producto.getDescripcion() + " x" + cantidad + " - $" + importe;
    }
}
