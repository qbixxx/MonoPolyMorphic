package org.tp1.controller;

import org.tp1.model.EstadoJugador;
import org.tp1.model.Jugador;
import org.tp1.model.casillero.Casillero;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.casillero.TipoCasillero;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.juego.Juego;
import org.tp1.view.JuegoVista;
import org.tp1.view.vistaCasillero.CasilleroVista;
import org.tp1.view.vistaCasillero.CasilleroVistaFactory;

import java.util.Objects;
import java.util.Scanner;

public class ControladorJuego {
    private final Juego monopoly;
    private final JuegoVista juegoVista;
    private EstadoJuego estadoJuego;

    public ControladorJuego(Juego juego, EstadoJuego estadoJuego) {
        this.monopoly = juego;
        this.juegoVista = new JuegoVista(juego);
        this.estadoJuego = estadoJuego;
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
        String decision = juegoVista.recibirOpciones();
        elegirOpcion(decision);
    }



    public void elegirOpcion(String decision) {
        Casillero casilleroActual = monopoly.obtenerCasilleroActual();
        switch (casilleroActual.getTipoCasillero()) {
            case PROPIEDAD -> this.estadoJuego = EstadoJuego.CAIDA_EN_PROPIEDAD;
            default -> this.estadoJuego = EstadoJuego.TURNO_JUGADOR;
        }
        if (estadoJuego.equals(EstadoJuego.TURNO_JUGADOR)) {
            if (decision.equals("1")) {
                monopoly.avanzar(monopoly.tirarDado());
            } else {
                System.out.println("No podes realizar otra accion antes de moverte");
            }
        }
        if (estadoJuego.equals(EstadoJuego.CAIDA_EN_PROPIEDAD)) {

            ComportamientoCasilla comportamientoCasilla = casilleroActual.getComportamientoCasilla();
            comportamientoCasilla.ejecutarComando(this.monopoly.jugadorEnTurnoActual(), casilleroActual,
                    this.monopoly, this.juegoVista.recibirOpciones());
        }
    /*
        if (!monopoly.jugadorEnTurnoActual().getEstadoJugador().equals(EstadoJugador.ENCARCELADO)) {
            if (decision.equals(Comandos.AVANZAR.getComando()) && !this.monopoly.jugadorEnTurnoActual().obtenerTiroDado()) {
                monopoly.avanzar(monopoly.tirarDado());
                //monopoly.siguienteTurno();
            } else if (decision.equals(Comandos.SIG_TURNO.getComando())) {
                monopoly.siguienteTurno();
            } else {
                System.out.println("Esta accion no existe");
            }
        } if (monopoly.getTablero().getCasillero(monopoly.jugadorEnTurnoActual().getPosicionActual()).getTipoCasillero().equals(TipoCasillero.PROPIEDAD)){
            String nuevaDecision = juegoVista.mostrarOpciones();

            Casillero casilleroActual = monopoly.obtenerCasilleroActual();
            ComportamientoCasilla comportamientoCasilla = casilleroActual.getComportamientoCasilla();
            comportamientoCasilla.ejecutarComando(monopoly.jugadorEnTurnoActual(), casilleroActual, this.monopoly, nuevaDecision);
            CasilleroPropiedad propiedad = (CasilleroPropiedad) monopoly.getTablero().getCasillero(monopoly.jugadorEnTurnoActual().getPosicionActual());

            if (propiedad.getCostoCompra() <= monopoly.jugadorEnTurnoActual().getDineroDisponible() && propiedad.getDueno() == null){
                       /* String decisionProp = recibirInput();
                        if (decisionProp.equals(Comandos.COMPRAR.getComando())) {
                            System.out.println("PROPIEDAD COMPRADA");

                            propiedad.comprar(monopoly.jugadorEnTurnoActual());

                        }


            }

        }
        else {
            if (decision.equals(Comandos.AVANZAR.getComando())) {
                monopoly.pasarTurnoEnCarcel();
            }
        }

        public void elegirOpcionTurnoJugador(String inputUsuario) {
            int dado = 0;
            if (!this.monopoly.jugadorEnTurnoActual().obtenerTiroDado()) {
                if (Objects.equals(inputUsuario, "1")) {
                    dado = this.monopoly.tirarDado();
                    this.monopoly.jugadorEnTurnoActual().cambiarTiroDado();
                }
            }
            if (Objects.equals(inputUsuario, "1")) {
                this.monopoly.avanzar(dado);
            } else {
                System.out.println("No existe esa opcion");
            }
            this.estadoJuego = EstadoJuego.CAIDA_EN_PROPIEDAD;
        }
        */

    }
}
