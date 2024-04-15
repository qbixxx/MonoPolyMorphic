package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.CasilleroCarcel;

public class CasilleroCarcelVista implements CasilleroVista {

    CasilleroCarcel casilleroCarcel;

    public CasilleroCarcelVista(CasilleroCarcel casillero) {
        this.casilleroCarcel = casillero;
    }

    public void mostrarCasillero() {
        System.out.println("Casillero carcel");
    }

    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero carcel");
    }
}
