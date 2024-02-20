package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class NominaEmpresaTestBuscarEmpleado {

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
    public void testBuscarEmpleado_Existente() {
        empleado empleado = nominaEmpresa.buscarEmpleado("123456789");
        assertNotNull(empleado);
        assertEquals("Nombre1", empleado.getNombre());
    }

    @Test
    public void testBuscarEmpleado_NoExistente() {
        empleado empleado = nominaEmpresa.buscarEmpleado("111111111");
        assertNull(empleado);
    }
}