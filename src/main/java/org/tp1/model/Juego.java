package org.tp1.model;

import java.util.Random;

public class Juego implements Banco {
    private final Tablero tablero;
    private final Jugador[] jugadores;
    private int posicionJugadorDeTurno;
    private final double DINERO_POR_PASAR_POR_SALIDA = 200;

    public Juego(Tablero tablero, Jugador[] jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
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

    public void avanzar() {
        Random rand = new Random();

        // Le sumé 1 para evitar el dado con valor cer (0) y que no se mueva el jugador
        int dado = rand.nextInt(3)+1;

        Jugador jugador = jugadorEnTurnoActual();
        int posicionAnterior = jugador.getPosicionActual();
        jugador.setPosicionActual(jugador.getPosicionActual() + dado);
        // Separé la logica en pequeños metodos ( Single responsability y Declarativo )
        if (pasoPorSalida(jugador)) {
            setearPosicion(jugador);
            cobro(jugador, DINERO_POR_PASAR_POR_SALIDA);
        }
        moverJugador(jugador, posicionAnterior);
    }

    public void moverJugador(Jugador jugador, int posicionAnterior){
        this.tablero.getCasillero(jugador.getPosicionActual()).agregarJugador(jugador);
        this.tablero.getCasillero(posicionAnterior).eliminarJugador(jugador);
    }
    public void setearPosicion(Jugador jugador){
        int nuevaPosicion = Math.abs(this.tablero.tablero.length - jugador.getPosicionActual());
        jugador.setPosicionActual(nuevaPosicion);
    }
    public boolean pasoPorSalida(Jugador jugador){
        return jugador.getPosicionActual() >= this.tablero.tablero.length;
    }

    // Pre:  monto deberia ser un valor positivo si el banco le paga al Jugador
    //      ó un monto negativo si el banco le cobra al jugador
    public void cobro(Jugador jugador, double monto){
        jugador.setDineroDisponible(monto);
    }

}
