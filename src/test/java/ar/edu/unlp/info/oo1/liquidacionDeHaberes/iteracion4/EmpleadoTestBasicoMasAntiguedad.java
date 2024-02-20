package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTestBasicoMasAntiguedad {

    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.of(2000, 1, 1), false, false);
    }

    @Test
    public void testBasicoMasAntiguedad_MenosDeCincoAnios() {
        assertEquals(5000.0, empleado.basicoMasAntiguedad());
    }

    @Test
    public void testBasicoMasAntiguedad_CincoAnios() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusYears(5), false, false);
        assertEquals(6500.0, empleado.basicoMasAntiguedad());
    }

    @Test
    public void testBasicoMasAntiguedad_DiezAnios() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusYears(10), false, false);
        assertEquals(7500.0, empleado.basicoMasAntiguedad());
    }

    @Test
    public void testBasicoMasAntiguedad_QuinceAnios() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusYears(15), false, false);
        assertEquals(8500.0, empleado.basicoMasAntiguedad());
    }

    @Test
    public void testBasicoMasAntiguedad_VeinteAnios() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now().minusYears(20), false, false);
        assertEquals(10000.0, empleado.basicoMasAntiguedad());
    }
}
