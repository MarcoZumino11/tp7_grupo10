package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.*;

public class CollectionStock {

    public static List<Stock> listaStock = new ArrayList<>();

    public static void agregarStock(Stock s) {
        listaStock.add(s);
    }

    public static Stock buscarStockPorCodigo(long codigo) {
        for (Stock s : listaStock) {
            if (s.getProducto().getCodigo() == codigo) {
                return s;
            }
        }
        return null;
    }

    public static boolean verificarStock(long codigo, int cantidad) {
        Stock s = buscarStockPorCodigo(codigo);
        return s != null && s.hayStockSuficiente(cantidad);
    }

    public static void precargarStock() {
        for (Producto p : CollectionProducto.productos) {
            listaStock.add(new Stock(p, 50)); // stock inicial de 50 unidades por producto
        }
    }
}
