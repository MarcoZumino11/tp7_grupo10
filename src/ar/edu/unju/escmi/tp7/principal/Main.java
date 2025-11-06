package ar.edu.unju.escmi.tp7.principal;

import java.util.Scanner;
import ar.edu.unju.escmi.tp7.collections.*;
import ar.edu.unju.escmi.tp7.dominio.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        precargarDatos();
        menuPrincipal();
    }

    private static void precargarDatos() {
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStock();
        CollectionCliente.precargarClientes();
        CollectionFactura.precargarFacturas();
    }

    private static void menuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE VENTAS ===");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar venta");
            System.out.println("4. Ver facturas");
            System.out.println("5. Salir");
            System.out.print("Elegir opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    CollectionProducto.mostrarProductos();
                    break;
                case 2:
                    CollectionCliente.mostrarClientes();
                    break;
                case 3:
                    registrarVenta();
                    break;
                case 4:
                    CollectionFactura.mostrarFacturas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void registrarVenta() {
        System.out.println("\n=== REGISTRAR NUEVA VENTA ===");

        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        Cliente cliente = CollectionCliente.buscarClientePorNombre(nombre);

        if (cliente == null) {
            System.out.println("Cliente no encontrado. Venta cancelada.");
            return;
        }

        Factura factura = new Factura(CollectionFactura.facturas.size() + 1, cliente);

        boolean seguir = true;
        while (seguir) {
            System.out.print("Código del producto: ");
            long codigo = Long.parseLong(sc.nextLine());
            Producto producto = CollectionProducto.buscarProductoPorCodigo(codigo);

            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            Stock s = CollectionStock.buscarStockPorCodigo(codigo);
            if (s == null || !s.hayStockSuficiente(cantidad)) {
                System.out.println("Stock insuficiente.");
                continue;
            }

            s.actualizarStock(-cantidad);
            Detalle detalle = new Detalle(producto, cantidad);
            factura.agregarDetalle(detalle);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            seguir = sc.nextLine().equalsIgnoreCase("s");
        }

        CollectionFactura.agregarFactura(factura);
        System.out.println("Venta registrada exitosamente. Factura N° " + factura.getNumero());
        factura.mostrarFactura();
    }
}
