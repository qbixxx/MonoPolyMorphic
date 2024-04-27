package org.example.model.estado.construible;

import org.example.model.casilla.Terreno;
import org.example.model.jugador.Saldo;

public interface Semaforo {

    void construirCasa(Terreno terreno, Saldo saldo);

    void venderCasa(Terreno terreno, Saldo saldo);
}
