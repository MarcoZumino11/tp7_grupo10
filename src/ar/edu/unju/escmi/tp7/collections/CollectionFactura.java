package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.*;

public class CollectionFactura {

    public static List<Factura> facturas = new ArrayList<>();

    public static void agregarFactura(Factura f) {
        facturas.add(f);
    }

    public static Factura buscarFacturaPorNumero(int numero) {
        for (Factura f : facturas) {
            if (f.getNumero() == numero) {
                return f;
            }
        }
        return null;
    }

    public static void mostrarFacturas() {
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas registradas.");
        } else {
            for (Factura f : facturas) {
                f.mostrarFactura();
            }
        }
    }

    public static void precargarFacturas() {
        if (CollectionCliente.clientes.isEmpty() || CollectionProducto.productos.isEmpty()) {
            System.out.println("No hay clientes o productos para generar facturas.");
            return;
        }

        Cliente cliente = CollectionCliente.clientes.get(0);
        Factura factura = new Factura(1, cliente);

        Producto p = CollectionProducto.productos.get(0);
        Detalle d = new Detalle(p, 2);

        factura.agregarDetalle(d);
        facturas.add(factura);
    }
}
