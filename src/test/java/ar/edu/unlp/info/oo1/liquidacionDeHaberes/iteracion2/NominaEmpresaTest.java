package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class NominaEmpresaTest {

    private nominaEmpresa nomina;

    @BeforeEach
    public void setUp() {
        nomina = new nominaEmpresa();
    }

    @Test
    public void testAgregarEmpleado() {
        empleado empleado = nomina.agregarEmpleado("Juan", "Perez", "123456789", LocalDate.now(), true, false);
        assertNotNull(empleado);
    }

    @Test
    public void testBuscarEmpleado() {
        empleado empleado = nomina.agregarEmpleado("Juan", "Perez", "123456789", LocalDate.now(), true, false);
        assertEquals(empleado, nomina.buscarEmpleado("123456789"));
    }

    @Test
    public void testBajaEmpleado() {
        empleado empleado = nomina.agregarEmpleado("Juan", "Perez", "123456789", LocalDate.now(), true, false);
        nomina.bajaEmpleado(empleado);
        assertNull(nomina.buscarEmpleado("123456789"));
    }
}