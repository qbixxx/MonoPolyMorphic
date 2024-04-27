package org.example.model;

import org.example.model.casilla.Carcel;
import org.example.model.casilla.Casilla;
import org.example.model.jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tablero {

    private List<Casilla> camino;
    private Banco banco;
    private final Map<Jugador, Integer> posicionEnCasilla;

    public Tablero(List<Casilla> casillas, List<Jugador> jugadores, Banco banco) {
        this.camino = new ArrayList<>(casillas);
        this.banco = banco;
        this.posicionEnCasilla = new HashMap<>();
        for (Jugador jugador : jugadores) {
            this.posicionEnCasilla.put(jugador, 0);
        }
    }

    public void mover(Jugador jugador, int cantidadDeCasillas) {
        if (cantidadDeCasillas != 0) {
            int posicionActual = this.posicionEnCasilla.get(jugador);
            int nuevaUbicacion = (posicionActual + cantidadDeCasillas) % this.camino.size();
            this.posicionEnCasilla.put(jugador, nuevaUbicacion);
            if (nuevaUbicacion < posicionActual) {
                Logger.getInstance().info("Pasa por casilla de cobro, recibe paga");
                this.banco.pagarRondaCompletaA(jugador);
            }
            interactuarConCasilla(jugador, nuevaUbicacion);
        }
    }

    private void interactuarConCasilla(Jugador jugador, int numeroDeCasilla) {
        Casilla casilla = this.camino.get(numeroDeCasilla);
        jugador.setPosicion(casilla.getPosicion());
        casilla.interactuarCon(jugador, this);
    }

    public void moverACarcel(Jugador jugador) {
        int posicionCarcel = this.camino.indexOf(new Carcel(null, null));
        this.posicionEnCasilla.put(jugador, posicionCarcel);
        jugador.setPosicion(this.camino.get(posicionCarcel).getPosicion());
    }

    public Casilla getCasillasEn(Posicion posicion) {
        for (Casilla casilla: this.camino)
            if (casilla.getPosicion().x == posicion.x && casilla.getPosicion().y == posicion.y)
                return casilla;
        return null;
    }

    public List<Jugador> getJugadores() {
        return new ArrayList<>(posicionEnCasilla.keySet());
    }
}
