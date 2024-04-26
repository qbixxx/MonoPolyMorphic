package org.example.model.excepciones;

public class PropiedadNoPerteneceAJugador extends RuntimeException {

    public PropiedadNoPerteneceAJugador() {
        super("Esta propiedad no es del jugador");
    }
}
