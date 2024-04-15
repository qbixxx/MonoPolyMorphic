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

    private void chequearCasilla(Jugador jugador) {
        // no respeta open closed
        Casillero casilleroDeCaida = tablero.getCasillero(jugador.getPosicionActual());
        if (casilleroDeCaida.getTipoCasillero().equals(TipoCasillero.MULTA)) {
            CasilleroMulta casilleroMulta = (CasilleroMulta) casilleroDeCaida;
            cobro(jugador, -casilleroMulta.getValorMulta());
        } else if (casilleroDeCaida.getTipoCasillero().equals(TipoCasillero.LOTERIA)) {
            CasilleroLoteria casilleroLoteria = (CasilleroLoteria) casilleroDeCaida;
            cobro(jugador, casilleroLoteria.getValorPozo());
        } else if (casilleroDeCaida.getTipoCasillero().equals(TipoCasillero.TRANSPORTE)) {
            CasilleroEstacion casilleroEstacion = (CasilleroEstacion) casilleroDeCaida;
            if (casilleroEstacion.getDueno() != null) {
                casilleroEstacion.getDueno().recibirDinero(jugador, casilleroEstacion.getTarifa());
            }
        } else if (casilleroDeCaida.getTipoCasillero().equals(TipoCasillero.PROPIEDAD)) {
            CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casilleroDeCaida;
            if (casilleroPropiedad.getDueno() != null) {
                casilleroPropiedad.getDueno().recibirDinero(jugador, casilleroPropiedad.getRenta());
            }
        } else if (casilleroDeCaida.getTipoCasillero().equals(TipoCasillero.IR_A_CARCEL)) {

            // buscar la carcel en el tablero (podria ser un metodo del tablero directamente)
            int indiceCarcel = 0;
            int posicionAnterior = jugador.getPosicionActual();
            for (int i = 0; i < tablero.getCasilleros().length; i++) {
                if (tablero.getCasilleros()[i].getTipoCasillero().equals(TipoCasillero.CARCEL)) {
                    indiceCarcel = i;
                }
            }
            jugador.setPosicionActual(indiceCarcel);
            jugador.setEstadoJugador(EstadoJugador.ENCARCELADO);
            moverJugador(jugador, posicionAnterior);
        }
    }

    public void avanzar() {
        Random rand = new Random();

        // Le sumé 1 para evitar el dado con valor cer (0) y que no se mueva el jugador
        int dado = rand.nextInt(3) + 1;

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

    public void moverJugador(Jugador jugador, int posicionAnterior) {
        this.tablero.getCasillero(jugador.getPosicionActual()).agregarJugador(jugador);
        this.tablero.getCasillero(posicionAnterior).eliminarJugador(jugador);
        chequearCasilla(jugador);
    }

    public void setearPosicion(Jugador jugador) {
        int nuevaPosicion = Math.abs(this.tablero.tablero.length - jugador.getPosicionActual());
        jugador.setPosicionActual(nuevaPosicion);
    }

    public boolean pasoPorSalida(Jugador jugador) {
        return jugador.getPosicionActual() >= this.tablero.tablero.length;
    }

    // Pre:  monto deberia ser un valor positivo si el banco le paga al Jugador
    //      ó un monto negativo si el banco le cobra al jugador
    public void cobro(Jugador jugador, double monto) {
        jugador.setDineroDisponible(monto);
    }

}
