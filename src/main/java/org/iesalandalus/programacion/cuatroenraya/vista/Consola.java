package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
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
	
	public static Ficha elegirColorFichas() {

		Ficha colorFicha = null;
		int opcionColor = -1;

		do {

			System.out.print("Elige el color de tus fichas (0-AZUL, 1-VERDE): ");
			opcionColor = Entrada.entero();

			switch (opcionColor) {

			case 0:

				colorFicha = colorFicha.AZUL;
				break;

			case 1:

				colorFicha = colorFicha.VERDE;
				break;

			default:

				System.out.println("Lo siento pero esa opción no esta permitida");
				break;
			}

		} while (opcionColor != 0 && opcionColor != 1);

		return colorFicha;
	}
}
