package example.model.use_case;

import org.example.model.Juego;

import java.util.ArrayList;

public class OpcionableQuebrado extends Opcionable{

    private final Juego juego;

    public OpcionableQuebrado(Juego juego) {
        this.juego = juego;
        this.opcionables = new ArrayList<>();
        this.opcionableExtra = "Estas Quebrado";

    }
    @Override
    public void ejecutar() {
        juego.eliminarJugadorQuebrado();
    }
}
