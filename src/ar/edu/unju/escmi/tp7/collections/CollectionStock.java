package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;

public class CollectionStock {

    // Lista estática que almacena todos los objetos de tipo Stock
    public static List<Stock> stocks = new ArrayList<Stock>();

    // Método para precargar una lista inicial de stocks
    public static void precargarStocks() {
        if (stocks.isEmpty()) {
            stocks = new ArrayList<Stock>();
            // Se vincula cada stock con un producto existente en CollectionProducto
            stocks.add(new Stock(12, CollectionProducto.productos.get(0)));
            stocks.add(new Stock(22, CollectionProducto.productos.get(1)));
            stocks.add(new Stock(13, CollectionProducto.productos.get(2)));
            stocks.add(new Stock(101, CollectionProducto.productos.get(3)));
            stocks.add(new Stock(87, CollectionProducto.productos.get(4)));
            stocks.add(new Stock(45, CollectionProducto.productos.get(5)));
            stocks.add(new Stock(16, CollectionProducto.productos.get(6)));
            stocks.add(new Stock(8, CollectionProducto.productos.get(7)));
            stocks.add(new Stock(5, CollectionProducto.productos.get(8)));
            stocks.add(new Stock(21, CollectionProducto.productos.get(9)));
            stocks.add(new Stock(17, CollectionProducto.productos.get(10)));
            stocks.add(new Stock(11, CollectionProducto.productos.get(11)));
            stocks.add(new Stock(8, CollectionProducto.productos.get(12)));
            stocks.add(new Stock(14, CollectionProducto.productos.get(13)));
            stocks.add(new Stock(4, CollectionProducto.productos.get(14)));
            stocks.add(new Stock(15, CollectionProducto.productos.get(15)));
            stocks.add(new Stock(28, CollectionProducto.productos.get(16)));
            stocks.add(new Stock(47, CollectionProducto.productos.get(17)));
            stocks.add(new Stock(33, CollectionProducto.productos.get(18)));
            stocks.add(new Stock(13, CollectionProducto.productos.get(19)));
        }
    }

    // Método para agregar o actualizar un stock existente
    public static void agregarStock(Stock stock) {
        try {
            if (stocks.isEmpty()) {
                // Si la lista está vacía, simplemente agrega el stock
                stocks.add(stock);
            } else {
                Producto controlProducto = stock.getProducto();
                boolean band = true;
                int i = 0;

                // Recorremos la lista buscando si ya existe un stock del mismo producto
                for (Stock sto : stocks) {
                    if (band) {
                        if (controlProducto == sto.getProducto()) {
                            // Si el producto ya existe, actualizamos su posición
                            stocks.set(i, stock);
                            band = false;
                        }
                    }
                    i++;
                }

                // Si no se encontró el producto, se agrega como nuevo
                if (band) {
                    stocks.add(stock);
                }
            }
        } catch (Exception e) {
            System.out.println("\nNO SE PUEDE GUARDAR EL STOCK");
        }
    }

    // Método para reducir la cantidad de unidades de un stock específico
    public static void reducirStock(Stock stock, int cantidad) {
        int i = stocks.indexOf(stock);
        if (i >= 0) {
            if (stock.getCantidad() - cantidad >= 0) {
                // Resta la cantidad vendida del stock disponible
                stock.setCantidad(stock.getCantidad() - cantidad);
                stocks.set(i, stock);
            }
        } else {
            System.out.println("\nERROR");
        }
    }

    // Busca un stock según el producto
    public static Stock buscarStock(Producto producto) {
        Stock stockTotal = null;

        try {
            if (stocks != null) {
                for (Stock sto : stocks) {
                    // Compara por código de producto
                    if (sto.getProducto().getCodigo() == producto.getCodigo()) {
                        stockTotal = sto;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return stockTotal;
    }

    // Muestra el stock de los productos que califican para el plan Ahora 30
    public static void mostrarStockAhora30() {
        mostrarStockAhora30(CollectionProducto.obtenerProductosAhora30());
    }

    // Muestra el stock solo de los productos incluidos en el plan Ahora 30
    public static void mostrarStockAhora30(List<Producto> productosAhora30) {
        System.out.println("Productos que califican para el plan:\n");
        boolean hayProductos = false;

        if (stocks != null && productosAhora30 != null) {
            // Recorre la lista de productos del plan y muestra su stock
            for (Producto producto : productosAhora30) {
                Stock stock = buscarStock(producto);
                if (stock != null) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println(producto);
                    System.out.println("Stock disponible: " + stock.getCantidad() + " unidades");
                    hayProductos = true;
                }
            }
        }

        // Si no hay productos disponibles, se informa al usuario
        if (!hayProductos) {
            System.out.println("No hay stock disponible para productos del plan Ahora 30.");
        }

        System.out.println("-----------------------------------------------------------");
    }
}
