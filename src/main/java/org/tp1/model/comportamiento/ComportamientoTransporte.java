package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.juego.Juego;

public class ComportamientoTransporte implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroTransporte casilleroTransporte = (CasilleroTransporte) casillero;
        if (casilleroTransporte.obtenerDueno() != null && !casilleroTransporte.obtenerDueno().equals(jugador)) {
            casilleroTransporte.obtenerDueno().recibirDinero(jugador, casilleroTransporte.obtenerTarifa());
        }
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        CasilleroTransporte casilleroTransporte = (CasilleroTransporte) casillero;
        if (comando.equals("1")) {
            if (casilleroTransporte.obtenerCostoCompra() <= jugador.obtenerDineroDisponible() && casilleroTransporte.obtenerDueno() == null) {
                casilleroTransporte.comprar(jugador);

            }
        }
    }
}
