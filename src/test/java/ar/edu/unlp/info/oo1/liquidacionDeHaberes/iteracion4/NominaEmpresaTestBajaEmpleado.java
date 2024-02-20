package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class NominaEmpresaTestBajaEmpleado {

    private nominaEmpresa nominaEmpresa;
    private empleado empleado;

    @BeforeEach
    public void setUp() {
        nominaEmpresa = new nominaEmpresa();
        empleado = nominaEmpresa.agregarEmpleado("Nombre", "Apellido", "123456789", 
			LocalDate.of(1990, 1, 1), false, false);
    }

    @Test
    public void testBajaEmpleado_EmpleadoExistente() {
        assertEquals(1, nominaEmpresa.getEmpleados().size());
        nominaEmpresa.bajaEmpleado(empleado);
        assertEquals(0, nominaEmpresa.getEmpleados().size());
    }

    @Test
    public void testBajaEmpleado_EmpleadoNoExistente() {
        empleado empleadoNoExistente = new empleado("Nombre2", "Apellido2", "987654321", 
			LocalDate.of(1995, 1, 1), true, true);
        assertEquals(1, nominaEmpresa.getEmpleados().size());
        nominaEmpresa.bajaEmpleado(empleadoNoExistente);
        assertEquals(1, nominaEmpresa.getEmpleados().size());
    }
}