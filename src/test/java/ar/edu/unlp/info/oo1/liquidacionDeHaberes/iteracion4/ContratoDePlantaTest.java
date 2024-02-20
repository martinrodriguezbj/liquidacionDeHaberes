package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoDePlantaTest {

    private contratoDePlanta contrato;

    @BeforeEach
    public void setUp() {
        contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
    }

    @Test
    public void testEstaVigente_ContratoVigente() {
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testEstaVigente_ContratoVencido() {
        contrato = new contratoDePlanta(LocalDate.now().minusYears(2), 5000.0, 200.0, 100.0);
        assertTrue(contrato.estaVigente());
    }

    @Test
    public void testEstaVigente_ContratoVencidoHaceMasDe20Anios() {
        contrato = new contratoDePlanta(LocalDate.now().minusYears(21), 5000.0, 200.0, 100.0);
        assertTrue(contrato.estaVigente());
    }
}