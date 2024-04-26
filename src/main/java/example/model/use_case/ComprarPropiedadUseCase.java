package example.model.use_case;

import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class ComprarPropiedadUseCase extends OpcionableLibre {
    public double coste;
    private Propiedad propiedad;

    public ComprarPropiedadUseCase(Jugador j, Propiedad propiedad, double coste) {
        super(j);
        this.coste = coste;
        this.propiedad = propiedad;
        this.opcionableExtra = "Comprar Propiedad";
    }


    @Override
    public void ejecutar() {
        jugador.comprarPropiedad(this.propiedad, this.coste);
    }
}
