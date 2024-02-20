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

public class empleadosConContratosVencidosTest {

    private nominaEmpresa nominaEmpresa;
    private empleado empleadoConContratoVencido;
    private empleado empleadoSinContratoVencido;
    
    @BeforeEach
    public void setUp() {
        nominaEmpresa = new nominaEmpresa();
        
        // Configuración del empleado con contrato vencido
        empleadoConContratoVencido = new empleado("Juan", "Perez", "123456789", LocalDate.now(), false, false);
        contrato contratoVencido = new contratoPorHora(LocalDate.now().minusYears(1), 20, 40, LocalDate.now().minusMonths(1));
        empleadoConContratoVencido.cargarContrato(contratoVencido);
        
        // Configuración del empleado sin contrato vencido
        empleadoSinContratoVencido = new empleado("Pedro", "Gomez", "987654321", LocalDate.now(), false, false);
        contrato contratoVigente = new contratoDePlanta(LocalDate.now(), 2000, 100, 50);
        empleadoSinContratoVencido.cargarContrato(contratoVigente);
        
        // Agregamos los empleados a la nómina de la empresa
        nominaEmpresa.agregarEmpleado(empleadoConContratoVencido);
        nominaEmpresa.agregarEmpleado(empleadoSinContratoVencido);
    }
    
    @Test
    public void testEmpleadosConContratosVencidos() {
        // Obtenemos la lista de empleados con contratos vencidos
        List<empleado> empleadosVencidos = nominaEmpresa.empleadosConContratosVencidos();
        
        // Verificación
        assertNotNull(empleadosVencidos, "La lista de empleados con contratos vencidos no debería ser nula");
        assertEquals(1, empleadosVencidos.size(), "Debería haber un empleado con contrato vencido");
        assertEquals("Juan", empleadosVencidos.get(0).getNombre(), "El nombre del empleado con contrato vencido debería ser 'Juan'");
    }
    
    @Test
    public void testEmpleadosConContratosVencidos_ContratosVigentes() {
        // Cambiamos la fecha de finalización del contrato por hora para que sea posterior a la fecha actual
        LocalDate fechaFinFutura = LocalDate.now().plusMonths(1);
        contrato contratoVigente = new contratoPorHora(LocalDate.now(), 20, 40, fechaFinFutura);
        empleadoConContratoVencido.cargarContrato(contratoVigente);
        
        // Obtenemos la lista de empleados con contratos vencidos
        List<empleado> empleadosVencidos = nominaEmpresa.empleadosConContratosVencidos();
        
        // Verificación
        assertNotNull(empleadosVencidos, "La lista de empleados con contratos vencidos no debería ser nula");
        assertEquals(1, empleadosVencidos.size(), "Debería haber un empleado con contrato vencido");
        assertEquals("Juan", empleadosVencidos.get(0).getNombre(), "El nombre del empleado con contrato vencido debería ser 'Juan'");
    }
}