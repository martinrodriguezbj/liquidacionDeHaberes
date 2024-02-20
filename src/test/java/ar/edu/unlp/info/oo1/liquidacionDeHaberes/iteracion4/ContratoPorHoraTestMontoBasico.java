package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoPorHoraTestMontoBasico {

    private contratoPorHora contrato;

    @BeforeEach
    public void setUp() {
        contrato = new contratoPorHora(LocalDate.now(), 20.0, 160, LocalDate.now().plusMonths(6));
    }

    @Test
    public void testMontoBasico() {
        assertEquals(3200.0, contrato.montoBasico(null));
    }
}