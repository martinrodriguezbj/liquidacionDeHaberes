package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoPorHoraTest {

    private contratoPorHora contrato;

    @BeforeEach
    public void setUp() {
        contrato = new contratoPorHora(LocalDate.now(), 100.0, 160.0, LocalDate.now().plusMonths(6));
    }

    @Test
    public void testEstaVigente() {
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testMontoBasico() {
        empleado empleado = new empleado("Maria", "Lopez", "987654321", LocalDate.now(), false, true);
        assertEquals(16000.0, contrato.montoBasico(empleado));
    }
}