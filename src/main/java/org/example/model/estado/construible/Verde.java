package org.example.model.estado.construible;

import org.example.model.casilla.Terreno;
import org.example.model.excepciones.NoVendible;
import org.example.model.jugador.Saldo;

public class Verde implements Semaforo{
    @Override
    public void construirCasa(Terreno terreno, Saldo saldo) {
        terreno.construirCasa(saldo);
    }

    @Override
    public void venderCasa(Terreno terreno, Saldo saldo) {
        throw new NoVendible();
    }
}
