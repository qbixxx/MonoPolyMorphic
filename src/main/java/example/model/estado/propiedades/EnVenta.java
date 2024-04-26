package example.model.estado.propiedades;

import org.example.model.Logger;
import org.example.model.excepciones.NoDesHipotecable;
import org.example.model.excepciones.NoHipotecable;
import org.example.model.excepciones.NoSePuedeConstruir;
import org.example.model.excepciones.NoVendible;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;
import org.example.model.use_case.ComprarPropiedadUseCase;

public class EnVenta implements Disponibilidad {

    @Override
    public void interactuarCon(Jugador jugador, Propiedad propiedad, double coste) {
        Logger.getInstance().info("Deseas comprar la propiedad por " + coste);
        jugador.agregarOpcionable(new ComprarPropiedadUseCase(jugador, propiedad, coste));
    }

    public void hipotecar() {
        throw new NoHipotecable();
    }

    @Override
    public void venderPropiedad() {
        throw new NoVendible();
    }

    @Override
    public void desHipotecar(Saldo saldo, double coste) {
        throw new NoDesHipotecable();
    }

    @Override
    public boolean lePerteneceA(Jugador jugador) {
        return false;
    }

    @Override
    public void construirCasa() {
        throw new NoSePuedeConstruir();
    }
}
