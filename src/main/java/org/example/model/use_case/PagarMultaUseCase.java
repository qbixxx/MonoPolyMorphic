package org.example.model.use_case;

import org.example.model.jugador.Jugador;

public class PagarMultaUseCase extends OpcionableLibre {

    private double multa;
    public PagarMultaUseCase(Jugador jugador, double multa) {
        super(jugador);
        this.multa = multa;
        this.opcionableExtra = "Pagar multa";
    }

    @Override
    public void ejecutar() {
        this.jugador.pagar(this.multa);
    }
}
