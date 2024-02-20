package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoDePlantaTest {
    private contratoDePlanta contrato;

    @BeforeEach
    public void setUp() {
        LocalDate fechaInicio = LocalDate.now();
        double sueldoMensual = 5000.0;
        double montoPorConyugue = 200.0;
        double montoPorHijos = 100.0;
        contrato = new contratoDePlanta(fechaInicio, sueldoMensual
        		, montoPorConyugue, montoPorHijos);
    }

    @Test
    public void testEstaVigente() {
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testMontoBasico_SinConyugueNiHijos() {
        empleado empleado = new empleado("Juan", "Perez", 
        		"123456789", LocalDate.of(1990, 5, 15), false, false);
        assertEquals(5000.0, contrato.montoBasico(empleado));
    }

    @Test
    public void testMontoBasico_ConConyugue() {
        empleado empleado = new empleado("Maria", "Lopez", 
        		"987654321", LocalDate.of(1985, 3, 20), true, false);
        assertEquals(5200.0, contrato.montoBasico(empleado));
    }

    @Test
    public void testMontoBasico_ConHijos() {
        empleado empleado = new empleado("Pedro", "Garcia", 
        		"456789123", LocalDate.of(1988, 8, 10), false, true);
        assertEquals(5100.0, contrato.montoBasico(empleado));
    }

    @Test
    public void testMontoBasico_ConConyugueYHijos() {
        empleado empleado = new empleado("Ana", "Martinez", 
        		"321654987", LocalDate.of(1983, 10, 25), true, true);
        assertEquals(5300.0, contrato.montoBasico(empleado));
    }
}