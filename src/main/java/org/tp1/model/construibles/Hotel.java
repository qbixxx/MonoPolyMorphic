package org.tp1.model.construibles;

public class Hotel extends Edificio{

    public Hotel() {
        super(50, 500);
    }

    public double obtenerPeaje() {
        return this.peaje;
    }
}
