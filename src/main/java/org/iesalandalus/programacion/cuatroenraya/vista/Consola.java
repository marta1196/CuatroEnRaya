package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {

	}

	public static String leerNombre() {

		String nombre;

		do {

			System.out.print("Introduce el nombre del jugador: ");
			nombre = Entrada.cadena();

		} while (nombre == null || nombre == "");

		return nombre;
	}
}
