package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Producto;

public class ProductoTest {

    @Test
    public void testPrecioPositivo() {
        Producto p = new Producto("P003", "Monitor", 80000.0, 5);
        assertTrue(p.getPrecio() > 0, "El precio del producto debe ser positivo");
    }

    @Test
    public void testStockInicialCorrecto() {
        Producto p = new Producto("P004", "Impresora", 120000.0, 8);
        assertEquals(8, p.getStock(), "El stock inicial debe coincidir con el valor del constructor");
    }
}
