package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTest {

    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Juan", "Perez", "123456789", LocalDate.now(), true, false);
    }

    @Test
    public void testCargarContrato() {
        contratoPorHora contrato = new contratoPorHora(LocalDate.now(), 100.0, 160.0, LocalDate.now().plusMonths(6));
        empleado.cargarContrato(contrato);
        assertEquals(1, empleado.getContratos().size());
    }

    @Test
    public void testContratoVigente() {
        contratoPorHora contrato = new contratoPorHora(LocalDate.now(), 100.0, 160.0, LocalDate.now().plusMonths(6));
        empleado.cargarContrato(contrato);
        assertTrue(empleado.contratoVigente());
    }
}