package org.tp1.config;

import org.tp1.model.casillero.*;

import java.util.ArrayList;

public class Configuracion {
    int montoSalidaLlegada = 200;
    Casillero[] tablero = {
            new CasilleroPaso("🏁 Inicio / Salida", TipoCasillero.DE_PASO),
            new CasilleroPaso("🏢 Casillero 1", TipoCasillero.DE_PASO),
            new CasilleroLoteria("🍀 " + "Loteria", TipoCasillero.LOTERIA, 300),
            new CasilleroPaso("🏢 Casillero 2", TipoCasillero.DE_PASO),
            new CasilleroPropiedad("🏡 Departamento en Mar del Plata ", TipoCasillero.PROPIEDAD, 10 , 100, "A",  500),
            new CasilleroIrACarcel("👮‍♂️ " + "Vas preso", TipoCasillero.IR_A_CARCEL),
            new CasilleroTransporte("🚂 Estacion 1", TipoCasillero.TRANSPORTE, 151, 30),
            new CasilleroMulta("Multa", TipoCasillero.MULTA, 150),
            new CasilleroCarcel("👮‍♂️ " + "Carcel", TipoCasillero.CARCEL)};
    public Casillero[] getTablero() {
        return tablero;
    }
}
