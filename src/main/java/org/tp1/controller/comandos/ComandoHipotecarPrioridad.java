package org.tp1.controller.comandos;

import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;

public class ComandoHipotecarPrioridad implements Comando{
    public void ejecutar(JuegoVista juegoVista, Juego juego) {
        juegoVista.mostrarPropiedadesSinHipotecar();
        String indicePropiedadAHipotecar = juegoVista.recibirOpciones();
        CasilleroPropiedad propiedadElegida = juegoVista.elegirPropiedad(indicePropiedadAHipotecar);
        juego.hipotecarPropiedad(propiedadElegida);
    }
}
