package org.tp1.view;

public enum Colores {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m");

    private final String color;
    Colores(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }
}
