package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ReciboTestToString {

    private recibo recibo;

    @BeforeEach
    public void setUp() {
        recibo = new recibo("Nombre", "Apellido", "123456789", 5, 5000.0);
    }

    @Test
    public void testToString() {
        String expected = "Nombre, Apellido, 123456789, 5.0, " + LocalDate.now() + ", 5000.0";
        assertEquals(expected, recibo.toString());
    }
}