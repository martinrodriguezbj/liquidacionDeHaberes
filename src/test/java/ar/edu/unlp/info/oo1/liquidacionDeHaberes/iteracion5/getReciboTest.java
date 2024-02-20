package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;

public class getReciboTest {

    private empleado empleado;
    
    @BeforeEach
    public void setUp() {
        // Instanciamos un empleado con fecha de inicio igual a la fecha actual
        empleado = new empleado("Juan", "Perez", "123456789", LocalDate.now(), false, false);
    }
    
    @Test
    public void testGetRecibo_ContratoActivoYVigente() {
        // Configuración del contrato vigente
        contrato contratoVigente = new contratoDePlanta(LocalDate.now(), 2000, 100, 50);
        empleado.cargarContrato(contratoVigente);
        
        // Generamos el recibo
        recibo reciboGenerado = empleado.getRecibo();
        
        // Verificación
        assertNotNull(reciboGenerado, "Se debería generar un recibo para un empleado con contrato activo y vigente");
        assertEquals("Juan", reciboGenerado.getNombre(), "El nombre en el recibo debería ser 'Juan'");
        assertEquals("Perez", reciboGenerado.getApellido(), "El apellido en el recibo debería ser 'Perez'");
        assertEquals("123456789", reciboGenerado.getCuil(), "El CUIL en el recibo debería ser '123456789'");
    }
    
    @Test
    public void testGetRecibo_ContratoActivoPeroNoVigente() {
        // Configuración del contrato no vigente
        contrato contratoNoVigente = new contratoPorHora(LocalDate.now().minusYears(1), 20, 40, LocalDate.now().minusMonths(1));
        empleado.cargarContrato(contratoNoVigente);
        
        // Generamos el recibo
        recibo reciboGenerado = empleado.getRecibo();
        
        // Verificación
        assertNull(reciboGenerado, "No se debería generar un recibo para un empleado con contrato activo pero no vigente");
    }
    
    @Test
    public void testGetRecibo_SinContratoActivo() {
        // No se carga ningún contrato
        
        // Generamos el recibo
        recibo reciboGenerado = empleado.getRecibo();
        
        // Verificación
        assertNull(reciboGenerado, "No se debería generar un recibo para un empleado sin contrato activo");
    }
}