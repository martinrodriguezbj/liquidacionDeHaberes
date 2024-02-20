package ar.edu.unlp.info.oo1.liquidacionDeHaberes;

import java.time.LocalDate;
import java.util.List;

public abstract class contrato {
	protected LocalDate fechaInicio;
	
	public contrato(LocalDate fechainicio) {
		this.fechaInicio=fechainicio;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public abstract boolean estaVigente();
	
	
	public abstract double montoBasico(empleado e);
	
}
