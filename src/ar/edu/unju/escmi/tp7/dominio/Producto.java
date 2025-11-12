package ar.edu.unju.escmi.tp7.dominio;

public class Producto {

    // Atributos principales del producto
	private long codigo;
    private String descripcion;
    private double precioUnitario;
    private String origenFabricacion;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(long codigo, String descripcion, double precioUnitario, String origenFabricacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
    }

    // Getters y setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(String origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    // Muestra la información completa del producto
    @Override
    public String toString() {
        return "\nCodigo: " + codigo 
                + "\nDescripcion: " + descripcion 
                + "\nPrecio Unitario: $" + precioUnitario
                + "\nOrigen fabricacion: " + origenFabricacion;
    }
}
