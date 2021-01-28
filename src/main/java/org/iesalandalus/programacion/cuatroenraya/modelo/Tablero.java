package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {

	public static final int FILAS = 6;
	public static final int COLUMNAS = 7;
	public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
	private Casilla[][] casillas;

	public Tablero() {

		casillas = new Casilla[FILAS][COLUMNAS];

		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {

				casillas[i][j] = new Casilla();
			}
		}
	}

	public boolean estaVacio() {

		boolean estaVaciaTablero = true;

		for (int j = 0; j < COLUMNAS; j++) {

			if (!columnaVacia(j)) {

				estaVaciaTablero = false;
			}
		}

		return estaVaciaTablero;
	}

	private boolean columnaVacia(int columna) {

		boolean estaVacioColumna = false;

		if (casillas[0][columna].getFicha() == null) {

			estaVacioColumna = true;

		} else {

			estaVacioColumna = false;
		}

		return estaVacioColumna;
	}

	public boolean estaLleno() {

		boolean estaLlenoTablero = true;

		for (int j = 0; j < COLUMNAS; j++) {

			if (!columnaLlena(j)) {

				estaLlenoTablero = false;
			}
		}

		return estaLlenoTablero;
	}

	private boolean columnaLlena(int columna) {

		boolean estaLlenaColumna = false;

		if (casillas[FILAS - 1][columna].getFicha() == null) {

			estaLlenaColumna = false;

		} else {

			estaLlenaColumna = true;
		}

		return estaLlenaColumna;
	}

	private void comprobarFicha(Ficha ficha) {

		if (ficha == null) {
			throw new NullPointerException("ERROR: La ficha no puede ser nula.");
		}
	}

	private void comprobarColumna(int columna) {

		if (columna < 0 || columna >= COLUMNAS) {

			throw new IllegalArgumentException("ERROR: Columna incorrecta.");
		}
	}

	private int getPrimeraFilaVacia(int columna) {

		int casillaVacia = 0;

		for (int i = 0; i < FILAS; i++) {

			if (casillas[i][columna].getFicha() == null) {

				casillaVacia = i;
				break;
			}
		}

		return casillaVacia;
	}
}
