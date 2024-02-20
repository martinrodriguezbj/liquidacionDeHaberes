package ar.edu.unlp.info.oo1.liquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class nominaEmpresa {
	private List<empleado> empleados;
	
	public nominaEmpresa() {
		empleados = new ArrayList<empleado>();
	}
	
	public empleado agregarEmpleado(String nombre,String apellido, String cuil, LocalDate fechaNacimiento
			, Boolean tieneConyugue, Boolean tieneHijoACargo) {
		empleado e= new empleado(nombre,apellido,cuil,fechaNacimiento,tieneConyugue,tieneHijoACargo);
		empleados.add(e);
		return e;
	}
	
	public empleado agregarEmpleado(empleado e) {
		empleados.add(e);
		return e;
	}
	
	public empleado buscarEmpleado(String cuil) {
		return this.empleados.stream().filter(e -> e.getCuil().equals(cuil)).findAny().orElse(null);
	}
	
	public void bajaEmpleado(empleado emp) {
		this.empleados.remove(emp);
	}
	
	public List<empleado> empleadosConContratosVencidos() {
		return this.empleados.stream().filter(e -> !e.contratoVigente()).collect(Collectors.toList());
	}
	
	public List<recibo> generarRecibos(){
		return this.empleados.stream().filter(e -> e.contratoVigente()).map(e -> e.getRecibo()).collect(Collectors.toList());
	}
	
	public List<empleado> getEmpleados(){
		return this.empleados;
	}
}
