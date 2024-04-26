package example.model.excepciones;

public class PropiadNoPerteneceAJugador extends RuntimeException {

    public PropiadNoPerteneceAJugador() {
        super("Esta propiedad no es del jugador");
    }
}
