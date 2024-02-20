package ar.edu.unlp.info.oo1.liquidacionDeHaberes;

import java.time.LocalDate;

public class recibo {
	private String nombre;
	private String apellido;
	private String cuil;
	private double antiguedad;
	private LocalDate fechaRecibo;
	private double montoTotal;
	
	public recibo(String nom,String ape,String cuil,double ant,double monto) {
		this.nombre=nom;
		this.apellido=ape;
		this.cuil=cuil;
		this.antiguedad=ant;
		this.fechaRecibo=LocalDate.now();
		this.montoTotal=monto;
	}
	
	
	public String toString() {
		return this.nombre +", " + this.apellido+", " + this.cuil+", " + this.antiguedad+", " + this.fechaRecibo+", "+ this.montoTotal;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getCuil() {
		return cuil;
	}


	public double getAntiguedad() {
		return antiguedad;
	}


	public LocalDate getFechaRecibo() {
		return fechaRecibo;
	}


	public double getMontoTotal() {
		return montoTotal;
	}
	
	
}
