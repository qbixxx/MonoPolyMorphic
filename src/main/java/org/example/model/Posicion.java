package org.example.model;

public class Posicion {

    public int x;
    public int y;

    public Posicion(int coordenadaX, int coordenadaY) {
        this.x = coordenadaX;
        this.y = coordenadaY;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posicion other = (Posicion) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
