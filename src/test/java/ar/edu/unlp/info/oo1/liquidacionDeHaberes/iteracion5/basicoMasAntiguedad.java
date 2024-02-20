package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.contratoDePlanta;
import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;

public class basicoMasAntiguedad {
    
    private empleado empleado;
    
    @BeforeEach
    public void setUp() {
        // Instanciamos un empleado con fecha de inicio igual a la fecha actual y un contrato de planta
        empleado = new empleado("Juan", "Perez", "123456789", LocalDate.now(), false, false);
        empleado.cargarContrato(new contratoDePlanta(LocalDate.now(), 1000, 200, 100));
    }
    
    @Test
    public void testBasicoMasAntiguedad_AntiguedadMenorQue5Anios() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio un año atrás
        LocalDate fechaInicioUnAnioAtras = LocalDate.now().minusYears(1);
        empleado.cambiarFechaInicio(fechaInicioUnAnioAtras);
        
        assertEquals(1000, empleado.basicoMasAntiguedad(), "El salario básico más la antigüedad debería ser igual al básico sin aumento");
    }
    
    @Test
    public void testBasicoMasAntiguedad_Antiguedad5Anios() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio cinco años atrás
        LocalDate fechaInicioCincoAniosAtras = LocalDate.now().minusYears(5);
        empleado.cambiarFechaInicio(fechaInicioCincoAniosAtras);
        
        assertEquals(1300, empleado.basicoMasAntiguedad(), "El salario básico más la antigüedad debería ser el básico multiplicado por 1.3");
    }
    
    @Test
    public void testBasicoMasAntiguedad_Antiguedad10Anios() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio diez años atrás
        LocalDate fechaInicioDiezAniosAtras = LocalDate.now().minusYears(10);
        empleado.cambiarFechaInicio(fechaInicioDiezAniosAtras);
        
        assertEquals(1500, empleado.basicoMasAntiguedad(), "El salario básico más la antigüedad debería ser el básico multiplicado por 1.5");
    }
    
    @Test
    public void testBasicoMasAntiguedad_Antiguedad15Anios() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio quince años atrás
        LocalDate fechaInicioQuinceAniosAtras = LocalDate.now().minusYears(15);
        empleado.cambiarFechaInicio(fechaInicioQuinceAniosAtras);
        
        assertEquals(1700, empleado.basicoMasAntiguedad(), "El salario básico más la antigüedad debería ser el básico multiplicado por 1.7");
    }
    
    @Test
    public void testBasicoMasAntiguedad_Antiguedad20Anios() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio veinte años atrás
        LocalDate fechaInicioVeinteAniosAtras = LocalDate.now().minusYears(20);
        empleado.cambiarFechaInicio(fechaInicioVeinteAniosAtras);
        
        assertEquals(2000, empleado.basicoMasAntiguedad(), "El salario básico más la antigüedad debería ser el básico multiplicado por 2.0");
    }
}