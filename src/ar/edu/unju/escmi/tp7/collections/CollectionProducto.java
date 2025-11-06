package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Producto;

public class CollectionProducto {

    public static List<Producto> productos = new ArrayList<>();

    public static void agregarProducto(Producto p) {
        productos.add(p);
    }

    public static Producto buscarProductoPorCodigo(long codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public static void precargarProductos() {
        productos.add(new Producto(1001, "Teclado Logitech", 25000, "China"));
        productos.add(new Producto(1002, "Mouse Redragon", 18000, "Argentina"));
        productos.add(new Producto(1003, "Monitor Samsung 24\"", 180000, "Corea del Sur"));
    }
}
