package org.tp1.controller;

import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.juego.estadoJugador.EstadoJugador;
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
            if (!jugador.getEstadoJugador().equals(EstadoJugador.EN_QUIEBRA)) {
                numJugadoresEnJuego++;
            }
        }
        return numJugadoresEnJuego >= 2;
    }

    public void jugarTurno() {
        juegoVista.mostrarDatosJuego();
        juegoVista.mostrarOpciones();
        String decision = juegoVista.recibirOpciones();
        if (decision.equals("2")) {
            this.monopoly.jugadorEnTurnoActual().cambiarSiTiroDado();
            monopoly.siguienteTurno();
        }
        if (decision.equals("5")) {
            System.out.println("A vender una propiedad!");
            this.juegoVista.mostrarPropiedadesEnPosesion();
            String indicePropiedadElegida = this.juegoVista.recibirOpciones();
            CasilleroPropiedad propiedadElegida = this.juegoVista.elegirPropiedad(indicePropiedadElegida);
            this.monopoly.venderPropiedad(propiedadElegida);

        }
        this.estadoJuego = EstadoJuego.TURNO_JUGADOR;
        elegirOpcion(decision);
    }

    public void repetirTurno() {
        juegoVista.mostrarDatosJuego();
        juegoVista.mostrarOpcionesGenericas();
        String decision = juegoVista.recibirOpciones();
        if (decision.equals("2")) {
            this.monopoly.jugadorEnTurnoActual().cambiarSiTiroDado();
            monopoly.siguienteTurno();
        }
        if (decision.equals("5")) {
            this.juegoVista.mostrarPropiedadesEnPosesion();
            String indicePropiedadElegida = this.juegoVista.recibirOpciones();
            CasilleroPropiedad propiedadElegida = this.juegoVista.elegirPropiedad(indicePropiedadElegida);
            this.monopoly.venderPropiedad(propiedadElegida);

        }
        if (decision.equals("6")) {
            this.juegoVista.mostrarTransportesEnPosesion();
            String indiceTransporteElegido = this.juegoVista.recibirOpciones();
            CasilleroTransporte transporteElegido = this.juegoVista.elegirTransporte(indiceTransporteElegido);
            this.monopoly.venderTransporte(transporteElegido);
        }
        this.estadoJuego = EstadoJuego.TURNO_JUGADOR;
        elegirOpcion(decision);
    }

    public void chequearEstadoJuego(Casillero casillero) {
        switch (casillero.getTipoCasillero()) {
            case PROPIEDAD -> this.estadoJuego = EstadoJuego.CAIDA_EN_PROPIEDAD;
            case TRANSPORTE -> this.estadoJuego = EstadoJuego.CAIDA_EN_TRANSPORTE;
            case LOTERIA, MULTA, DE_PASO -> this.estadoJuego = EstadoJuego.CAIDA_PASO_MULTA_LOT;
            case CARCEL, IR_A_CARCEL -> this.estadoJuego = EstadoJuego.CAIDA_IR_A_CARCEL;
            default -> this.estadoJuego = EstadoJuego.TURNO_JUGADOR;
        }
    }

    public void elegirOpcion(String decision) {
        Casillero casilleroActual = monopoly.obtenerCasilleroActual();
        ComportamientoCasilla comportamientoCasilla = casilleroActual.getComportamientoCasilla();
        System.out.println("Si tiro dado es " + this.monopoly.jugadorEnTurnoActual().siTiroDado());
        if (this.monopoly.jugadorEnTurnoActual().siTiroDado()) {
            chequearEstadoJuego(casilleroActual);
        }
        if (estadoJuego.equals(EstadoJuego.TURNO_JUGADOR)) {
            if (decision.equals("1")) {
                this.monopoly.jugadorEnTurnoActual().cambiarSiTiroDado();
                monopoly.avanzar(monopoly.tirarDado());
            } else {
                System.out.println("No podes realizar otra accion antes de moverte");
            }
        }
        if (estadoJuego.equals(EstadoJuego.CAIDA_EN_PROPIEDAD)) {
            String respuesta = comportamientoCasilla.ejecutarComando(this.monopoly.jugadorEnTurnoActual(),
                    casilleroActual,
                    this.monopoly, decision);
            repetirTurno();

        }
        if (estadoJuego.equals(EstadoJuego.CAIDA_EN_TRANSPORTE)) {
            comportamientoCasilla.ejecutarComando(this.monopoly.jugadorEnTurnoActual(), casilleroActual,
                    this.monopoly, decision);
            repetirTurno();
        }
        if (estadoJuego.equals(EstadoJuego.CAIDA_IR_A_CARCEL)) {
            jugarTurno();
        }
    }

}
