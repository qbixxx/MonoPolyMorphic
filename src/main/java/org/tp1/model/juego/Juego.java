package org.tp1.model.juego;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroCarcel;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.construibles.Casa;

import java.util.Random;

public class Juego implements Banco {
    private final Tablero tablero;
    private final Jugador[] jugadores;
    private int posicionJugadorDeTurno;
    private final double DINERO_POR_PASAR_POR_SALIDA = 200;

    public Juego(Tablero tablero, Jugador[] jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;

        for (Jugador jugador : jugadores){
            this.tablero.getCasillero(0).agregarJugador(jugador);
        }
    }

    public Jugador jugadorEnTurnoActual() {
        return jugadores[posicionJugadorDeTurno];
    }

    public void siguienteTurno() {
        posicionJugadorDeTurno += 1;
        if (posicionJugadorDeTurno > jugadores.length - 1) {
            posicionJugadorDeTurno = 0;
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    private void chequearCasilla(Jugador jugador) {
        Casillero casilleroDeCaida = tablero.getCasillero(jugador.getPosicionActual());
        ComportamientoCasilla comportamiento = casilleroDeCaida.getComportamientoCasilla();
        comportamiento.ejecutarAlCaer(jugador, casilleroDeCaida, this);

    }

    public void pasarTurnoEnCarcel() {
        Jugador jugador = jugadorEnTurnoActual();
        CasilleroCarcel carcel = (CasilleroCarcel) tablero.getCasillero(jugador.getPosicionActual());
        System.out.println(jugador.getNombre() + carcel.cantTurnosEncarcelado(jugador));
        if (carcel.cantTurnosEncarcelado(jugador) < 3) {
            carcel.pasarTurnoEnCarcel(jugador);
            siguienteTurno();
        } else if (carcel.cantTurnosEncarcelado(jugador) >= 3) {
            liberarJugador(jugador);
        }

    }

    public int tirarDado() {
        Random rand = new Random();
        // Le sumé 1 para evitar el dado con valor cer (0) y que no se mueva el jugador
       return rand.nextInt(5) + 1;
    }

    public void avanzar(int dado) {
        Jugador jugador = jugadorEnTurnoActual();
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(jugador.getPosicionActual() + dado);

        if (pasoPorSalida(jugador)) {
            setearPosicion(jugador);
            cobro(jugador, DINERO_POR_PASAR_POR_SALIDA);
        }
        moverJugador(jugador, posicionAnterior);
    }

    public void encarcelarJugador(Jugador jugador, int posicionAnterior) {
        tablero.getCasillero(posicionAnterior).eliminarJugador(jugador);
        CasilleroCarcel carcel = (CasilleroCarcel) tablero.getCasillero(tablero.getPosicionCarcel());
        carcel.encarcelarJugador(jugador);
    }

    public void liberarJugador(Jugador jugador) {
        CasilleroCarcel carcel = (CasilleroCarcel) tablero.getCasillero(tablero.getPosicionCarcel());
        carcel.liberarJugador(jugador);
        jugador.enJuego();
    }

    public void moverJugador(Jugador jugador, int posicionAnterior) {
        this.tablero.getCasillero(jugador.getPosicionActual()).agregarJugador(jugador);
        this.tablero.getCasillero(posicionAnterior).eliminarJugador(jugador);
        jugador.setCasilleroActual(this.tablero.getCasillero(jugador.getPosicionActual()));
        chequearCasilla(jugador);
    }

    public void setearPosicion(Jugador jugador) {
        int nuevaPosicion = Math.abs(this.tablero.getCasilleros().length - jugador.getPosicionActual());
        jugador.setPosicionActual(nuevaPosicion);
    }

    public boolean pasoPorSalida(Jugador jugador) {
        return jugador.getPosicionActual() >= this.tablero.getCasilleros().length;
    }

    // Pre:  monto deberia ser un valor positivo si el banco le paga al Jugador
    //      ó un monto negativo si el banco le cobra al jugador
    public void cobro(Jugador jugador, double monto) {
        jugador.setDineroDisponible(monto);
        jugador.enQuiebra();
    }

    public void hipotecarPropiedad(CasilleroPropiedad propiedadAHipotecar){
        this.cobro(this.jugadorEnTurnoActual(), propiedadAHipotecar.getHipoteca());
        propiedadAHipotecar.hipotecar();
    }
    public void deshipotecarPropiedad(CasilleroPropiedad casilleroPropiedad){
        this.cobro(this.jugadorEnTurnoActual(), -casilleroPropiedad.getHipoteca());
        casilleroPropiedad.deshipotecar();
    }

    public Casillero obtenerCasilleroActual() {
        return this.tablero.getCasillero(jugadorEnTurnoActual().getPosicionActual());
    }

    public void venderPropiedad(CasilleroPropiedad propiedad) {
        propiedad.vender(this.jugadorEnTurnoActual());
    }

    public void venderTransporte(CasilleroTransporte transporte) {
        transporte.vender(this.jugadorEnTurnoActual());
    }

    public void construirCasa(CasilleroPropiedad casilleroPropiedad) {
        casilleroPropiedad.construirCasa(this.jugadorEnTurnoActual());
    }
}
