package org.tp1.config;

import org.tp1.model.Casillero;

public class Configuracion {
    int montoSalidaLlegada = 200;
    Casillero[] tablero = {new Casillero("🏢 Casillero 1"), new Casillero("🍀 Loteria"),
            new Casillero("🏢 Casillero 2"), new Casillero("🚂 Estacion 1"), new Casillero("👮‍♂️ Multa")};

    public Casillero[] getTablero() {
        return tablero;
    }
}