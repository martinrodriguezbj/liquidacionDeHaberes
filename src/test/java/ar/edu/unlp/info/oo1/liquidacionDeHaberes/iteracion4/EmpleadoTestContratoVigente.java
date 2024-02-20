package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTestContratoVigente {

    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now(), false, false);
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
    public void testContratoVigente_ContratoNoVigente() {
        contrato contrato = new contratoPorHora(LocalDate.now().minusMonths(6), 20.0, 160, LocalDate.now().minusMonths(1));
        empleado.cargarContrato(contrato);
        assertFalse(empleado.contratoVigente());
    }
}