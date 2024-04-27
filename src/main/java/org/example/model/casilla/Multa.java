package org.example.model.casilla;

import org.example.configuracion.Configuracion;
import org.example.configuracion.DataCasilla;
import org.example.model.Logger;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.jugador.Jugador;
import org.example.model.use_case.PagarMultaUseCase;

public class Multa extends Casilla {

    private static final double monto = Configuracion.valorMulta;

    public Multa(Posicion posicion, DataCasilla dataCasilla) {
        this.posicion = posicion;
        this.dataCasilla = dataCasilla;
    }

    @Override
    public void interactuarCon(Jugador jugador, Tablero tablero) {
        Logger.getInstance().info("Multa, debe pagar " + monto);
        jugador.agregarOpcionable(new PagarMultaUseCase(jugador, monto));
    }
}
