package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.CasilleroIrACarcel;

public class CasilleroIrACarcelVista implements CasilleroVista {

    private CasilleroIrACarcel casillero;

    public CasilleroIrACarcelVista(CasilleroIrACarcel casillero) {
        this.casillero = casillero;
    }

    @Override
    public void mostrarCasillero() {
        System.out.println("Casillero ir a carcel");
    }

    @Override
    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero ir a carcel");
    }
}
