package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;

public class StockTest {

    @Test
    public void stockSeDecrementaCorrectamente() {
        Producto producto = new Producto("P001", "Mouse", 5000.0, 10);
        Stock stock = new Stock(producto, 10);

        stock.decrementarStock(3);

        assertEquals(7, stock.getCantidad(), "El stock debe disminuir correctamente");
    }

    @Test
    public void noPermiteStockNegativo() {
        Producto producto = new Producto("P002", "Teclado", 8000.0, 2);
        Stock stock = new Stock(producto, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            stock.decrementarStock(5);
        }, "No debe permitir que el stock sea negativo");
    }
}
