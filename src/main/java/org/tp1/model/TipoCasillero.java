package org.tp1.model;

public enum TipoCasillero {

    DE_PASO(""),
    CARCEL("carcel"),
    LOTERIA("loteria"),
    MULTA("multa"),
    IR_A_CARCEL("irACarcel"),
    PROPIEDAD("prop"),
    TRANSPORTE("transporte");

    private final String tipoCasillero;

    TipoCasillero(String tipoCasillero) {
        this.tipoCasillero = tipoCasillero;
    }

    public String getTipoCasillero() {
        return tipoCasillero;
    }
}
