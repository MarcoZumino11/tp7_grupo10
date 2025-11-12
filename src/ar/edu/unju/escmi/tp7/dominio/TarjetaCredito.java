package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public class TarjetaCredito {

    // Número de la tarjeta
	private long numero;
    // Fecha de vencimiento
	private LocalDate fechaCaducacion;
    // Cliente titular de la tarjeta
	private Cliente cliente;
    // Límite máximo que puede tener una tarjeta (constante)
	private double limiteCompra;
    // Dinero disponible actualmente
	private double saldoDisponible;

    // Límite general para todas las tarjetas
	private static final double LIMITE_TARJETAS = 2000000.0;

    // Constructor vacío
	public TarjetaCredito() {
    }

    // Constructor con parámetros
    public TarjetaCredito(long numero, LocalDate fechaCaducacion, Cliente cliente, double limiteCompra) {
		this.numero = numero;
		this.fechaCaducacion = fechaCaducacion;
		this.cliente = cliente;
        // Asigna el límite general a todas las tarjetas
		this.limiteCompra = LIMITE_TARJETAS;
        // Asigna el saldo disponible inicial (según lo ingresado)
		this.saldoDisponible = limiteCompra;
	}

    // Getters y Setters
	public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCaducacion() {
        return fechaCaducacion;
    }

    public void setFechaCaducacion(LocalDate fechaCaducacion) {
	       this.fechaCaducacion = fechaCaducacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setLimiteCompra(double limiteCompra) {
		this.limiteCompra = limiteCompra;
	}

    /* ===================== MÉTODOS ===================== */

    // Verifica si la tarjeta tiene suficiente saldo para una compra
	public boolean tieneSaldoSuficiente(double monto) {
        return saldoDisponible >= monto;
    }

    // Descuenta del saldo disponible el monto gastado
    public void descontarMonto(double monto) {
        if (tieneSaldoSuficiente(monto)) {
            saldoDisponible -= monto;
        } else {
            System.out.println("Saldo insuficiente en la tarjeta.");
        }
    }
	
    // Muestra toda la información de la tarjeta
	@Override
	public String toString() {
		return "\nNumero: " + numero 
            + "\nFecha De Caducacion: " + fechaCaducacion 
            + "\nNombre Titular: " + cliente.getNombre() 
            + "\nLimite De Compra Actual: " + limiteCompra 
            + "\nSaldo Disponible: " + saldoDisponible;
	}
	
}