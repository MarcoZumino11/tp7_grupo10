package ar.edu.unju.escmi.tp7.principal;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.escmi.tp7.collections.CollectionCliente;
import ar.edu.unju.escmi.tp7.collections.CollectionProducto;
import ar.edu.unju.escmi.tp7.collections.CollectionStock;
import ar.edu.unju.escmi.tp7.collections.CollectionTarjetaCredito;
import ar.edu.unju.escmi.tp7.dominio.Cliente;
import ar.edu.unju.escmi.tp7.dominio.Credito;
import ar.edu.unju.escmi.tp7.dominio.Detalle;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;
import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;
import ar.edu.unju.escmi.tp7.collections.CollectionCredito;
import ar.edu.unju.escmi.tp7.collections.CollectionFactura;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Se cargan los datos iniciales para tener ejemplos al iniciar el programa
        CollectionCliente.precargarClientes();
        CollectionTarjetaCredito.precargarTarjetas();
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStocks();

        int opcion = 0;

        do {
            System.out.println("\n====== Menu Principal =====");
            System.out.println("1- Realizar una venta");
            System.out.println("2- Revisar compras realizadas por el cliente (debe ingresar el DNI del cliente)");
            System.out.println("3- Mostrar lista de los electrodomésticos");
            System.out.println("4- Consultar stock");
            System.out.println("5- Revisar créditos de un cliente (debe ingresar el DNI del cliente)");
            System.out.println("6- Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    // Se identifica el cliente antes de realizar la venta
                    System.out.print("Ingrese el DNI del cliente: ");
                    long dniCliente = scanner.nextLong();
                    scanner.nextLine();

                    Cliente cliente = CollectionCliente.buscarCliente(dniCliente);

                    if (cliente == null) {
                        // Si no se encuentra, se da la opción de registrarlo
                        System.out.println("*** Cliente no encontrado, ¿desea registrarlo? (SI/NO) ***");
                        String op = scanner.nextLine();
                        if (op.equalsIgnoreCase("SI")) {

                            System.out.print("Ingrese nombre: ");
                            String nombreCliente = scanner.nextLine();

                            System.out.print("Ingrese dirección: ");
                            String direccionCliente = scanner.nextLine();

                            System.out.print("Ingrese teléfono: ");
                            String telefonoCliente = scanner.nextLine();

                            cliente = new Cliente(dniCliente, nombreCliente, direccionCliente, telefonoCliente);
                            CollectionCliente.agregarCliente(cliente);
                            System.out.println("--- Cliente registrado con éxito, vuelva a intentar la compra ---");
                        } else {
                            System.out.println("*** No se puede continuar con la venta sin un cliente registrado ***");
                        }
                    } else {
                        // Si el cliente existe, comienza la venta
                        LocalDate fecha = LocalDate.now();
                        Factura factura = new Factura(fecha, cliente);

                        double montoMaximoCelular = 0;
                        double montoMaximoElectrodomestico = 0;
                        double montoCompraTotalAhora30 = 0;
                        boolean seguirComprando = true;
                        TarjetaCredito tarjetaCredito = null;

                        while (seguirComprando) {

                            // Se pide el código del producto
                            System.out.print("Ingrese el código del producto: ");
                            int codigoProductoVenta = scanner.nextInt();
                            scanner.nextLine();

                            Producto producto = CollectionProducto.buscarProducto(codigoProductoVenta);

                            if (producto == null) {
                                System.out.println("*** Producto no encontrado ***");
                                continue;
                            }

                            System.out.print("Ingrese la cantidad: ");
                            int cantidadProducto = scanner.nextInt();
                            scanner.nextLine();

                            Stock stock = CollectionStock.buscarStock(producto);

                            // Validar si hay stock suficiente
                            if (!stock.validarStockDisponible(cantidadProducto)) {
                                System.out.println("*** Stock insuficiente. Disponible: " + stock.getCantidad() + " ***");
                            } else {
                                double precioTotal = producto.getPrecioUnitario() * cantidadProducto;
                                LocalDate fechaLimite = LocalDate.of(2025, 12, 22);

                                // Verificar si el producto pertenece al programa Ahora 30
                                if (CollectionProducto.buscarProductoAhora30(codigoProductoVenta)) {
                                    if (fecha.isAfter(fechaLimite)) {
                                        System.out.println("*** El programa 'Ahora 30' ha finalizado ***");
                                    } else {
                                        System.out.println("--- Producto elegible para el programa 'Ahora 30' ---");
                                        System.out.print("Ingrese número de tarjeta de crédito: ");
                                        long numeroTarjeta = scanner.nextLong();
                                        scanner.nextLine();

                                        tarjetaCredito = CollectionTarjetaCredito.buscarTarjetaCredito(numeroTarjeta);

                                        if (tarjetaCredito == null) {
                                            System.out.print("*** Tarjeta no encontrada, ¿Desea agregarla? (SI/NO) ***");
                                            String op = scanner.nextLine();

                                            if (op.equalsIgnoreCase("SI")) {
                                                System.out.print("Ingrese fecha de caducidad (AAAA-MM-DD): ");
                                                String fechaCaducacion = scanner.nextLine();
                                                System.out.print("Ingrese límite de compra: ");
                                                double limiteCompra = scanner.nextDouble();
                                                scanner.nextLine();

                                                tarjetaCredito = new TarjetaCredito(numeroTarjeta, LocalDate.parse(fechaCaducacion), cliente, limiteCompra);
                                                CollectionTarjetaCredito.agregarTarjetaCredito(tarjetaCredito);
                                                System.out.println("--- Tarjeta registrada con éxito, vuelva a intentar la compra ---");
                                            } else {
                                                System.out.println("*** No se puede continuar sin una tarjeta registrada ***");
                                            }
                                        } else {
                                            // Validaciones de tipo de producto y monto permitido
                                            if (producto.getDescripcion().contains("celular")) {
                                                montoMaximoCelular += precioTotal;
                                                if (montoMaximoCelular > 800000) {
                                                    System.out.println("*** Supera el límite de $800000 para celulares ***");
                                                    montoMaximoCelular -= precioTotal;
                                                    continue;
                                                }
                                            } else {
                                                montoMaximoElectrodomestico += precioTotal;
                                                if (montoMaximoElectrodomestico > 1500000) {
                                                    System.out.println("*** Supera el límite de $1500000 para electrodomésticos ***");
                                                    montoMaximoElectrodomestico -= precioTotal;
                                                    continue;
                                                }
                                            }

                                            if (tarjetaCredito.tieneSaldoSuficiente(precioTotal)) {
                                                // Se genera el detalle de la compra
                                                Detalle detalle = new Detalle(cantidadProducto, precioTotal, producto, true);
                                                factura.agregarDetalle(detalle);
                                                tarjetaCredito.descontarMonto(precioTotal);
                                                stock.actualizarStock(cantidadProducto);
                                                System.out.println("--- Compra realizada con éxito ---");
                                                montoCompraTotalAhora30 += precioTotal;
                                            } else {
                                                System.out.println("*** Saldo insuficiente en la tarjeta ***");
                                            }
                                        }
                                    }
                                } else {
                                    // Producto fuera del programa Ahora 30
                                    System.out.print("*** Producto fuera del programa, ¿Desea comprarlo igual? (SI/NO) ***");
                                    String op = scanner.nextLine();
                                    if (op.equalsIgnoreCase("SI")) {
                                        Detalle detalle = new Detalle(cantidadProducto, precioTotal, producto, false);
                                        factura.agregarDetalle(detalle);
                                        stock.actualizarStock(cantidadProducto);
                                        System.out.println("--- Compra realizada con éxito ---");
                                    }
                                }

                                System.out.print("¿Desea agregar otro producto? (s/n): ");
                                String op = scanner.nextLine();
                                seguirComprando = op.equalsIgnoreCase("s");
                            }
                        }

                        // Si hay productos en la factura, se genera la venta
                        if (!factura.getDetalles().isEmpty()) {
                            if (montoCompraTotalAhora30 > 0) {
                                Credito credito = new Credito(tarjetaCredito, factura, cliente, montoCompraTotalAhora30);
                                credito.generarCuotas();
                                CollectionCredito.agregarCredito(credito);
                                System.out.println("--- Crédito generado para los productos Ahora 30 ---");
                            }
                            System.out.println(factura);
                            CollectionFactura.agregarFactura(factura);

                        }
                    }
                    break;
                }

                case 2:
                    System.out.println("Ingrese el DNI del cliente: ");
                    long dniBuscarFactura = scanner.nextLong();

                    CollectionFactura.buscarFacturasPorDni(dniBuscarFactura);
                    break;

                case 3:

                    CollectionProducto.mostrarProductosAhora30();
                    break;

                case 4:

                    System.out.println("\n====== Stock de Productos Ahora 30 ======");
                    CollectionStock.mostrarStockAhora30();
                    break;

                case 5:

                    System.out.println("Ingrese el DNI del cliente a buscar sus créditos: ");
                    long dni = scanner.nextLong();
                    CollectionCredito.buscarCreditoPorDni(dni);
                    break;

                default:
                    break;
            }

        } while (opcion != 6);

        scanner.close();

    }

}
