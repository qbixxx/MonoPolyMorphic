package org.example.model.use_case;

import org.example.model.jugador.Jugador;

import java.util.List;

public abstract class Opcionable {

    protected Jugador jugador;
    protected String opcionableExtra;
    protected List<String> opcionables;
    abstract public void ejecutar();

    public List<String> getOpcionables() {
        return this.opcionables;
    }

    public String getOpcionableExtra() {
        return this.opcionableExtra;
    }

    public void removerOpcionableExtra() {
        this.opcionableExtra = null;
    }
}
