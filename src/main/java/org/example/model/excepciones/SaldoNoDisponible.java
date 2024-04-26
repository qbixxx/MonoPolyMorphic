package org.example.model.excepciones;

public class SaldoNoDisponible extends RuntimeException{

    public SaldoNoDisponible() {
        super("Saldo insuficiente, si tiene propiedades\nvenda una casa/hotel o hipotequela");
    }
}
