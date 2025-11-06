package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.*;

public class CollectionCliente {

    public static List<Cliente> clientes = new ArrayList<>();

    public static void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public static Cliente buscarClientePorNombre(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                c.mostrarDatos();
                System.out.println("--------------------------------");
            }
        }
    }

    public static void precargarClientes() {
        clientes.add(new ClienteMayorista("Distribuidora Norte", "San Salvador", "30-12345678-9", 0.15));
        clientes.add(new ClienteMinorista("Lautaro Muro", "Palpalá", 45321789, "3887654321"));
        clientes.add(new ClienteMinorista("Lucas Fernández", "San Salvador", 45999888, "3881234567"));
    }
}
