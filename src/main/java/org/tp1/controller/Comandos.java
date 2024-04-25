package org.tp1.controller;

public enum Comandos {
    AVANZAR("1"),
    SIG_TURNO("2"),
    COMPRAR("3")
    ;

    private String comando;

    Comandos(String comando) {
        this.comando = comando;
    }

    public String getComando() {
        return comando;
    }
}
