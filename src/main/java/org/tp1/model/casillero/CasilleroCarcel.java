package org.tp1.model.casillero;

import org.tp1.model.Jugador;
import org.tp1.model.comportamiento.ComportamientoCarcel;
import org.tp1.model.comportamiento.ComportamientoCasilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CasilleroCarcel extends Casillero {

    private List<Jugador> encarcelados;
    private HashMap<String, Integer> turnosEncarcelados;

    public CasilleroCarcel(String nombre, TipoCasillero tipoCasillero) {
        super(nombre, tipoCasillero);
        this.encarcelados = new ArrayList<>();
        this.turnosEncarcelados = new HashMap<>();
    }

    public void encarcelarJugador(Jugador jugador) {
        encarcelados.add(jugador);
        jugador.enCarcel();
        turnosEncarcelados.put(jugador.obtenerNombre(), 0);
    }

    public void liberarJugador(Jugador jugador) {
        encarcelados.remove(jugador);
        jugador.enJuego();
        jugadores.add(jugador);
    }

    public int cantTurnosEncarcelado(Jugador jugador) {
        return turnosEncarcelados.get(jugador.obtenerNombre());
    }

    public void pasarTurnoEnCarcel(Jugador jugador) {
        turnosEncarcelados.put(jugador.obtenerNombre(), cantTurnosEncarcelado(jugador) + 1);
    }

    public List<Jugador> obtenerEncarcelados() {
        return encarcelados;
    }

    public ComportamientoCasilla obtenerComportamientoCasilla() {
        return new ComportamientoCarcel();
    }
}
