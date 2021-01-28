package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

public class MainApp {

	public static void main(String[] args) {

		Jugador primerJugador = Consola.leerJugador();
		Jugador segundoJugador;

		if (primerJugador.getColorFichas().equals(Ficha.AZUL)) {

			segundoJugador = Consola.leerJugador(Ficha.VERDE);

		} else {

			segundoJugador = Consola.leerJugador(Ficha.AZUL);
		}

		CuatroEnRaya cuatroEnRaya = new CuatroEnRaya(primerJugador, segundoJugador);
		cuatroEnRaya.jugar();
	}
}
