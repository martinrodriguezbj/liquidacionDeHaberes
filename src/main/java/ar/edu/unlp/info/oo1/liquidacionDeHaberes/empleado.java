package ar.edu.unlp.info.oo1.liquidacionDeHaberes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.YEARS;


public class empleado {
	private String nombre;
	private String apellido;	
	private String cuil;
	private LocalDate fechaNacimiento;
	private Boolean tieneConyuge;
	private Boolean tieneHijos;
	private LocalDate fechaInicio;
	private List<contrato> contratos;
	private List<recibo> recibos;
	
	public empleado (String nombre,String apellido, String cuil, LocalDate fechaNacimiento
			, Boolean tieneConyugue, Boolean tieneHijos) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.cuil=cuil;
		this.fechaNacimiento=fechaNacimiento;
		this.tieneConyuge=tieneConyugue;
		this.tieneHijos=tieneHijos;
		this.fechaInicio=LocalDate.now();
		contratos = new ArrayList<>();
		recibos = new ArrayList<>();
	}
	
	public void cargarContrato(contrato c) {
		this.contratos.add(c);
	}
	
	
	public contrato getContratoActual() {
	    return this.contratos
	            .stream()
	            .max((contrato c1, contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()))
	            .orElse(null);
	}
	
	public boolean contratoVigente() {
		try { //si el empleado no tiene ningun contrato, esto da error
			return this.getContratoActual().estaVigente();
		}
		catch (Exception e) {
			return false;
		}
	}

	
	public double getAntiguedad() {
		return (int)YEARS.between(this.fechaInicio,LocalDate.now());
	}

	public recibo getRecibo() {
	    contrato contratoActual = getContratoActual();
	    if (contratoActual != null && contratoActual.estaVigente()) {
	        recibo r = new recibo(this.nombre, this.apellido, this.cuil, this.getAntiguedad(), this.basicoMasAntiguedad());
	        this.recibos.add(r);
	        return r;
	    } else {
	        return null;
	    }
	}
	
	public double basicoMasAntiguedad() {
		double antiguedad = this.getAntiguedad();
		double montoBasico = this.getContratoActual().montoBasico(this);
		if (antiguedad<5)
			return montoBasico;
		if (antiguedad<10)
			return montoBasico*1.3;
		if (antiguedad<15)
			return montoBasico*1.5;
		if (antiguedad<20)
			return montoBasico*1.7;
		if (antiguedad>=20)
			return montoBasico*2.0;
		return 0;
	}
	
	public void cambiarFechaInicio(LocalDate nuevaFechaInicio) {
		this.fechaInicio=nuevaFechaInicio;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Boolean getTieneConyuge() {
		return tieneConyuge;
	}

	public Boolean getTieneHijos() {
		return tieneHijos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public List<contrato> getContratos() {
		return contratos;
	}

	public List<recibo> getRecibos() {
		return recibos;
	}

}
