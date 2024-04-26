package org.tp1.model.construibles;

public abstract class Edificio {

    protected double peaje;
    protected double precio;

    public Edificio(double precio, double peaje) {
        this.peaje = peaje;
        this.precio = precio;
    }

    public abstract double obtenerPeaje();

    public double obtenerPrecio() {
        return this.precio;
    }
}
