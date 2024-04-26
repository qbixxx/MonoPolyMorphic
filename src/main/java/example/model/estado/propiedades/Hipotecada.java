package example.model.estado.propiedades;

import org.example.model.excepciones.NoHipotecable;
import org.example.model.excepciones.NoSePuedeConstruir;
import org.example.model.excepciones.NoVendible;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;
import org.example.model.use_case.OpcionableLibre;

public class Hipotecada implements Disponibilidad {

    private Propiedad context;
    private Jugador propietario;

    public Hipotecada(Propiedad context, Jugador propietario) {
        this.context = context;
        this.propietario = propietario;
    }

    @Override
    public void interactuarCon(Jugador jugador, Propiedad propiedad, double coste) {
        jugador.agregarOpcionable(new OpcionableLibre(jugador));
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
        saldo.pagarSinObligacion(coste);
        saldo.invertir(coste);
        this.context.cambiarDisponibilidad(new Disponible(this.propietario, this.context));
    }

    @Override
    public boolean lePerteneceA(Jugador jugador) {
        return this.propietario.getPosicion() == jugador.getPosicion();
    }

    @Override
    public void construirCasa() {
        throw new NoSePuedeConstruir();
    }
}
