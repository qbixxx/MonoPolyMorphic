package org.example.model.excepciones;

public class NoHipotecable extends RuntimeException {

    public NoHipotecable() {
        super("No se puede hipotecar, debe\nvender sus edificos antes");
    }
}
