package org.tp1.controller.comandos;

import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;

public class ComandoVenderTransporte implements Comando{
    public void ejecutar(JuegoVista juegoVista, Juego juego) {
        juegoVista.mostrarTransportesEnPosesion();
        String indiceTransporteElegido = juegoVista.recibirOpciones();
        CasilleroTransporte transporteElegido = juegoVista.elegirTransporte(indiceTransporteElegido);
        juego.venderTransporte(transporteElegido);
    }
}
