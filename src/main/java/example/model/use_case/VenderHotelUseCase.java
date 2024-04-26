package example.model.use_case;

import org.example.model.casilla.Terreno;
import org.example.model.jugador.Jugador;
import org.example.model.propiedades.Propiedad;

public class VenderHotelUseCase extends OpcionableLibre {

    private Propiedad propiedad;
    public VenderHotelUseCase(Jugador jugador, Propiedad propiedad) {
        super(jugador);
        this.propiedad = propiedad;
    }


    @Override
    public void ejecutar() {
        this.jugador.venderHotel((Terreno) this.propiedad);
    }
}