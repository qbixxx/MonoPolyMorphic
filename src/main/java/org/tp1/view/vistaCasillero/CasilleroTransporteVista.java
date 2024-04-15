package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.CasilleroTransporte;

public class CasilleroTransporteVista implements CasilleroVista {

    private CasilleroTransporte casilleroTransporte;

    public CasilleroTransporteVista(CasilleroTransporte casillero) {
        this.casilleroTransporte = casillero;
    }

    public void mostrarCasillero() {
        System.out.println("Casillero transporte");
    }

    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero transporte");
    }
}
