package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTestGetAntiguedad {

    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.of(2000, 1, 1), false, false);
    }

    @Test
    public void testGetAntiguedad_FechaInicioHoy() {
        assertEquals(0, empleado.getAntiguedad());
    }

    @Test
    public void testGetAntiguedad_FechaInicioAyer() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusDays(1), false, false);
        assertEquals(0, empleado.getAntiguedad());
    }

    @Test
    public void testGetAntiguedad_FechaInicioHaceUnAnio() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusYears(1), false, false);
        assertEquals(1, empleado.getAntiguedad());
    }

    @Test
    public void testGetAntiguedad_FechaInicioHaceDiezAnios() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusYears(10), false, false);
        assertEquals(10, empleado.getAntiguedad());
    }
}