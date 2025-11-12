package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Cliente;

public class CollectionCliente {

    // Lista donde se van a guardar todos los clientes
	public static List<Cliente> clientes = new ArrayList<Cliente>();

    // Método que precarga algunos clientes de ejemplo
    public static void precargarClientes() {
        if (clientes.isEmpty()) {
            clientes.add(new Cliente(45111222, "Mario Barca", "Alvear 120", "65454686"));
            clientes.add(new Cliente(36888666, "Juan Perez", "Av. Belgrano 300", "35185695"));
            clientes.add(new Cliente(25777555, "Ana Juarez", "Islas Malvinas 731", "38845224"));
        }
    }

    // Método para agregar un nuevo cliente a la lista
    public static void agregarCliente(Cliente cliente) {
    	try {
    		clientes.add(cliente);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR EL CLIENTE");
		}
    }

    // Busca un cliente por su DNI y lo devuelve si lo encuentra
    public static Cliente buscarCliente(long dni) {
        Cliente clienteEncontrado = null;

        try {
        	for (Cliente cli : clientes) {
                if (cli.getDni() == dni) {
                    clienteEncontrado = cli;
                }
            }
		} catch (Exception e) {
			return null;
		}
        
        return clienteEncontrado;
    }
}
