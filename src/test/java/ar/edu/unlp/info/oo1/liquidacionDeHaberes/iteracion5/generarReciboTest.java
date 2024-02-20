package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contrato;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;

public class generarReciboTest {

    private nominaEmpresa nominaEmpresa;
    private empleado empleadoConContratoVigente;
    private empleado empleadoSinContratoVigente;
    
    @BeforeEach
    public void setUp() {
        nominaEmpresa = new nominaEmpresa();
        
        // Configuración del empleado con contrato vigente
        empleadoConContratoVigente = new empleado("Juan", "Perez", "123456789", LocalDate.now(), false, false);
        
        // Configuración del empleado sin contrato vigente
        empleadoSinContratoVigente = new empleado("Pedro", "Gomez", "987654321", LocalDate.now(), false, false);
        
        // Agregamos los empleados a la nómina de la empresa
        nominaEmpresa.agregarEmpleado(empleadoConContratoVigente);
        nominaEmpresa.agregarEmpleado(empleadoSinContratoVigente);
    }
    
    @Test
    public void testGenerarRecibos_ContratosVigentes() {
        contrato contratoVigente = new contratoDePlanta(LocalDate.now(), 2000, 100, 50);
        empleadoConContratoVigente.cargarContrato(contratoVigente);
        // Generamos los recibos
        List<recibo> recibosGenerados = nominaEmpresa.generarRecibos();
        
        // Verificación
        assertNotNull(recibosGenerados, "La lista de recibos no debería ser nula");
        assertEquals(1, recibosGenerados.size(), "Debería generarse un recibo para el empleado con contrato vigente");
        assertEquals("Juan", recibosGenerados.get(0).getNombre(), "El nombre en el recibo debería ser 'Juan'");
        assertEquals("Perez", recibosGenerados.get(0).getApellido(), "El apellido en el recibo debería ser 'Perez'");
    }
    
    @Test
    public void testGenerarRecibos_SinContratosVigentes() {
        // Cambiamos la fecha de finalización del contrato por hora para que sea anterior a la fecha actual
        LocalDate fechaFinAnterior = LocalDate.now().minusMonths(1);
        contrato contratoNoVigente = new contratoPorHora(LocalDate.now().minusYears(2), 20, 40, fechaFinAnterior);
        empleadoSinContratoVigente.cargarContrato(contratoNoVigente);
        
        // Generamos los recibos
        List<recibo> recibosGenerados = nominaEmpresa.generarRecibos();
        
        // Verificación
        assertNotNull(recibosGenerados, "La lista de recibos no debería ser nula");
        assertEquals(0, recibosGenerados.size(), "No deberían generarse recibos para empleados sin contrato vigente");
    }
}