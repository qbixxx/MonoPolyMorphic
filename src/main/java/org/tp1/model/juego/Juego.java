package org.tp1.model.juego;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroCarcel;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.juego.estadoJugador.enJuegoState;

import java.util.List;
import java.util.Random;

public class Juego implements Banco {
    private final Tablero tablero;
    private final List<Jugador> jugadores;
    private int posicionJugadorDeTurno;
    private final double DINERO_POR_PASAR_POR_SALIDA = 200;

    public Juego(Tablero tablero, List<Jugador> jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;

        for (Jugador jugador : jugadores){
            this.tablero.obtenerCasillero(0).agregarJugador(jugador);
        }
    }

    public Jugador jugadorEnTurnoActual() {
        return jugadores.get(posicionJugadorDeTurno);
    }

    public void siguienteTurno() {
        posicionJugadorDeTurno += 1;
        if (posicionJugadorDeTurno > jugadores.size() - 1) {
            posicionJugadorDeTurno = 0;
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    private void chequearCasilla(Jugador jugador) {
        Casillero casilleroDeCaida = tablero.obtenerCasillero(jugador.obtenerPosicionActual());
        ComportamientoCasilla comportamiento = casilleroDeCaida.obtenerComportamientoCasilla();
        comportamiento.ejecutarAlCaer(jugador, casilleroDeCaida, this);

    }

    public void pasarTurnoEnCarcel() {
        Jugador jugador = jugadorEnTurnoActual();
        CasilleroCarcel carcel = (CasilleroCarcel) tablero.obtenerCasillero(jugador.obtenerPosicionActual());
        System.out.println(jugador.obtenerNombre() + carcel.cantTurnosEncarcelado(jugador));
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
        int posicionAnterior = jugador.obtenerPosicionActual();
        jugador.setearPosicionActual(jugador.obtenerPosicionActual() + dado);

        if (pasoPorSalida(jugador)) {
            setearPosicion(jugador);
            cobro(jugador, DINERO_POR_PASAR_POR_SALIDA);
        }
        moverJugador(jugador, posicionAnterior);
    }

    public void encarcelarJugador(Jugador jugador, int posicionAnterior) {
        tablero.obtenerCasillero(posicionAnterior).eliminarJugador(jugador);
        CasilleroCarcel carcel = (CasilleroCarcel) tablero.obtenerCasillero(tablero.obtenerPosicionCarcel());
        carcel.encarcelarJugador(jugador);
    }

    public void liberarJugador(Jugador jugador) {
        CasilleroCarcel carcel = (CasilleroCarcel) tablero.obtenerCasillero(tablero.obtenerPosicionCarcel());
        carcel.liberarJugador(jugador);
        jugador.enJuego();
    }

    public void moverJugador(Jugador jugador, int posicionAnterior) {
        this.tablero.obtenerCasillero(jugador.obtenerPosicionActual()).agregarJugador(jugador);
        this.tablero.obtenerCasillero(posicionAnterior).eliminarJugador(jugador);
        jugador.setearCasilleroActual(this.tablero.obtenerCasillero(jugador.obtenerPosicionActual()));
        chequearCasilla(jugador);
    }

    public void setearPosicion(Jugador jugador) {
        int nuevaPosicion = Math.abs(this.tablero.obtenerCasilleros().length - jugador.obtenerPosicionActual());
        jugador.setearPosicionActual(nuevaPosicion);
    }

    public boolean pasoPorSalida(Jugador jugador) {
        return jugador.obtenerPosicionActual() >= this.tablero.obtenerCasilleros().length;
    }

    // Pre:  monto deberia ser un valor positivo si el banco le paga al Jugador
    //      ó un monto negativo si el banco le cobra al jugador
    public void cobro(Jugador jugador, double monto) {
        jugador.setDineroDisponible(monto);
        jugador.enQuiebra();
    }

    public void hipotecarPropiedad(CasilleroPropiedad propiedadAHipotecar){
        this.cobro(this.jugadorEnTurnoActual(), propiedadAHipotecar.obtenerHipoteca());
        propiedadAHipotecar.hipotecar();
    }
    public void deshipotecarPropiedad(CasilleroPropiedad casilleroPropiedad){
        this.cobro(this.jugadorEnTurnoActual(), -casilleroPropiedad.obtenerHipoteca());
        casilleroPropiedad.deshipotecar();
    }

    public Casillero obtenerCasilleroActual() {
        return this.tablero.obtenerCasillero(jugadorEnTurnoActual().obtenerPosicionActual());
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

    public void pagarMulta(Jugador jugador) {
        cobro(jugador, -100);
        jugador.setEstado(new enJuegoState(jugador));
    }
}
