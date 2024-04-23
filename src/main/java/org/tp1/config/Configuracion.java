package org.tp1.config;

import org.tp1.model.casillero.*;

import java.util.ArrayList;

public class Configuracion {
    int montoSalidaLlegada = 200;
    Casillero[] tablero = {
            new CasilleroPaso("🏁 Inicio / Salida", TipoCasillero.DE_PASO, new ArrayList<>()),
            new CasilleroPaso("🏢 Casillero 1", TipoCasillero.DE_PASO, new ArrayList<>()),
            new CasilleroLoteria("🍀 " + "Loteria", TipoCasillero.LOTERIA, 300, new ArrayList<>()),
            new CasilleroPaso("🏢 Casillero 2", TipoCasillero.DE_PASO, new ArrayList<>()),
            new CasilleroPropiedad("🏡 Departamento en Mar del Plata ", TipoCasillero.PROPIEDAD, 100 , 100, "A", new ArrayList<>()),
            new CasilleroIrACarcel("👮‍♂️ " + "Vas preso", TipoCasillero.IR_A_CARCEL, new ArrayList<>()),
            new CasilleroTransporte("🚂 Estacion 1", TipoCasillero.TRANSPORTE, 300, 30, new ArrayList<>()),
            new CasilleroMulta("Multa", TipoCasillero.MULTA, 150, new ArrayList<>()),
            new CasilleroCarcel("👮‍♂️ " + "Carcel", TipoCasillero.CARCEL, new ArrayList<>())};

    public Casillero[] getTablero() {
        return tablero;
    }
}