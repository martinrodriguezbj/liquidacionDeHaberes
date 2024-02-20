package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class NominaEmpresaTest {
    private nominaEmpresa nomina;

    @BeforeEach
    public void setUp() {
        nomina = new nominaEmpresa();
    }

    @Test
    public void testAgregarEmpleado() {
        empleado empleado = nomina.agregarEmpleado("Juan", "Perez", "123456789",
        		LocalDate.of(1990, 5, 15), true, false);
        assertTrue(nomina.getEmpleados().contains(empleado));
    }

    @Test
    public void testBuscarEmpleado_Existente() {
        empleado empleado = nomina.agregarEmpleado("Juan", "Perez",
        		"123456789", LocalDate.of(1990, 5, 15), true, false);
        assertEquals(empleado, nomina.buscarEmpleado("123456789"));
    }

    @Test
    public void testBuscarEmpleado_NoExistente() {
        assertNull(nomina.buscarEmpleado("999999999"));
    }

    @Test
    public void testBajaEmpleado() {
        empleado empleado = nomina.agregarEmpleado("Juan", "Perez", "123456789",
        		LocalDate.of(1990, 5, 15), true, false);
        nomina.bajaEmpleado(empleado);
        assertFalse(nomina.getEmpleados().contains(empleado));
    }

    @Test
    public void testEmpleadosConContratosVencidos() {
        empleado empleado1 = nomina.agregarEmpleado("Juan", "Perez", "123456789", 
        		LocalDate.of(1990, 5, 15), true, false);
        empleado empleado2 = nomina.agregarEmpleado("Maria", "Lopez", "987654321",
        		LocalDate.of(1985, 3, 20), true, false);
        contrato contrato1 = new contratoDePlanta(LocalDate.now().minusMonths(6),
        		5000.0, 200.0, 100.0);
        contrato contrato2 = new contratoDePlanta(LocalDate.now().minusMonths(3),
        		6000.0, 300.0, 150.0);
        empleado1.cargarContrato(contrato1);
        empleado2.cargarContrato(contrato2);
        List<empleado> empleadosConContratosVencidos = nomina.empleadosConContratosVencidos();
        assertTrue(empleadosConContratosVencidos.contains(empleado1));
        assertTrue(empleadosConContratosVencidos.contains(empleado2));
        assertEquals(2, empleadosConContratosVencidos.size());
    }

    @Test
    public void testGenerarRecibos() {
        empleado empleado1 = nomina.agregarEmpleado("Juan", "Perez", "123456789",
        		LocalDate.of(1990, 5, 15), true, false);
        empleado empleado2 = nomina.agregarEmpleado("Maria", "Lopez", "987654321",
        		LocalDate.of(1985, 3, 20), true, false);
        contrato contrato1 = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
        contrato contrato2 = new contratoDePlanta(LocalDate.now().minusMonths(3),
        		6000.0, 300.0, 150.0);
        empleado1.cargarContrato(contrato1);
        empleado2.cargarContrato(contrato2);
        List<recibo> recibos = nomina.generarRecibos();
        assertEquals(1, recibos.size());
    }

    @Test
    public void testGetEmpleados() {
        assertEquals(new ArrayList<empleado>(), nomina.getEmpleados());
    }
}