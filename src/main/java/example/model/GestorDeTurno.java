package example.model;

import org.example.model.jugador.Jugador;

import java.util.Collections;
import java.util.List;

public class GestorDeTurno {
    private int posicionJugadorDeTurno;
    private final List<Jugador> ordenJugadores;

    public GestorDeTurno(List<Jugador> jugadores) {
        this.posicionJugadorDeTurno = 0;
        this.ordenJugadores = jugadores;
        Collections.shuffle(ordenJugadores);
    }

    public Jugador turnoDe() {
        return ordenJugadores.get(posicionJugadorDeTurno++ % ordenJugadores.size());
    }

    public void eliminarJugador(Jugador jugador) {
        this.ordenJugadores.remove(jugador);
        this.posicionJugadorDeTurno--;
    }
}
