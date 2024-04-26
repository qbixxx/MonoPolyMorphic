package org.tp1.controller.comandos;

import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;

public class ComandoVenderPropiedad implements Comando {
    public void ejecutar(JuegoVista juegoVista, Juego juego) {
        juegoVista.mostrarPropiedadesEnPosesion();
        String indicePropiedadElegida = juegoVista.recibirOpciones();
        CasilleroPropiedad propiedadElegida = juegoVista.elegirPropiedad(indicePropiedadElegida);
        juego.venderPropiedad(propiedadElegida);
    }
}
