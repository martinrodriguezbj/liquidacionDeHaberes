package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTest {
    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Juan", "Perez", 
        		"123456789", LocalDate.of(1990, 5, 15), true, false);
    }

    @Test
    public void testCargarContrato() {
        contrato contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertTrue(empleado.getContratos().contains(contrato));
    }

    @Test
    public void testGetContratoActual_SinContratos() {
        assertNull(empleado.getContratoActual());
    }

    @Test
    public void testGetContratoActual_ContratoUnico() {
        contrato contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertEquals(contrato, empleado.getContratoActual());
    }

    @Test
    public void testGetContratoActual_MultiplesContratos() {
        contrato contrato1 = new contratoDePlanta(LocalDate.now(), 
        		5000.0, 200.0, 100.0);
        contrato contrato2 = new contratoDePlanta(LocalDate.now().
        		minusMonths(6), 6000.0, 300.0, 150.0);
        empleado.cargarContrato(contrato1);
        empleado.cargarContrato(contrato2);
        assertEquals(contrato2, empleado.getContratoActual());
    }

    @Test
    public void testContratoVigente_SinContratos() {
        assertFalse(empleado.contratoVigente());
    }

    @Test
    public void testContratoVigente_ContratoVigente() {
        contrato contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertTrue(empleado.contratoVigente());
    }

    @Test
    public void testContratoVigente_ContratoVencido() {
        contrato contrato = new contratoDePlanta(LocalDate.now().minusMonths(6),
        		6000.0, 300.0, 150.0);
        empleado.cargarContrato(contrato);
        assertFalse(empleado.contratoVigente());
    }

    @Test
    public void testGetAntiguedad() {
        assertEquals(32, empleado.getAntiguedad()); 
        // Calculado en base a la fecha actual (año 2022)
    }

    @Test
    public void testGetRecibo_ContratoVigente() {
        contrato contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        recibo recibo = empleado.getRecibo();
        assertNotNull(recibo);
        assertTrue(empleado.getRecibos().contains(recibo));
    }

    @Test
    public void testGetRecibo_ContratoVencido() {
        contrato contrato = new contratoDePlanta(LocalDate.now().minusMonths(6),
        		6000.0, 300.0, 150.0);
        empleado.cargarContrato(contrato);
        assertNull(empleado.getRecibo());
    }

    @Test
    public void testBasicoMasAntiguedad_MenosDe5Anios() {
        assertEquals(5000.0, empleado.basicoMasAntiguedad());
    }

    @Test
    public void testBasicoMasAntiguedad_5Anios() {
        empleado.cambiarFechaInicio(LocalDate.now().minusYears(5));
        assertEquals(6500.0, empleado.basicoMasAntiguedad());
    }
    @Test
    public void testBasicoMasAntiguedad_10Anios() {
        empleado.cambiarFechaInicio(LocalDate.now().minusYears(10));
        assertEquals(7500.0, empleado.basicoMasAntiguedad());
    }
    @Test
    public void testBasicoMasAntiguedad_15Anios() {
        empleado.cambiarFechaInicio(LocalDate.now().minusYears(15));
        assertEquals(8500.0, empleado.basicoMasAntiguedad());
    }
    @Test
    public void testBasicoMasAntiguedad_20Anios() {
        empleado.cambiarFechaInicio(LocalDate.now().minusYears(20));
        assertEquals(10000.0, empleado.basicoMasAntiguedad());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Juan", empleado.getNombre());
    }

    @Test
    public void testGetApellido() {
        assertEquals("Perez", empleado.getApellido());
    }

    @Test
    public void testGetCuil() {
        assertEquals("123456789", empleado.getCuil());
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals(LocalDate.of(1990, 5, 15), empleado.getFechaNacimiento());
    }

    @Test
    public void testGetTieneConyuge() {
        assertTrue(empleado.getTieneConyuge());
    }

    @Test
    public void testGetTieneHijos() {
        assertFalse(empleado.getTieneHijos());
    }

    @Test
    public void testGetFechaInicio() {
        assertEquals(LocalDate.now(), empleado.getFechaInicio());
    }

    @Test
    public void testGetContratos() {
        assertEquals(new ArrayList<contrato>(), empleado.getContratos());
    }

    @Test
    public void testGetRecibos() {
        assertEquals(new ArrayList<recibo>(), empleado.getRecibos());
    }
}