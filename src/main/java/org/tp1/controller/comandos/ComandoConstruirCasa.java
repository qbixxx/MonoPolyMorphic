package org.tp1.controller.comandos;

import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;

public class ComandoConstruirCasa implements Comando{

    public void ejecutar(JuegoVista juegoVista, Juego juego) {
        juegoVista.mostrarPropiedadesDondeConstruir();
        String indicePropiedadDondeConstruir = juegoVista.recibirOpciones();
        CasilleroPropiedad propiedadElegida =
                juegoVista.elegirPropiedadDondeConstruir(indicePropiedadDondeConstruir);
        juego.construirCasa(propiedadElegida);
    }
}
