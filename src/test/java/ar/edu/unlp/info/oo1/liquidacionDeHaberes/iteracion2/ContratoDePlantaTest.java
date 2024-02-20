package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion2;

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
        contrato = new contratoDePlanta(LocalDate.now(), 50000.0, 
        		2000.0, 1000.0);
    }
    
    @Test
    public void testEstaVigente() {
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testMontoBasico() {
        empleado empleado = new empleado("Juan", "Perez", "123456789",
        		LocalDate.now(), true, false);
        assertEquals(53000.0, contrato.montoBasico(empleado));
    }
}