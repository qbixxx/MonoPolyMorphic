package org.example.model.excepciones;

public class NoVendible extends RuntimeException {

    public NoVendible() {
        super("No se puede vender");
    }
}
