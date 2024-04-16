package org.tp1.config;

import org.tp1.model.casillero.*;

public class Configuracion {
    int montoSalidaLlegada = 200;
    Casillero[] tablero = {new CasilleroPaso("🏢 Casillero 1", TipoCasillero.DE_PASO), new CasilleroLoteria("🍀 Loteria",
            TipoCasillero.LOTERIA, 300),
            new CasilleroPaso("🏢 Casillero 2", TipoCasillero.DE_PASO),
            new CasilleroIrACarcel("👮‍♂️ " + "Vas preso", TipoCasillero.IR_A_CARCEL),
            new CasilleroTransporte("🚂 Estacion 1", TipoCasillero.TRANSPORTE, 300, 30),
            new CasilleroMulta("Multa", TipoCasillero.MULTA, 150),
            new CasilleroCarcel("👮‍♂️ " + "Carcel", TipoCasillero.CARCEL)};

    public Casillero[] getTablero() {
        return tablero;
    }
}