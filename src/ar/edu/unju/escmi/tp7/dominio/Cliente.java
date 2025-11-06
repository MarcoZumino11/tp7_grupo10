package ar.edu.unju.escmi.tp7.dominio;

public abstract class Cliente {

    protected String nombre;
    protected String direccion;
    protected String tipo;

    public Cliente(String nombre, String direccion, String tipo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract void mostrarDatos();
}
