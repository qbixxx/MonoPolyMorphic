package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.CasilleroMulta;

public class CasilleroMultaVista implements CasilleroVista {

    private CasilleroMulta casilleroMulta;

    public CasilleroMultaVista(CasilleroMulta casillero) {
        this.casilleroMulta = casillero;
    }

    public void mostrarCasillero() {
        System.out.println("Casillero multa");
    }

    @Override
    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero multa");
    }
}
