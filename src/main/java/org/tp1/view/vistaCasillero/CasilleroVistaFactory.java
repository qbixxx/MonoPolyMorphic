package org.tp1.view.vistaCasillero;

import org.tp1.model.casillero.*;

public class CasilleroVistaFactory {

    public static CasilleroVista crearVista(Casillero casillero) {
        switch (casillero.getTipoCasillero()) {
            case IR_A_CARCEL -> {
                return new CasilleroIrACarcelVista((CasilleroIrACarcel) casillero);
            }
            case MULTA -> {
                return new CasilleroMultaVista((CasilleroMulta) casillero);
            }
            case CARCEL -> {
                return new CasilleroCarcelVista((CasilleroCarcel) casillero);
            }
            case LOTERIA -> {
                return new CasilleroLoteriaVista((CasilleroLoteria) casillero);
            }
            case PROPIEDAD -> {
                return new CasilleroPropiedadVista((CasilleroPropiedad) casillero);
            }
            case TRANSPORTE -> {
                return new CasilleroTransporteVista((CasilleroTransporte) casillero);
            }
            default -> {
                return new CasilleroDePasoVista((CasilleroPaso) casillero);
            }
        }
    }
}
