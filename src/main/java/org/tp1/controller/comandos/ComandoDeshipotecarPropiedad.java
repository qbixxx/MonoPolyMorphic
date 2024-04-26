package org.tp1.controller.comandos;

import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;

public class ComandoDeshipotecarPropiedad implements Comando {
    public void ejecutar(JuegoVista juegoVista, Juego juego) {
        juegoVista.mostrarPropiedadesHipotecadas();
        String indicePropiedadADeshipotecar = juegoVista.recibirOpciones();
        CasilleroPropiedad propiedadElegida = juegoVista.elegirPropiedad(indicePropiedadADeshipotecar);
        juego.deshipotecarPropiedad(propiedadElegida);
    }
}
