package org.example.model.use_case;

import org.example.model.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class OpcionableLibre extends Opcionable {
    public OpcionableLibre(Jugador jugador) {
        this.jugador = jugador;
        this.opcionables = new ArrayList<>(
                List.of("Construir Casa", "Construir Hotel", "Vender Casa", "Vender Hotel", "Vender Propiedad", "Hipotecar", "DesHipotecar"));
    }

    @Override
    public void ejecutar() {

    }
}
