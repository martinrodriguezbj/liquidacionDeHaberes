package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoPorHoraTest {
    private contratoPorHora contrato;

    @BeforeEach
    public void setUp() {
        LocalDate fechaInicio = LocalDate.now();
        double valorPorHora = 50.0;
        double cantHorasPorMes = 100.0;
        LocalDate fechaFin = LocalDate.now().plusMonths(6); // Contrato vence en 6 meses
        contrato = new contratoPorHora(fechaInicio, valorPorHora, cantHorasPorMes, fechaFin);
    }

    @Test
    public void testEstaVigente_ContratoVigente() {
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testEstaVigente_ContratoVencido() {
        LocalDate fechaFin = LocalDate.now().minusMonths(1); // Contrato venció hace 1 mes
        contrato = new contratoPorHora(LocalDate.now(), 50.0, 100.0, fechaFin);
        assertFalse(contrato.estaVigente());
    }

    @Test
    public void testMontoBasico() {
        assertEquals(5000.0, contrato.montoBasico(null)); 
        // No se necesita un objeto Empleado para calcular el monto
    }

    @Test
    public void testGetValorPorHora() {
        assertEquals(50.0, contrato.getValorPorHora());
    }

    @Test
    public void testGetCantHorasPorMes() {
        assertEquals(100.0, contrato.getCantHorasPorMes());
    }

    @Test
    public void testGetFechaFin() {
        LocalDate fechaFin = LocalDate.now().plusMonths(6);
        assertEquals(fechaFin, contrato.getFechaFin());
    }
}