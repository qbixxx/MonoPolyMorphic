package org.example.model.excepciones;

public class NoComprable extends RuntimeException {

    public NoComprable() {
        super("No se puede comprar");
    }
}
