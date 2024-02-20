package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ReciboTest {

    private recibo recibo;

    @BeforeEach
    public void setUp() {
        recibo = new recibo("Juan", "Perez", "123456789", 5, 20000.0);
    }

    @Test
    public void testToString() {
        assertEquals("Juan, Perez, 123456789, 5.0,"
        		+ " " + LocalDate.now() + ", 20000.0", recibo.toString());
    }
}
