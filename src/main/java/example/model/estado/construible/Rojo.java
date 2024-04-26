package example.model.estado.construible;

import org.example.model.casilla.Terreno;
import org.example.model.excepciones.NoSePuedeConstruir;
import org.example.model.jugador.Saldo;

public class Rojo implements Semaforo{

    @Override
    public void construirCasa(Terreno terreno, Saldo saldo) {
        throw new NoSePuedeConstruir();
    }

    @Override
    public void venderCasa(Terreno terreno, Saldo saldo) {
        terreno.venderCasa(saldo);
    }
}
