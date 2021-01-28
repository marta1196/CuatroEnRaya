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
}
