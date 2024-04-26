package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.Juego;

public class ComportamientoPaso implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
            jugador.setearMensaje("🚶 "+jugador.obtenerNombre()+"! Estás en un casillero de paso, aqui no pasa nada :)");
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {

    }
}
