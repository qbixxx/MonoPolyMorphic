package org.tp1.config;

import org.tp1.model.*;

public class Configuracion {
    int montoSalidaLlegada = 200;
    Casillero[] tablero = {new Casillero("🏢 Casillero 1", TipoCasillero.DE_PASO), new CasilleroLoteria("🍀 Loteria",
            TipoCasillero.LOTERIA, 300),
            new Casillero("🏢 Casillero 2", TipoCasillero.DE_PASO),
            new Casillero("👮‍♂️ " + "Vas preso", TipoCasillero.IR_A_CARCEL),
            new CasilleroEstacion("🚂 Estacion 1", TipoCasillero.TRANSPORTE, 300, 30),
            new CasilleroMulta("👮‍♂️ " + "Multa", TipoCasillero.MULTA, 150),
            new Casillero("👮‍♂️ " + "Carcel", TipoCasillero.CARCEL)};

    public Casillero[] getTablero() {
        return tablero;
    }
}