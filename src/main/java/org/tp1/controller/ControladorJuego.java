package org.tp1.controller;

import org.tp1.model.EstadoJugador;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.casillero.TipoCasillero;
import org.tp1.model.juego.IJuego;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;
import org.tp1.view.vistaCasillero.CasilleroVista;
import org.tp1.view.vistaCasillero.CasilleroVistaFactory;

import java.util.Scanner;

public class ControladorJuego {
    private final IJuego monopoly;
    private final JuegoVista juegoVista;

    public ControladorJuego(Juego juego) {
        this.monopoly = juego;
        this.juegoVista = new JuegoVista(juego);
    }

    public boolean enJuego() {
        int numJugadoresEnJuego = 0;
        for (Jugador jugador : monopoly.getJugadores()) {
            if (jugador.getEstadoJugador().equals(EstadoJugador.EN_JUEGO)) {
                numJugadoresEnJuego++;
            }
        }
        return numJugadoresEnJuego >= 2;
    }

    public void jugarTurno() {
        juegoVista.mostrarDatosJuego();
        juegoVista.mostrarOpciones();
        elegirOpcion();
    }

    public void elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        if (!monopoly.jugadorEnTurnoActual().getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            if (decision.equals(Comandos.AVANZAR.getComando())) {
                monopoly.avanzar();

                if (monopoly.getTablero().getCasillero(monopoly.jugadorEnTurnoActual().getPosicionActual()).getTipoCasillero().equals(TipoCasillero.PROPIEDAD)){

                    CasilleroPropiedad propiedad = (CasilleroPropiedad) monopoly.getTablero().getCasillero(monopoly.jugadorEnTurnoActual().getPosicionActual());

                    if (propiedad.getCostoCompra() <= monopoly.jugadorEnTurnoActual().getDineroDisponible() && propiedad.getDueno() == null){
                        CasilleroVista casilleroVista = CasilleroVistaFactory.crearVista(propiedad);
                        casilleroVista.mostrarOpcionesCasillero(monopoly.jugadorEnTurnoActual());
                        String decisionProp = scanner.nextLine();
                        if (decisionProp.equals(Comandos.COMPRAR.getComando())) {
                            System.out.println("PROPIEDAD COMPRADA");

                            propiedad.comprar(monopoly.jugadorEnTurnoActual());

                        }
                    }

                }
                //monopoly.siguienteTurno();
            } else if (decision.equals(Comandos.SIG_TURNO.getComando())) {
                monopoly.siguienteTurno();
            } else {
                System.out.println("Esta accion no existe");
            }
        } else {
            if (decision.equals(Comandos.AVANZAR.getComando())) {
                monopoly.pasarTurnoEnCarcel();
            }
        }
    }
}
