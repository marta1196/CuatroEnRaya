package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;

public class CuatroEnRaya {

	private static final int NUMERO_JUGADORES = 2;
	private Jugador[] jugadores;
	private Tablero tablero;

	public CuatroEnRaya(Jugador primerJugador, Jugador segundoJugador) {

		if (primerJugador == null || segundoJugador == null) {

			throw new NullPointerException("ERROR: Ningún jugador puede ser nulo");
		}

		tablero = new Tablero();
		jugadores = new Jugador[NUMERO_JUGADORES];
		jugadores[0] = primerJugador;
		jugadores[1] = segundoJugador;

	}
}
