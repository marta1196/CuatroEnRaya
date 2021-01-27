package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;

public class Casilla {

	private Ficha ficha;

	public Casilla() {

		this.ficha = null;
	}

	public Ficha getFicha() {

		return ficha;
	}

	public void setFicha(Ficha ficha) throws OperationNotSupportedException {

		if (ficha == null) {

			throw new NullPointerException("ERROR: No se puede poner una ficha nula.");

		} else if (estaOcupada()) {

			throw new OperationNotSupportedException("ERROR: Ya contengo una ficha.");
		}
		this.ficha = ficha;
	}

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
