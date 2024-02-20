package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class NominaEmpresaTestAgregarEmpleado {

    private nominaEmpresa nominaEmpresa;

    @BeforeEach
    public void setUp() {
        nominaEmpresa = new nominaEmpresa();
    }

    @Test
    public void testAgregarEmpleado_UnEmpleado() {
        empleado empleado = nominaEmpresa.agregarEmpleado("Nombre", "Apellido", 			"123456789", LocalDate.of(1990, 1, 1), false, false);
        assertEquals(1, nominaEmpresa.getEmpleados().size());
        assertTrue(nominaEmpresa.getEmpleados().contains(empleado));
    }

    @Test
    public void testAgregarEmpleado_VariosEmpleados() {
        empleado empleado1 = nominaEmpresa.agregarEmpleado("Nombre1", "Apellido1", 
			"123456789", LocalDate.of(1990, 1, 1), false, false);
        empleado empleado2 = nominaEmpresa.agregarEmpleado("Nombre2", "Apellido2", 						"987654321", LocalDate.of(1995, 1, 1), true, true);
        assertEquals(2, nominaEmpresa.getEmpleados().size());
        assertTrue(nominaEmpresa.getEmpleados().contains(empleado1));
        assertTrue(nominaEmpresa.getEmpleados().contains(empleado2));
    }
}