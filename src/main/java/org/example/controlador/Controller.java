package org.example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.model.Juego;
import org.example.model.Posicion;
import org.example.model.jugador.Jugador;
import org.example.vista.AlertDialogo;
import org.example.vista.TableroView;

public class Controller implements EventHandler<ActionEvent> {

    public Juego juego;

    private TableroView tableroView;

    public Controller(Juego juego, TableroView tableroView) {
        this.juego = juego;
        this.tableroView = tableroView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        //try {
        if (this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Ir a la carcel")) {
            Jugador jugadorEnTurno = this.juego.getJugadorEnTurno();
            Posicion vieajPosicion = jugadorEnTurno.getPosicion();
            this.juego.ejecutarOpcionableDelJugadorDeTurno();
            tableroView.actualizarVista(vieajPosicion, jugadorEnTurno);
            this.tableroView.buttonTerminar.setDisable(false);
            this.juego.getJugadorEnTurno().getOpcionable().removerOpcionableExtra();
            this.tableroView.quitarOpcionableExtra();
        } else {
            this.juego.ejecutarOpcionableDelJugadorDeTurno();
            if (this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Estas Quebrado")) {
                new AlertDialogo("Estas Quebrado", "Chau");
                Jugador eliminado = this.juego.getJugadorEnTurno();
                this.juego.ejecutarOpcionableDelJugadorDeTurno();
                this.tableroView.eliminarJugadorView(eliminado);
                this.tableroView.quitarOpcionable();
                this.verificarGanador();
            } else {
                if (this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Pagar peaje")
                        || this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Pagar multa") ||
                        this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Ir a la carcel")
                )
                    this.tableroView.buttonTerminar.setDisable(false);
                this.juego.getJugadorEnTurno().getOpcionable().removerOpcionableExtra();
                this.tableroView.quitarOpcionableExtra();
                this.tableroView.actualizarCasillas(this.juego.getJugadorEnTurno());
                this.tableroView.insertarTexto();
            }
        }
    }

    public void verificarGanador() {
        this.juego.cambiarTurno();
        if (juego.hayGanador()) {
            new AlertDialogo("Ganasta", "Funciona");
            //this.tableroView.getChildren().clear();
        }
    }
}
