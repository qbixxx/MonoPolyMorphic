package org.tp1.config;

import org.tp1.model.casillero.*;

import java.util.ArrayList;

public class Configuracion {
    private final int montoSalidaLlegada = 200;
    private final Casillero[] tablero = {
            new CasilleroPaso("🏁 Inicio / Salida", TipoCasillero.DE_PASO),
            new CasilleroPropiedad("🏡 Parque de la costa", TipoCasillero.PROPIEDAD, 10 , 100, "C",  500),
            new CasilleroPropiedad("🏡 Teatro Colon", TipoCasillero.PROPIEDAD, 10 , 100, "D",  500),
            new CasilleroLoteria("🍀 Loteria", TipoCasillero.LOTERIA, 300),
            new CasilleroTransporte("🚂 Constitucion", TipoCasillero.TRANSPORTE, 151, 30),
            new CasilleroPaso("🏢 Casillero 1", TipoCasillero.DE_PASO),
            new CasilleroPropiedad("🏡 Cabildo", TipoCasillero.PROPIEDAD, 10 , 100, "F",  500),
            new CasilleroLoteria( "🍀 Loteria", TipoCasillero.LOTERIA, 300),
            new CasilleroPaso("🏢 Casillero 2", TipoCasillero.DE_PASO),
            new CasilleroPropiedad("🏡 Departamento en Mar del Plata ", TipoCasillero.PROPIEDAD, 10 , 100, "B",  500),
            new CasilleroIrACarcel("👮‍♂️ Vas preso", TipoCasillero.IR_A_CARCEL),
            new CasilleroTransporte("🚂 Estacion 1", TipoCasillero.TRANSPORTE, 151, 30),
            new CasilleroMulta("Multa", TipoCasillero.MULTA, 150),
            new CasilleroPropiedad("🏡 Casa Rosada", TipoCasillero.PROPIEDAD, 10 , 100, "V",  500),
            new CasilleroCarcel( "👮‍♂️ Carcel", TipoCasillero.CARCEL),
            new CasilleroPropiedad("🏡 Congreso", TipoCasillero.PROPIEDAD, 10 , 100, "C",  500),
            new CasilleroTransporte("🚂 Parada 62", TipoCasillero.TRANSPORTE, 151, 30)};
    public Casillero[] getTablero() {
        return this.tablero;
    }
}
