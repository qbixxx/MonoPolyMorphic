package org.tp1.model.comportamiento;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;
import org.tp1.view.vistaCasillero.CasilleroVista;
import org.tp1.view.vistaCasillero.CasilleroVistaFactory;

import java.util.Scanner;

public class ComportamientoPropiedad implements ComportamientoCasilla {
    public void ejecutarAlCaer(Jugador jugador, Casillero casillero, Juego juego) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (casilleroPropiedad.getDueno() != null && casilleroPropiedad.getDueno() != jugador) {

            jugador.setMensaje("🏙️ Caiste en la propiedad de "+casilleroPropiedad.getDueno().getNombre() +", debes pagarle una renta de $"+casilleroPropiedad.getRenta());
            casilleroPropiedad.getDueno().recibirDinero(jugador, casilleroPropiedad.getRenta());
        }else if (casilleroPropiedad.getDueno() == null) {
            jugador.setMensaje("🏙️️ Caiste en una propiedad en venta");
            if (casilleroPropiedad.getCostoCompra() <= jugador.getDineroDisponible()){
             //   CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(casilleroPropiedad);
              //  casilleroVista.mostrarOpcionesCasillero(jugador);
            }else{
                jugador.setMensaje("🏙️️ Caiste en una propiedad en venta pero no tienes suficiente dinero para comprarla.");
            }


        }else if (casilleroPropiedad.getDueno() == jugador){
            jugador.setMensaje("🏙️️ Caiste en tu propiedad.");
        }
    }

    public void ejecutarComando(Jugador jugador, Casillero casillero, Juego juego, String comando) {
        CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
        if (comando.equals("1")) {
            if (casilleroPropiedad.getCostoCompra() <= jugador.getDineroDisponible() && casilleroPropiedad.getDueno() == null) {
                casilleroPropiedad.comprar(jugador);
            }
        } else {
            jugador.setMensaje("Esa accion no existe");
        }
    }
}
