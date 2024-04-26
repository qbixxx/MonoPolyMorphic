package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;
import org.tp1.view.vistaCasillero.CasilleroVista;
import org.tp1.view.vistaCasillero.CasilleroVistaFactory;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class ComportamientoPropiedad implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (casilleroPropiedad.estaHipotecada()) {
            jugador.setMensaje("🏙️ Caiste en una propiedad hipotecada!");
        }
        else if (casilleroPropiedad.getDueno() == null) {
            jugador.setMensaje("🏙️️ Caiste en una propiedad en venta");
            if (casilleroPropiedad.getCostoCompra() > jugador.getDineroDisponible()) {
                jugador.setMensaje("🏙️️ Caiste en una propiedad en venta pero no tienes suficiente dinero para comprarla.");
            }
        }
        else if (casilleroPropiedad.getDueno() != jugador) {
            jugador.setMensaje("🏙️ Caiste en la propiedad de "+casilleroPropiedad.getDueno().getNombre() +", debes pagarle una renta de $"+casilleroPropiedad.getRenta());
            casilleroPropiedad.pagarRenta(jugador);
        }
        else {
            jugador.setMensaje("🏙️️ Caiste en tu propiedad.");
        }
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (comando.equals("1")) {
            if (casilleroPropiedad.getCostoCompra() <= jugador.getDineroDisponible() && casilleroPropiedad.getDueno() == null) {
                casilleroPropiedad.comprar(jugador);
            }
        }
    }
}
