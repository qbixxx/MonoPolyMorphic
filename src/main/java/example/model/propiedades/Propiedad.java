package example.model.propiedades;

import org.example.model.estado.propiedades.Disponibilidad;
import org.example.model.jugador.Saldo;

public interface Propiedad {

    String getGrupo();

    void cambiarDisponibilidad(Disponibilidad disponibilidad);
    void hipotecar(Saldo saldo);
    void venderPropiedad(Saldo saldo);

    void desHipotecar(Saldo saldo);

    double calcularPeaje();

    void rematar();
}
