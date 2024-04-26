package example.model.use_case;

import org.example.model.estado.jugador.Libre;
import org.example.model.jugador.Jugador;

import java.util.ArrayList;

public class OpcionablePreso extends Opcionable {


    private final double fianza;
    public OpcionablePreso(Jugador jugador, double fianza) {
        this.jugador = jugador;
        this.fianza = fianza;
        this.opcionables = new ArrayList<>();
        this.opcionableExtra = "Pagar Fianza";
    }
    @Override
    public void ejecutar() {
        this.jugador.pagarFianza(this.fianza);
        this.jugador.setEstado(new Libre(this.jugador));
    }


}
