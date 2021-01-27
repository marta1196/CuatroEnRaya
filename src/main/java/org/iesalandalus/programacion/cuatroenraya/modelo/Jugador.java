package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Jugador {

	private Ficha colorFichas;
	private String nombre;

	public Ficha getColorFichas() {
		return colorFichas;
	}

	private void setColorFichas(Ficha colorFichas) {

		if (colorFichas == null) {

			throw new NullPointerException("ERROR: El color de las fichas no puede ser nulo.");
		}
		this.colorFichas = colorFichas;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {

		if (nombre == null) {

			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");

		} else if (nombre.trim().equals("")) {

			throw new IllegalArgumentException("ERROR: El nombre no puede estar vacío.");
		}
		this.nombre = nombre;
	}
}
