package org.tp1.view;

import org.tp1.model.Jugador;
import org.tp1.model.Tablero;
import org.tp1.model.casillero.Casillero;
import org.tp1.view.vistaCasillero.CasilleroVista;
import org.tp1.view.vistaCasillero.CasilleroVistaFactory;

public class TableroVista {

    private final Tablero tablero;

    public TableroVista(Tablero tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        for (Casillero casillero : tablero.getCasilleros()) {
            CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(casillero);
            casilleroVista.mostrarCasillero();
        }
    }

    public void mostrarOpciones(Jugador jugador) {
        Casillero casilleroActual = tablero.getCasillero(jugador.getPosicionActual());
        CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(casilleroActual);
        casilleroVista.mostrarOpcionesCasillero(jugador);
    }
}
