package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoPorHora;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.nominaEmpresa;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.recibo;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5.*;

public class LiquidacionDeHaberesTest {

    @Test
    public void testAgregarEmpleado() {
        nominaEmpresa nomina = new nominaEmpresa();
        empleado emp = nomina.agregarEmpleado("Juan", "Perez", "123456789", 
        		LocalDate.of(1990, 5, 15), false, true);
        assertEquals("Juan", emp.getNombre());
        assertEquals("Perez", emp.getApellido());
        assertEquals("123456789", emp.getCuil());
    }

    @Test
    public void testBuscarEmpleadoExistente() {
        nominaEmpresa nomina = new nominaEmpresa();
        empleado emp = nomina.agregarEmpleado("Juan", "Perez", "123456789",
        		LocalDate.of(1990, 5, 15), false, true);
        empleado encontrado = nomina.buscarEmpleado("123456789");
        assertEquals(emp, encontrado);
    }

    @Test
    public void testBuscarEmpleadoNoExistente() {
        nominaEmpresa nomina = new nominaEmpresa();
        empleado encontrado = nomina.buscarEmpleado("123456789");
        assertNull(encontrado);
    }

    @Test
    public void testBajaEmpleado() {
        nominaEmpresa nomina = new nominaEmpresa();
        empleado emp = nomina.agregarEmpleado("Juan", "Perez", "123456789", 
        		LocalDate.of(1990, 5, 15), false, true);
        nomina.bajaEmpleado(emp);
        assertTrue(nomina.getEmpleados().isEmpty());
    }

    @Test
    public void testEmpleadosConContratosVencidos() {
        nominaEmpresa nomina = new nominaEmpresa();
        empleado emp1 = nomina.agregarEmpleado("Juan", "Perez", "123456789", 
        		LocalDate.of(1990, 5, 15), false, true);
        empleado emp2 = nomina.agregarEmpleado("Maria", "Gomez", "987654321", 
        		LocalDate.of(1995, 3, 20), true, false);

        contratoPorHora contrato1 = new contratoPorHora(LocalDate.of(2023, 1, 1), 
        		10, 160, LocalDate.of(2023, 12, 31));
        emp1.cargarContrato(contrato1);

        contratoDePlanta contrato2 = new contratoDePlanta(LocalDate.of(2020, 6, 1), 
        		50000, 2000, 1000);
        emp2.cargarContrato(contrato2);

        List<empleado> empleadosVencidos = nomina.empleadosConContratosVencidos();
        assertEquals(1, empleadosVencidos.size());
        assertEquals(emp1, empleadosVencidos.get(0));
    }

    @Test
    public void testGenerarRecibos() {
        nominaEmpresa nomina = new nominaEmpresa();
        empleado emp1 = nomina.agregarEmpleado("Juan", "Perez", "123456789", 
        		LocalDate.of(1990, 5, 15), false, true);
        empleado emp2 = nomina.agregarEmpleado("Maria", "Gomez", "987654321", 
        		LocalDate.of(1995, 3, 20), true, false);

        contratoPorHora contrato1 = new contratoPorHora(LocalDate.of(2023, 1, 1), 
        		10, 160, LocalDate.of(2023, 12, 31));
        emp1.cargarContrato(contrato1);

        contratoDePlanta contrato2 = new contratoDePlanta(LocalDate.of(2020, 6, 1),
        		50000, 2000, 1000);
        emp2.cargarContrato(contrato2);

        List<recibo> recibos = nomina.generarRecibos();
        assertEquals(1, recibos.size());
    }
}