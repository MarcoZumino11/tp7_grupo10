package ar.edu.unju.escmi.tp7.dominio;

public class Stock {

    private Producto producto;
    private int cantidadDisponible;

    public Stock(Producto producto, int cantidadDisponible) {
        this.producto = producto;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void actualizarStock(int cantidad) {
        this.cantidadDisponible += cantidad;
        if (this.cantidadDisponible < 0) {
            this.cantidadDisponible = 0;
        }
    }

    public boolean hayStockSuficiente(int cantidad) {
        return cantidadDisponible >= cantidad;
    }

    public void mostrarDatos() {
        System.out.println("Producto: " + producto.getDescripcion());
        System.out.println("Cantidad disponible: " + cantidadDisponible);
    }

    @Override
    public String toString() {
        return producto.getDescripcion() + " | Stock: " + cantidadDisponible;
    }
}
