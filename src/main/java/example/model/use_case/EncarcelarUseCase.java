package example.model.use_case;

import org.example.model.Logger;
import org.example.model.Tablero;
import org.example.model.estado.jugador.Preso;
import org.example.model.jugador.Jugador;

import java.util.ArrayList;

public class EncarcelarUseCase extends Opcionable {
    private Tablero tablero;

    public EncarcelarUseCase(Jugador jugador, Tablero tablero) {
        this.jugador = jugador;
        this.tablero = tablero;
        this.opcionables = new ArrayList<>();
        this.opcionableExtra = "Ir a la carcel";
    }

    @Override
    public void ejecutar() {
        Logger.getInstance().info("Encarcelar");
        jugador.setEstado(new Preso(jugador));
        tablero.moverACarcel(jugador);
    }
}
