package org.tp1.controller.comandos;

import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;

public interface Comando {

    void ejecutar(JuegoVista juegoVista, Juego juego);
}
