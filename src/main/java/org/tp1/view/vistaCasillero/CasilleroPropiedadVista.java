package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.CasilleroPropiedad;

public class CasilleroPropiedadVista implements CasilleroVista {

    private CasilleroPropiedad casilleroPropiedad;

    public CasilleroPropiedadVista(CasilleroPropiedad casillero) {
        this.casilleroPropiedad = casillero;
    }

    public void mostrarCasillero() {
        System.out.println("Casillero propiedad");
    }

    public void mostrarOpcionesCasillero() {
        System.out.println("Opciones casillero propiedad");
    }
}
