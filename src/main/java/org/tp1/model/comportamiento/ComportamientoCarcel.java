package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroCarcel;
import org.tp1.model.juego.Juego;
import org.tp1.model.juego.estadoJugador.EstadoJugador;

public class ComportamientoCarcel implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        jugador.setMensaje("De visita en la carcel");
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        CasilleroCarcel casilleroCarcel = (CasilleroCarcel) casillero;
        if (jugador.getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            if (comando.equals("1")) {
                juego.pagarMulta(jugador);
            }
            juego.pasarTurnoEnCarcel();
        }
    }
}
