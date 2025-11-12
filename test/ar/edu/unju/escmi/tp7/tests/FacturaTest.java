package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.Detalle;
import ar.edu.unju.escmi.tp7.dominio.Producto;

public class FacturaTest {

    @Test
    public void testCalculoTotalFactura() {
        Factura factura = new Factura();
        Producto p1 = new Producto("P005", "Notebook", 500000.0, 10);
        Producto p2 = new Producto("P006", "Auriculares", 30000.0, 10);

        factura.agregarDetalle(new Detalle(p1, 1));
        factura.agregarDetalle(new Detalle(p2, 2));

        double esperado = 500000.0 + (30000.0 * 2);
        assertEquals(esperado, factura.getTotal(), 0.01, "El total de la factura debe ser la suma de los detalles");
    }

    @Test
    public void testFacturaSinDetallesEsCero() {
        Factura factura = new Factura();
        assertEquals(0, factura.getTotal(), 0.01, "Una factura sin detalles debe tener total 0");
    }
}
