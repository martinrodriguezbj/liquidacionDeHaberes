package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class EmpleadoTestGetRecibo {

    private empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Nombre", "Apellido", "123456789", 
			LocalDate.of(2000, 1, 1), false, false);
    }

    @Test
    public void testGetRecibo_SinContratos() {
        assertNull(empleado.getRecibo());
    }

    @Test
    public void testGetRecibo_ContratoNoVigente() {
        contrato contrato = new contratoDePlanta(LocalDate.now().minusYears(1), 
			5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertNull(empleado.getRecibo());
    }

    @Test
    public void testGetRecibo_ContratoVigente() {
        contrato contrato = new contratoDePlanta(LocalDate.now(), 
			5000.0, 200.0, 100.0);
        empleado.cargarContrato(contrato);
        assertNotNull(empleado.getRecibo());
    }
}