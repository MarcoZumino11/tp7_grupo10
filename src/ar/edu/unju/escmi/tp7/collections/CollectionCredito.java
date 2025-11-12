package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Credito;

public class CollectionCredito {

    // Lista donde se guardan todos los créditos creados
	public static List<Credito> creditos = new ArrayList<Credito>();

    // Agrega un crédito a la lista
	public static void agregarCredito(Credito credito) {
		try {
			creditos.add(credito);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR EL CREDITO");
		}
	}

    // Busca créditos asociados a un cliente por su DNI
	public static void buscarCreditoPorDni(long dni) {

		System.out.println("=================================================");
		System.out.println("BUSCANDO CRÉDITOS PARA DNI: " + dni);
		System.out.println("=================================================");

		boolean encontrado = false; // sirve para saber si se encontró o no

		try {
			if (creditos != null && !creditos.isEmpty()) { // chequea que la lista no esté vacía

				for (Credito credito : creditos) {

					try {
						// si el cliente no es nulo y el dni coincide, mostramos el crédito
						if (credito.getCliente() != null && credito.getCliente().getDni() == dni) {
							System.out.println("\n--- Crédito Encontrado ---");
							credito.mostarCredito();
							encontrado = true;
						}
					} catch (NullPointerException e) {
						System.out.println("ERROR: Se encontró un crédito sin cliente. Se salta y sigue buscando.");
					}
				}
			}

			if (!encontrado) {
				System.out.println("No se encontraron créditos asociados al DNI " + dni + ".");
			}

		} catch (Exception e) {
			
			System.out.println("ERROR durante la búsqueda de créditos: " + e.getMessage());
		}
	}
}