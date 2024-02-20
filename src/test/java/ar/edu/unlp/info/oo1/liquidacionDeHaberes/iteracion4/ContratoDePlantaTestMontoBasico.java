package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class ContratoDePlantaTestMontoBasico{

    private contratoDePlanta contrato;
    private empleado empleadoSinConyugeSinHijos;
    private empleado empleadoConConyugeSinHijos;
    private empleado empleadoSinConyugeConHijos;
    private empleado empleadoConConyugeConHijos;

    @BeforeEach
    public void setUp() {
        contrato = new contratoDePlanta(LocalDate.now(), 5000.0, 200.0, 100.0);
        empleadoSinConyugeSinHijos = new empleado("Nombre", "Apellido", "123456789", LocalDate.now(), false, false);
        empleadoConConyugeSinHijos = new empleado("Nombre", "Apellido", "123456789", LocalDate.now(), true, false);
        empleadoSinConyugeConHijos = new empleado("Nombre", "Apellido", "123456789", LocalDate.now(), false, true);
        empleadoConConyugeConHijos = new empleado("Nombre", "Apellido", "123456789", LocalDate.now(), true, true);
    }

    @Test
    public void testMontoBasico_EmpleadoSinConyugeSinHijos() {
        assertEquals(5000.0, contrato.montoBasico(empleadoSinConyugeSinHijos));
    }

    @Test
    public void testMontoBasico_EmpleadoConConyugeSinHijos() {
        assertEquals(5200.0, contrato.montoBasico(empleadoConConyugeSinHijos));
    }

    @Test
    public void testMontoBasico_EmpleadoSinConyugeConHijos() {
        assertEquals(5100.0, contrato.montoBasico(empleadoSinConyugeConHijos));
    }

    @Test
    public void testMontoBasico_EmpleadoConConyugeConHijos() {
        assertEquals(5300.0, contrato.montoBasico(empleadoConConyugeConHijos));
    }
}