package org.example.model.use_case;

import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class PagarPeajeUseCase extends OpcionableLibre {

    private Jugador visitante;
    private Propiedad propiedad;
    private double peajeTotal;


    public PagarPeajeUseCase(Jugador propietario, Jugador visitante, Double peaje) {
        super(propietario);
        this.visitante = visitante;
        this.peajeTotal = peaje;
        this.opcionableExtra = "Pagar peaje";
    }

    @Override
    public void ejecutar() {
        this.visitante.pagar(peajeTotal);
        this.jugador.recibirPago(peajeTotal);
    }
}
