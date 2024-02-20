package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class NominaEmpresaTestGenerarRecibos {

    private nominaEmpresa nominaEmpresa;

    @BeforeEach
    public void setUp() {
        nominaEmpresa = new nominaEmpresa();
        nominaEmpresa.agregarEmpleado("Nombre1", "Apellido1", "123456789", 
				LocalDate.of(1990, 1, 1), false, false);
        nominaEmpresa.agregarEmpleado("Nombre2", "Apellido2", "987654321", 
				LocalDate.of(1995, 1, 1), true, true);
    }

    @Test
    public void testGenerarRecibos_NingunEmpleado() {
        assertEquals(0, nominaEmpresa.generarRecibos().size());
    }

    @Test
    public void testGenerarRecibos_UnEmpleadoConContratoVigente() {
        empleado empleado = nominaEmpresa.buscarEmpleado("123456789");
        contrato contrato = new contratoDePlanta(LocalDate.now(),
				5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertEquals(1, nominaEmpresa.generarRecibos().size());
    }

    @Test
    public void testGenerarRecibos_UnEmpleadoSinContratoVigente() {
        empleado empleado = nominaEmpresa.buscarEmpleado("123456789");
        contrato contrato = new contratoDePlanta(LocalDate.now().minusYears(1),
				 5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertEquals(0, nominaEmpresa.generarRecibos().size());
    }
}