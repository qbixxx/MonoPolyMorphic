package org.tp1.config;

import org.tp1.model.Casillero;

public class Configuracion {
    int montoSalidaLlegada = 200;
    Casillero[] tablero = {new Casillero("Casillero 1"), new Casillero("Casillero 2"),
            new Casillero("Casillero 3"), new Casillero("Casillero 4"), new Casillero("Casillero 5")};

    public Casillero[] getTablero() {
        return tablero;
    }


}
