package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;

public class Casilla {

	private Ficha ficha;

	public boolean estaOcupada() {

		boolean estaOcupadaCasilla = true;

		if (ficha == null) {

			estaOcupadaCasilla = false;

		} else {
			estaOcupadaCasilla = true;
		}

		return estaOcupadaCasilla;
	}
}
