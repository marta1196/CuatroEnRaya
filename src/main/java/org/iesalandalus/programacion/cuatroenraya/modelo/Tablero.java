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

	private boolean objetivoAlcanzado(int fichasConsecutivas) {

		boolean haGanado = false;

		if (fichasConsecutivas == FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS) {

			haGanado = true;
		}

		return haGanado;
	}

	private boolean comprobarHorizontal(int fila, Ficha ficha) {

		int fichasConsecutivas = 0;
		boolean haGanado = false;

		for (int j = 0; j < COLUMNAS; j++) {

			if (casillas[fila][j].estaOcupada() && casillas[fila][j].getFicha().equals(ficha)) {

				fichasConsecutivas++;
			} else {

				fichasConsecutivas = 0;
			}
			if (objetivoAlcanzado(fichasConsecutivas)) {

				haGanado = true;
			}
		}

		return haGanado;
	}

	private boolean comprobarVertical(int columna, Ficha ficha) {

		int fichasConsecutivas = 0;
		boolean haGanado = false;

		for (int i = 0; i < FILAS; i++) {

			if (casillas[i][columna].estaOcupada() && casillas[i][columna].getFicha().equals(ficha)) {

				fichasConsecutivas++;
				
			} else {

				fichasConsecutivas = 0;
			}
			if (objetivoAlcanzado(fichasConsecutivas)) {

				haGanado = true;
			}
		}

		return haGanado;
	}

	private boolean comprobarDiagonalNE(int fila, int columna, Ficha ficha) {

		int desplazamientoInicial = menor(fila, columna);
		int fichasConsecutivas = 0;
		int filaInicial = fila - desplazamientoInicial;
		int columnaInicial = columna - desplazamientoInicial;
		boolean haGanado = false;

		for (int i = filaInicial, j = columnaInicial; i < FILAS && j < COLUMNAS; i++, j++) {

			if (casillas[i][j].estaOcupada() && casillas[i][j].getFicha().equals(ficha)) {

				fichasConsecutivas++;
				
			} else {

				fichasConsecutivas = 0;
			}
			
			if (objetivoAlcanzado(fichasConsecutivas)) {

				haGanado = true;
			}
		}

		return haGanado;
	}

	private boolean comrpobarDiagonalNO(int fila, int columna, Ficha ficha) {

		int desplazamientoInicial = menor(fila, COLUMNAS - 1 - columna);
		int fichasConsecutivas = 0;
		int filaInicial = fila - desplazamientoInicial;
		int columnaInicial = columna + desplazamientoInicial;
		boolean haGanado = false;

		for (int i = filaInicial, j = columnaInicial; i < FILAS && j >= 0; i++, j--) {

			if (casillas[i][j].estaOcupada() && casillas[i][j].getFicha().equals(ficha)) {

				fichasConsecutivas++;

			} else {

				fichasConsecutivas = 0;
			}

			if (objetivoAlcanzado(fichasConsecutivas)) {

				haGanado = true;
			}
		}
		
		return haGanado;
	}

	private int menor(int numeroUno, int numeroDos) {

		int numeroMenor;

		if (numeroUno >= numeroDos) {

			numeroMenor = numeroDos;

		} else {

			numeroMenor = numeroUno;
		}

		return numeroMenor;
	}
}
