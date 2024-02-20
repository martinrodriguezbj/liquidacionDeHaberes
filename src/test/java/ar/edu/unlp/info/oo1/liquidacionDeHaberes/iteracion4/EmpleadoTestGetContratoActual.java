package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTestGetContratoActual {

    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Nombre", "Apellido", "123456789", 
			LocalDate.now(), false, false);
    }

    @Test
    public void testGetContratoActual_SinContratos() {
        assertNull(empleado.getContratoActual());
    }

    @Test
    public void testGetContratoActual_UnContrato() {
        contrato contrato = new contratoDePlanta(LocalDate.now(), 
			5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertEquals(contrato, empleado.getContratoActual());
    }

    @Test
    public void testGetContratoActual_VariosContratos() {
        contrato contrato1 = new contratoDePlanta(LocalDate.now().minusYears(2), 
			5000.0, 200.0, 100.0);
        contrato contrato2 = new contratoPorHora(LocalDate.now().minusMonths(6), 
			20.0, 160, LocalDate.now().plusMonths(6));
        contrato contrato3 = new contratoDePlanta(LocalDate.now(), 
			6000.0, 300.0, 150.0);

        empleado.cargarContrato(contrato1);
        empleado.cargarContrato(contrato2);
        empleado.cargarContrato(contrato3);

        assertEquals(contrato3, empleado.getContratoActual());
    }
}
