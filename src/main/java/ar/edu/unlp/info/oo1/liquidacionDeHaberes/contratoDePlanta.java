package ar.edu.unlp.info.oo1.liquidacionDeHaberes;

import java.time.LocalDate;

public class contratoDePlanta extends contrato{
	private double sueldoMensual;
	private double montoPorConyugue;
	private double montoPorHijos;
	
	public contratoDePlanta (LocalDate fechaInicio,double sueldoMensual,double montoPorConyugue, double montoPorHijos) {
		super(fechaInicio);
		this.sueldoMensual=sueldoMensual;
		this.montoPorConyugue=montoPorConyugue;
		this.montoPorHijos=montoPorHijos;
	}

	@Override
	public boolean estaVigente() {
		return true;
	}

	@Override
	public double montoBasico(empleado e) {
		double basico=this.sueldoMensual;
		if (e.getTieneConyuge())
			basico=basico+this.montoPorConyugue;
		if (e.getTieneHijos())
			basico=basico+this.montoPorHijos;
		return basico;
	}

	public double getSueldoMensual() {
		return sueldoMensual;
	}

	public double getMontoPorConyugue() {
		return montoPorConyugue;
	}

	public double getMontoPorHijos() {
		return montoPorHijos;
	}
	
	
}
