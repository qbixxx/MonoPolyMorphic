package org.tp1.view;

import org.tp1.model.Jugador;
import org.tp1.model.casillero.CasilleroPropiedad;
import org.tp1.model.casillero.CasilleroTransporte;
import org.tp1.model.juego.Juego;
import org.tp1.model.juego.Tablero;

import java.util.List;
import java.util.Scanner;

public class JuegoVista {
    private final Juego juego;

    public JuegoVista(Juego juego) {
        this.juego = juego;
    }

    public void mostrarDatosJuego() { // modularizar
        TableroVista tableroVista = new TableroVista(juego.getTablero());
        tableroVista.mostrarTablero();
        for (Jugador jugador : juego.getJugadores()) {
            JugadorVista jugadorVista = new JugadorVista(jugador);
            jugadorVista.mostrarJugador();
        }
        Jugador jugadorEnTurno = juego.jugadorEnTurnoActual();
        System.out.println(Colores.RED.getColor() + "------------------------------\n" + Colores.RESET.getColor() + "Turno de: " + Colores.GREEN.getColor() + jugadorEnTurno.getNombre() + Colores.RESET.getColor() + ",\n" + Colores.YELLOW.getColor() + "dinero disponible: " + jugadorEnTurno.getDineroDisponible() + Colores.RESET.getColor() + Colores.RED.getColor() + "\n------------------------------" + Colores.RESET.getColor());
    }

    public void mostrarOpciones() {
        Tablero tablero = juego.getTablero();
        TableroVista tableroVista = new TableroVista(tablero);
        tableroVista.mostrarOpciones(this.juego.jugadorEnTurnoActual());
    }

    public String recibirOpciones() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void mostrarOpcionesGenericas() {
        Tablero tablero = juego.getTablero();
        TableroVista tableroVista = new TableroVista(tablero);
        tableroVista.mostrarOpcionesGenericas(juego.jugadorEnTurnoActual());
    }

    public void mostrarPropiedadesEnPosesion() {
        List<CasilleroPropiedad> propiedades = this.juego.jugadorEnTurnoActual().getPropiedades();
        for (int i = 0; i < propiedades.size(); i++) {
            System.out.println(i + ". " + propiedades.get(i).getNombre());
        }
    }

    public void mostrarTransportesEnPosesion() {
        List<CasilleroTransporte> transportes = this.juego.jugadorEnTurnoActual().obtenerTransportes();
        for (int i = 0; i < transportes.size(); i++) {
            System.out.println(i + ". " + transportes.get(i).getNombre());
        }
    }

    public CasilleroPropiedad elegirPropiedad(String indicePropiedadElegida) {
        int indicePropElegidaEnNum = Integer.parseInt(indicePropiedadElegida);
        return this.juego.jugadorEnTurnoActual().getPropiedades().get(indicePropElegidaEnNum);
    }

    public CasilleroTransporte elegirTransporte(String indiceTransporteElegido) {
        int indiceTransporteElegidoEnNum = Integer.parseInt(indiceTransporteElegido);
        return this.juego.jugadorEnTurnoActual().obtenerTransportes().get(indiceTransporteElegidoEnNum);
    }
}
