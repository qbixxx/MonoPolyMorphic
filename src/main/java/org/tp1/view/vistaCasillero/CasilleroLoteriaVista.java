package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.CasilleroLoteria;

public class CasilleroLoteriaVista implements CasilleroVista {

    private CasilleroLoteria casilleroLoteria;

    public CasilleroLoteriaVista(CasilleroLoteria casillero) {
        this.casilleroLoteria = casillero;
    }


    public void mostrarCasillero() {
        System.out.println("Casillero loteria");
    }

    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero loteria");
    }
}
