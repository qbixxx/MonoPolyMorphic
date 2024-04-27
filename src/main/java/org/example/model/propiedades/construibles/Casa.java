package org.example.model.propiedades.construibles;

public class Casa implements Edificio {

    private double precio;
    private double peaje;

    public Casa() {
        this.precio = 5000;
        this.peaje = 200;
    }

    @Override
    public double getPeaje() {
        return this.peaje;
    }
}
