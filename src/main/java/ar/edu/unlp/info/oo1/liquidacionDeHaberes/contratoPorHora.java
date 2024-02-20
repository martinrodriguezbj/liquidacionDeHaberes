package ar.edu.unlp.info.oo1.liquidacionDeHaberes;

import java.time.LocalDate;

public class contratoPorHora extends contrato{
	private double valorPorHora;
	private double cantHorasPorMes;
	private LocalDate fechaFin;
	
	public contratoPorHora(LocalDate fechaInicio,double valorPorHora,double cantHorasPorMes,LocalDate fechaFin) {
		super(fechaInicio);
		this.valorPorHora=valorPorHora;
		this.cantHorasPorMes=cantHorasPorMes;
		this.fechaFin=fechaFin;
	}

	@Override
	public boolean estaVigente() {
		return this.fechaFin.isAfter(LocalDate.now());
	}

	@Override
	public double montoBasico(empleado e) {
		return this.valorPorHora*this.cantHorasPorMes;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public double getCantHorasPorMes() {
		return cantHorasPorMes;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	
}
