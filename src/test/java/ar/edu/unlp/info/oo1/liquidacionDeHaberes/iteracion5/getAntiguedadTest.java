package ar.edu.unlp.info.oo1.liquidacionDeHaberes.iteracion5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.liquidacionDeHaberes.empleado;

public class getAntiguedadTest {
    
    private empleado empleado;
    
    @BeforeEach
    public void setUp() {
        // Instanciamos un empleado con fecha de inicio igual a la fecha actual
        empleado = new empleado("Juan", "Perez", "123456789", LocalDate.now(), false, false);
    }
    
    @Test
    public void testGetAntiguedad_ContratoVigenteUnAno() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio un año atrás
        LocalDate fechaInicioUnAnoAtras = LocalDate.now().minusYears(1);
        empleado.cambiarFechaInicio(fechaInicioUnAnoAtras);
        
        assertEquals(1, empleado.getAntiguedad(), "La antigüedad debería ser de 1 año");
    }
    
    @Test
    public void testGetAntiguedad_ContratoVigenteDiezAnos() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio diez años atrás
        LocalDate fechaInicioDiezAnosAtras = LocalDate.now().minusYears(10);
        empleado.cambiarFechaInicio(fechaInicioDiezAnosAtras);
        
        assertEquals(10, empleado.getAntiguedad(), "La antigüedad debería ser de 10 años");
    }
    
    @Test
    public void testGetAntiguedad_ContratoVigenteVeinteAnos() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio veinte años atrás
        LocalDate fechaInicioVeinteAnosAtras = LocalDate.now().minusYears(20);
        empleado.cambiarFechaInicio(fechaInicioVeinteAnosAtras);
        
        assertEquals(20, empleado.getAntiguedad(), "La antigüedad debería ser de 20 años");
    }
    
    @Test
    public void testGetAntiguedad_ContratoVigenteVeinticincoAnos() {
        // Empleamos el método cambiarFechaInicio para establecer la fecha de inicio veinticinco años atrás
        LocalDate fechaInicioVeinticincoAnosAtras = LocalDate.now().minusYears(25);
        empleado.cambiarFechaInicio(fechaInicioVeinticincoAnosAtras);
        
        assertEquals(25, empleado.getAntiguedad(), "La antigüedad debería ser de 25 años");
    }
}