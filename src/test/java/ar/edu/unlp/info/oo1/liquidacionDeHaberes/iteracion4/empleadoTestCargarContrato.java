package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class empleadoTestCargarContrato {

    private empleado empleado;
    private contrato contrato;

    @BeforeEach
    public void setUp() {
        empleado = new empleado("Nombre", "Apellido", "123456789", LocalDate.now(), false, false);
        contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
    }

    @Test
    public void testCargarContrato_UnContrato() {
        empleado.cargarContrato(contrato);
        assertEquals(1, empleado.getContratos().size());
        assertTrue(empleado.getContratos().contains(contrato));
    }

    @Test
    public void testCargarContrato_VariosContratos() {
        contrato contrato2 = new contratoDePlanta(LocalDate.now(), 6000.0, 300.0, 150.0);
        contrato contrato3 = new contratoPorHora(LocalDate.now(), 25.0, 160, LocalDate.now().plusMonths(6));

        empleado.cargarContrato(contrato);
        empleado.cargarContrato(contrato2);
        empleado.cargarContrato(contrato3);

        assertEquals(3, empleado.getContratos().size());
        assertTrue(empleado.getContratos().contains(contrato));
        assertTrue(empleado.getContratos().contains(contrato2));
        assertTrue(empleado.getContratos().contains(contrato3));
    }
}