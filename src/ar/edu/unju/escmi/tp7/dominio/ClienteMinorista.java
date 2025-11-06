package ar.edu.unju.escmi.tp7.dominio;

public class ClienteMinorista extends Cliente {

    private int dni;
    private String telefono;

    public ClienteMinorista(String nombre, String direccion, int dni, String telefono) {
        super(nombre, direccion, "Minorista");
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente Minorista");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("DNI: " + dni);
        System.out.println("Teléfono: " + telefono);
    }
}
