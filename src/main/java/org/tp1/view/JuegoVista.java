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
        System.out.println(Color.RED.getColor() + "------------------------------\n" + Color.RESET.getColor() +
                "Turno de: " + jugadorEnTurno.obtenerColor().getColor() +  jugadorEnTurno.obtenerNombre() + Color.RESET.getColor() + ",\n" + Color.YELLOW.getColor() + "dinero disponible: " + jugadorEnTurno.obtenerDineroDisponible() + Color.RESET.getColor() + Color.RED.getColor() + "\n------------------------------" + Color.RESET.getColor());
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
        List<CasilleroPropiedad> propiedades = this.juego.jugadorEnTurnoActual().obtenerPropiedades();
        for (int i = 0; i < propiedades.size(); i++) {
            System.out.println(i + ". " + propiedades.get(i).obtenerNombre());
        }
    }

    public void mostrarTransportesEnPosesion() {
        List<CasilleroTransporte> transportes = this.juego.jugadorEnTurnoActual().obtenerTransportes();
        for (int i = 0; i < transportes.size(); i++) {
            System.out.println(i + ". " + transportes.get(i).obtenerNombre());
        }
    }

    public CasilleroPropiedad elegirPropiedad(String indicePropiedadElegida) {
        int indicePropElegidaEnNum = Integer.parseInt(indicePropiedadElegida);
        return this.juego.jugadorEnTurnoActual().obtenerPropiedades().get(indicePropElegidaEnNum);
    }

    public CasilleroTransporte elegirTransporte(String indiceTransporteElegido) {
        int indiceTransporteElegidoEnNum = Integer.parseInt(indiceTransporteElegido);
        return this.juego.jugadorEnTurnoActual().obtenerTransportes().get(indiceTransporteElegidoEnNum);
    }

    public void mostrarPropiedadesSinHipotecar() {
        List<CasilleroPropiedad> propiedades =  this.juego.jugadorEnTurnoActual().obtenerPropiedades();
        for (int i = 0; i < propiedades.size(); i++) {
            if (!propiedades.get(i).estaHipotecada()) {
                System.out.println(i + ". " + propiedades.get(i).obtenerNombre());
            }
        }
    }
    public void mostrarPropiedadesHipotecadas() {
        List<CasilleroPropiedad> propiedades =  this.juego.jugadorEnTurnoActual().obtenerPropiedades();
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).estaHipotecada()) {
                System.out.println(i + ". " + propiedades.get(i).obtenerNombre());
            }
        }
    }

    public void mostrarPropiedadesDondeConstruir() {
        List<CasilleroPropiedad> propiedades =
                this.juego.getTablero().chequearSiJugadorTieneAlgunGrupo(this.juego.jugadorEnTurnoActual());
        for (int i = 0; i < propiedades.size(); i++) {
            System.out.println(i + ". " + propiedades.get(i).obtenerNombre());
        }
    }

    public CasilleroPropiedad elegirPropiedadDondeConstruir(String indiceProp) {
        int indicePropElegidaEnNum = Integer.parseInt(indiceProp);
        List<CasilleroPropiedad> propiedades =
                this.juego.getTablero().chequearSiJugadorTieneAlgunGrupo(this.juego.jugadorEnTurnoActual());
        return propiedades.get(indicePropElegidaEnNum);
    }

}
