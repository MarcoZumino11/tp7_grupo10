package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;

public class StockTest {

    @Test
    public void stockSeActualizaCorrectamente() {
        Producto producto = new Producto(1001, "Mouse", 5000.0, "China");
        Stock stock = new Stock(10, producto);

        stock.actualizarStock(3);

        assertEquals(7, stock.getCantidad(), "El stock debe disminuir correctamente");
    }

    @Test
    public void noPermiteStockNegativo() {
        Producto producto = new Producto(1002, "Teclado", 8000.0, "China");
        Stock stock = new Stock(2, producto);

        stock.actualizarStock(5);

        assertTrue(stock.getCantidad() >= 0, "No debe permitir que el stock sea negativo");
    }
}
