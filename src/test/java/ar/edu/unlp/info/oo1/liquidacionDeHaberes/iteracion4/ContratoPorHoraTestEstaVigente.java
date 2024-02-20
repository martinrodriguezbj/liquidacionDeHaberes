package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoPorHoraTestEstaVigente {

    private contratoPorHora contrato;

    @BeforeEach
    public void setUp() {
        contrato = new contratoPorHora(LocalDate.now(), 20.0, 160, LocalDate.now().plusMonths(6));
    }

    @Test
    public void testEstaVigente_ContratoVigente() {
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testEstaVigente_ContratoVencido() {
        contrato = new contratoPorHora(LocalDate.now().minusMonths(6), 20.0, 160, LocalDate.now().minusMonths(1));
        assertFalse(contrato.estaVigente());
    }

    @Test
    public void testEstaVigente_ContratoVencidoHoy() {
        contrato = new contratoPorHora(LocalDate.now().minusMonths(6), 20.0, 160, LocalDate.now());
        assertFalse(contrato.estaVigente());
    }

    @Test
    public void testEstaVigente_ContratoVencidoFuturo() {
        contrato = new contratoPorHora(LocalDate.now().minusMonths(6), 20.0, 160, LocalDate.now().plusMonths(1));
        assertTrue(contrato.estaVigente());
    }
}