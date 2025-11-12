package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public class Cuota {

	private double monto;
	private int nroCuota;
	private LocalDate fechaGeneracion;
	private LocalDate fechaVencimiento;
	private boolean estado; // true = PAGADA, false = PENDIENTE

	// Constructor vacío
	public Cuota() {
	}

	// Constructor con parámetros
	public Cuota(double monto, int nroCuota, LocalDate fechaGeneracion, LocalDate fechaVencimiento, boolean estado) {
		this.monto = monto;
		this.nroCuota = nroCuota;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaVencimiento = fechaVencimiento;
		this.estado = estado;
	}

	// Getters y setters
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public LocalDate getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(LocalDate fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// Muestra la información de la cuota
	@Override
	public String toString() {
		return "Monto: " + monto + ", N° De Cuota:" + nroCuota + ", Fecha De Generacion: " + fechaGeneracion
				+ ", Fecha De Vencimiento: " + fechaVencimiento + ", Estado: " + (estado ? "PAGADO" : "PENDIENTE")
				+ "\n";
	}
	
}