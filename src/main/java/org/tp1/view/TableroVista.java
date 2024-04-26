package org.tp1.view;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.juego.Tablero;
import org.tp1.view.vistaCasillero.CasilleroVista;
import org.tp1.view.vistaCasillero.CasilleroVistaFactory;

public class TableroVista {

    private final Tablero tablero;

    public TableroVista(Tablero tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        for (Casillero casillero : tablero.obtenerCasilleros()) {
            CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(casillero);
            casilleroVista.mostrarCasillero();
        }
    }

    public void mostrarOpcionesGenericas(Jugador jugador) {
        Casillero casilleroActual = tablero.obtenerCasillero(jugador.obtenerPosicionActual());
        CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(casilleroActual);
        casilleroVista.mostrarOpcionesGenericas(jugador, this.tablero);
    }

    public void mostrarOpciones(Jugador jugador) {

        Casillero casilleroActual = tablero.obtenerCasillero(jugador.obtenerPosicionActual());
        CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(casilleroActual);
        casilleroVista.mostrarOpcionesCasillero(jugador);


        /*
         * Agregar la logica segun el estado del jugador.
         *
         * Ya sea:
         * Hipotecar, construir, vender, etc
         * Expandir a los demas casilleros
         *
         * */
    }
}
