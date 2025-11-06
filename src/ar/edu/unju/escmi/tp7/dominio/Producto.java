package ar.edu.unju.escmi.tp7.dominio;

public class Producto {

    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private String origenFabricacion;

    public Producto(int codigo, String descripcion, double precioUnitario, String origenFabricacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public double aplicarDescuento(double porcentajeDescuento) {
        return precioUnitario * (1 - porcentajeDescuento);
    }

    public void mostrarDatos() {
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio Unitario: $" + precioUnitario);
        System.out.println("Origen de Fabricación: " + origenFabricacion);
    }

    @Override
    public String toString() {
        return codigo + " - " + descripcion + " ($" + precioUnitario + ")";
    }
}
