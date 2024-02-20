package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ReciboTest {

    @Test
    public void testToString() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        String expectedString = "Juan, Perez, 123456789, 10.0, " + LocalDate.now() + ", 5000.0";
        assertEquals(expectedString, recibo.toString());
    }

    @Test
    public void testGetNombre() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        assertEquals("Juan", recibo.getNombre());
    }

    @Test
    public void testGetApellido() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        assertEquals("Perez", recibo.getApellido());
    }

    @Test
    public void testGetCuil() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        assertEquals("123456789", recibo.getCuil());
    }

    @Test
    public void testGetAntiguedad() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        assertEquals(10, recibo.getAntiguedad());
    }

    @Test
    public void testGetFechaRecibo() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        assertEquals(LocalDate.now(), recibo.getFechaRecibo());
    }

    @Test
    public void testGetMontoTotal() {
        recibo recibo = new recibo("Juan", "Perez", "123456789", 10, 5000.0);
        assertEquals(5000.0, recibo.getMontoTotal());
    }
}