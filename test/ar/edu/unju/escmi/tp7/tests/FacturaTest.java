package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import ar.edu.unju.escmi.tp7.dominio.*;

public class FacturaTest {

    @Test
    public void testCalculoTotalFactura() {
        Cliente c = new Cliente(45111222, "Mario", "Alvear 120", "65454686");
        Factura factura = new Factura(LocalDate.now(), c);

        Producto p1 = new Producto(1001, "Notebook", 500000.0, "China");
        Producto p2 = new Producto(1002, "Auriculares", 30000.0, "Argentina");

        Detalle d1 = new Detalle(1, 500000.0, p1, false);
        Detalle d2 = new Detalle(2, 60000.0, p2, false);

        factura.agregarDetalle(d1);
        factura.agregarDetalle(d2);

        double esperado = 500000.0 + 60000.0;
        assertEquals(esperado, factura.calcularTotal(), 0.01, "El total de la factura debe ser la suma de los detalles");
    }

    @Test
    public void testFacturaSinDetallesEsCero() {
        Cliente c = new Cliente(12345678, "Juan", "Belgrano 100", "38845123");
        Factura factura = new Factura(LocalDate.now(), c);

        assertEquals(0, factura.calcularTotal(), 0.01, "Una factura sin detalles debe tener total 0");
    }
}

