package org.example.model.jugador;

import org.example.model.Logger;
import org.example.model.excepciones.SaldoNoDisponible;

public class Saldo {

    private double disponible;

    private JuegoObserver jugadorObserver;

    private double invertido; //dinero en propiedades

    public Saldo(double inicial) {
        this.disponible = inicial;
        this.invertido = 0;
    }

    public void agregarObserver(JuegoObserver jugadorObserver) {
        this.jugadorObserver = jugadorObserver;
    }

    public void recibir(double monto) {
        this.disponible += monto;
    }

    public void pagar(double deuda) {
        if (this.disponible + this.invertido < deuda) {
            jugadorObserver.notificarQuiebra();
        }
        else if (this.disponible < deuda) {
            throw new SaldoNoDisponible();
        }

        Logger.getInstance().info("paga " + deuda);
        this.disponible -= deuda;
    }

    public void pagarSinObligacion(double deuda) {
        if (this.disponible < deuda) {
            throw new SaldoNoDisponible();
        }
        Logger.getInstance().info("paga " + deuda);
        this.disponible -= deuda;
    }

    public void invertir(double coste) {
        this.invertido += coste;
    }

    public void desInvertir(double coste) {
        this.invertido -= coste;
    }
}
