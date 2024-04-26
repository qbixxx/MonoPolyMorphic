package example.model.estado.propiedades;

import org.example.model.Logger;
import org.example.model.excepciones.NoDesHipotecable;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;
import org.example.model.use_case.OpcionableLibre;
import org.example.model.use_case.PagarPeajeUseCase;

public class Disponible implements Disponibilidad {

    private Jugador propietario;

    private Propiedad context;

    public Disponible(Jugador j, Propiedad context) {
        this.propietario = j;
        this.context = context;
    }

    @Override
    public void interactuarCon(Jugador jugador, Propiedad propiedad, double coste) {
        jugador.agregarOpcionable(new OpcionableLibre(jugador));
        if (jugador != this.propietario) {
            Logger.getInstance().info("Estas en la propiedad de " + propietario.getNombre());
            double peajeTotal = this.propietario.calcularPeajeTerrenos(propiedad);
            Logger.getInstance().info("Debes " + peajeTotal);
            if (jugador.tieneTransporte()) {
                peajeTotal = 0;
                Logger.getInstance().info("Pero como tenes transporte, safaste pagas" + peajeTotal);
            }
            jugador.agregarOpcionable(new PagarPeajeUseCase(this.propietario, jugador, peajeTotal));
        }
    }

    @Override
    public void hipotecar() {
        this.context.cambiarDisponibilidad(new Hipotecada(this.context, this.propietario));
    }

    @Override
    public void venderPropiedad() {
        this.context.cambiarDisponibilidad(new EnVenta());
    }

    @Override
    public void desHipotecar(Saldo saldo, double coste) {
        throw new NoDesHipotecable();
    }

    @Override
    public boolean lePerteneceA(Jugador jugador) {
        return this.propietario.equals(jugador);
    }

    @Override
    public void construirCasa() {

    }
}
