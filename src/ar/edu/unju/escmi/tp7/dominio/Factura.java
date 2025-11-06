package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private int numero;
    private LocalDate fecha;
    private Cliente cliente;
    private List<Detalle> detalles;
    private double total;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(Detalle detalle) {
        detalles.add(detalle);
        calcularTotal();
    }

    public double getTotal() {
        return total;
    }

    public void calcularTotal() {
        double suma = 0;
        for (Detalle d : detalles) {
            suma += d.getImporte();
        }
        total = suma;
    }

    public void mostrarFactura() {
        System.out.println("================================");
        System.out.println("Factura N°: " + numero);
        System.out.println("Fecha: " + fecha);
        System.out.println("--------------------------------");
        cliente.mostrarDatos();
        System.out.println("--------------------------------");
        for (Detalle d : detalles) {
            d.mostrarDetalle();
        }
        System.out.println("--------------------------------");
        System.out.println("TOTAL: $" + total);
        System.out.println("================================");
    }
}
