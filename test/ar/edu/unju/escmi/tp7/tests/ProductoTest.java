package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Producto;

public class ProductoTest {

    @Test
    public void testPrecioPositivo() {
        Producto p = new Producto(1001, "Monitor", 80000.0, "Argentina");
        assertTrue(p.getPrecioUnitario() > 0, "El precio del producto debe ser positivo");
    }

    @Test
    public void testSetAndGetStock() {
        Producto p = new Producto(1002, "Impresora", 120000.0, "Brasil");
        p.setPrecioUnitario(150000.0);
        assertEquals(150000.0, p.getPrecioUnitario(), "El precio unitario debe actualizarse correctamente");
    }
}
