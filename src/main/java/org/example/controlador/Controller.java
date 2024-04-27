package org.example.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.example.model.Juego;
import org.example.model.Posicion;
import org.example.model.jugador.Jugador;
import org.example.vista.AlertDialogo;
import org.example.vista.InicioView;
import org.example.vista.TableroView;

public class Controller implements EventHandler<ActionEvent> {

    public Juego juego;

    private TableroView tableroView;

    private Stage stage;

    public Controller(Juego juego, TableroView tableroView, Stage stage) {
        this.juego = juego;
        this.stage = stage;
        this.tableroView = tableroView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            if (this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Ir a la carcel")) {
                Jugador jugadorEnTurno = this.juego.getJugadorEnTurno();
                Posicion vieajPosicion = jugadorEnTurno.getPosicion();
                this.juego.ejecutarOpcionableDelJugadorDeTurno();
                tableroView.actualizarVista(vieajPosicion, jugadorEnTurno);
                this.tableroView.buttonTerminar.setDisable(false);
                this.juego.getJugadorEnTurno().getOpcionable().removerOpcionableExtra();
                this.tableroView.quitarOpcionableExtra();
                this.tableroView.actualizarStatusJugadores();
            } else {
                this.juego.ejecutarOpcionableDelJugadorDeTurno();
                if (this.juego.getJugadorEnTurno().getOpcionable().getOpcionableExtra().equals("Estas Quebrado")) {
                    new AlertDialogo("Estas Quebrado",String.valueOf(this.juego.getJugadorEnTurno().getNombre()) + " \nQuebraste y no podes pagar tus obligaciones");
                    Jugador eliminado = this.juego.getJugadorEnTurno();
                    this.juego.ejecutarOpcionableDelJugadorDeTurno();
                    this.tableroView.eliminarJugadorView(eliminado);
                    this.tableroView.quitarOpcionable();
                    this.tableroView.actualizarStatusJugadores();
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
                    this.tableroView.actualizarStatusJugadores();
                }
            }
        } catch (Exception ex) {
            new AlertDialogo("Error", ex.getMessage());
        }
    }

    public void verificarGanador() {
        this.juego.cambiarTurno();
        if (juego.hayGanador()) {
            new AlertDialogo("Ganador", "Felicidades " + String.valueOf(this.juego.getJugadorEnTurno().getNombre()) + "\nGanaste la partida");
            InicioView inicioView = new InicioView(this.stage, this.juego);
            stage.setScene(inicioView.getScene());
        }
    }
}
