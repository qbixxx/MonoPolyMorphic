package example.model.estado.propiedades;

import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;

public interface Disponibilidad {

    void interactuarCon(Jugador jugador, Propiedad propiedad, double coste);

    void hipotecar();

    void venderPropiedad();

    void desHipotecar(Saldo saldo, double coste);

    boolean lePerteneceA(Jugador jugador);

    void construirCasa();
}
