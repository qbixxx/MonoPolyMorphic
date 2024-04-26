package example.model;

import org.example.model.jugador.Jugador;

public class Banco {

    private final double montoPorRondaCompleta;

    public Banco(double montoPorRondaCompleta) {
        this.montoPorRondaCompleta = montoPorRondaCompleta;
    }


    public void pagarRondaCompletaA(Jugador jugador) {
        jugador.recibirPago(this.montoPorRondaCompleta);
    }


}
