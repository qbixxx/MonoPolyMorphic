package org.tp1.model.juego;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.casillero.TipoCasillero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tablero {

    private final Casillero[] tablero;
    private int posicionCarcel;

    private Map<String, List<CasilleroPropiedad>> gruposDePropiedades;

    public Tablero(Casillero[] tablero) {
        this.tablero = tablero;
        this.posicionCarcel = obtenerPosicionCarcel();
        this.gruposDePropiedades = inicializarGrupos();
    }

    private Map<String, List<CasilleroPropiedad>> inicializarGrupos() {
        HashMap<String, List<CasilleroPropiedad>> props = new HashMap<>();
        for (Casillero casillero: this.tablero) {
            if (casillero.getTipoCasillero().equals(TipoCasillero.PROPIEDAD)) {
                CasilleroPropiedad c = (CasilleroPropiedad) casillero;
                if (!props.containsKey(c.getGrupo())) {
                    props.put(c.getGrupo(), new ArrayList<>());
                }
                props.get(c.getGrupo()).add(c);
            }
        }
        return props;
    }

    private int obtenerPosicionCarcel() {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i].getTipoCasillero().equals(TipoCasillero.CARCEL)) {
                return i;
            }
        }
        throw new RuntimeException("No hay carcel en este tablero");
    }

    public List<CasilleroPropiedad> chequearSiJugadorTieneAlgunGrupo(Jugador jugador) {
        List<CasilleroPropiedad> todosLosGrupos = new ArrayList<>();

        for (List<CasilleroPropiedad> propiedades : this.gruposDePropiedades.values()) {
            boolean tieneElGrupo = true;

            for (CasilleroPropiedad propiedad : propiedades) {
                if (propiedad.getDueno() == null || !propiedad.getDueno().equals(jugador)) {
                    tieneElGrupo = false;
                    break;
                }
            }

            if (tieneElGrupo) {
                todosLosGrupos.addAll(propiedades);
            }
        }

        return todosLosGrupos;
    }

    public boolean chequearDiferenciaCasas(Jugador jugador, CasilleroPropiedad casilleroPropiedad) {
        return true;
    }

    public Casillero[] getCasilleros() {
        return tablero;
    }

    public Casillero getCasillero(int indice) {
        return tablero[indice];
    }

    public int getPosicionCarcel() {
        return posicionCarcel;
    }

    private void setPosicionCarcel(int carcel) {
        this.posicionCarcel = carcel;
    }
}
