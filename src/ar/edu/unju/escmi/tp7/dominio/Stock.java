package ar.edu.unju.escmi.tp7.dominio;

public class Stock {

    // Cantidad disponible del producto en el stock
	private int cantidad;
    // Producto al que pertenece el stock
	private Producto producto;

    // Constructor vacío
	public Stock() {
    }

    // Constructor con parámetros
    public Stock(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /* ===================== MÉTODOS ===================== */

    // Verifica si hay suficiente stock para realizar una venta
    public boolean validarStockDisponible(int cantidadSolicitada) {
        if (this.cantidad < cantidadSolicitada) {
            return false; // No hay stock suficiente
        }
        return true; // Hay stock suficiente
    }

    // Resta del stock la cantidad vendida
    public void actualizarStock(int cantidadVendida) {
        if (cantidadVendida > this.cantidad) {
            System.out.println("No hay stock suficiente");
        } else {
            this.cantidad = this.cantidad - cantidadVendida;
        }
    }
}