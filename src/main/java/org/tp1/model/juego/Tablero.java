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
        this.posicionCarcel = calcularPosicionCarcel();
        this.gruposDePropiedades = inicializarGrupos();
    }

    private Map<String, List<CasilleroPropiedad>> inicializarGrupos() {
        HashMap<String, List<CasilleroPropiedad>> props = new HashMap<>();
        for (Casillero casillero: this.tablero) {
            if (casillero.getTipoCasillero().equals(TipoCasillero.PROPIEDAD)) {
                CasilleroPropiedad c = (CasilleroPropiedad) casillero;
                if (!props.containsKey(c.obtenerGrupo())) {
                    props.put(c.obtenerGrupo(), new ArrayList<>());
                }
                props.get(c.obtenerGrupo()).add(c);
            }
        }
        return props;
    }

    private int calcularPosicionCarcel() {
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
                if (propiedad.obtenerDueno() == null || !propiedad.obtenerDueno().equals(jugador)) {
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

    public Casillero[] obtenerCasilleros() {
        return tablero;
    }

    public Casillero obtenerCasillero(int indice) {
        return tablero[indice];
    }

    public int obtenerPosicionCarcel() {
        return posicionCarcel;
    }

    private void setearPosicionCarcel(int carcel) {
        this.posicionCarcel = carcel;
    }
}
