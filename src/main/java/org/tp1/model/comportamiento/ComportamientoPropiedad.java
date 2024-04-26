package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;

public class ComportamientoPropiedad implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (casilleroPropiedad.estaHipotecada()) {
            jugador.setearMensaje("🏙️ Caiste en una propiedad hipotecada!");
        }
        else if (casilleroPropiedad.obtenerDueno() == null) {
            jugador.setearMensaje("🏙️️ Caiste en una propiedad en venta");
            if (casilleroPropiedad.obtenerCostoCompra() > jugador.obtenerDineroDisponible()) {
                jugador.setearMensaje("🏙️️ Caiste en una propiedad en venta pero no tienes suficiente dinero para comprarla.");
            }
        }
        else if (casilleroPropiedad.obtenerDueno() != jugador) {
            jugador.setearMensaje("🏙️ Caiste en la propiedad de "+casilleroPropiedad.obtenerDueno().obtenerNombre() +", debes pagarle una renta de $"+casilleroPropiedad.obtenerRenta());
            casilleroPropiedad.pagarRenta(jugador);
        }
        else {
            jugador.setearMensaje("🏙️️ Caiste en tu propiedad.");
        }
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (comando.equals("1")) {
            if (casilleroPropiedad.obtenerCostoCompra() <= jugador.obtenerDineroDisponible() && casilleroPropiedad.obtenerDueno() == null) {
                casilleroPropiedad.comprar(jugador);
            }
        }
    }
}
