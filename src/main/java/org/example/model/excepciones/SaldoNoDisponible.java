package org.example.model.excepciones;

public class SaldoNoDisponible extends RuntimeException{

    public SaldoNoDisponible(double saldo) {
        super("Debe pagar" + String.valueOf(saldo) + "\n" + "Saldo insuficiente, si tiene propiedades\nvenda una casa/hotel o hipotequela");
    }
}
