package example.model.propiedades.construibles;

public class Hotel implements Edificio {
    private double precio;
    private double peaje;

    public Hotel() {
        this.precio = 5000;
        this.peaje = 200;
    }

    @Override
    public double getPeaje() {
        return this.peaje;
    }
}
