package example.model.jugador;

import org.example.model.Dado;
import org.example.model.Logger;
import org.example.model.Posicion;
import org.example.model.casilla.Terreno;
import org.example.model.estado.jugador.Estado;
import org.example.model.estado.jugador.Libre;
import org.example.model.propiedades.AdministradorDePropiedades;
import org.example.model.propiedades.Propiedad;
import org.example.model.use_case.Opcionable;

public class Jugador {

    private Saldo saldo;
    private Posicion posicion;
    private Estado estado;

    private Dado dado;

    private Opcionable opcionable;

    private String nombre;

    private AdministradorDePropiedades administradorDePropiedades;

    public Jugador(Saldo saldo, Dado dado, String nombre) {
        this.saldo = saldo;
        this.nombre = nombre;
        this.administradorDePropiedades = new AdministradorDePropiedades();
        this.dado = dado;
        this.estado = new Libre(this);
        this.posicion = new Posicion(0,0);
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean tieneTransporte() {
        return this.administradorDePropiedades.tieneTransporte();
    }

    public void recibirPago(double monto) {
        this.saldo.recibir(monto);
    }

    public void pagar(double monto) {
        this.saldo.pagar(monto);
    }

    public void pagarFianza(double monto) {
        this.saldo.pagarSinObligacion(monto);
    }

    public void agregarOpcionable (Opcionable opcionable) {
        this.opcionable = opcionable;
    }

    public Opcionable getOpcionable() {
        return this.opcionable;
    }

    public void comprarPropiedad(Propiedad propiedad, double coste) {
        this.saldo.pagarSinObligacion(coste);
        this.saldo.invertir(coste/2);
        Logger.getInstance().info("compra propiedad por " + coste);
        this.administradorDePropiedades.agregarPropiedad(propiedad, this);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void hipotecarPropiedad(Propiedad propiedad) {
        this.administradorDePropiedades.hipotecar(propiedad, this.saldo);
    }

    public void desHipotecar(Terreno propiedad) {
        this.administradorDePropiedades.desHiptecar(propiedad, this.saldo);
    }

    public void venderPropiedad(Propiedad propiedad) {
       this.administradorDePropiedades.venderPropiedad(propiedad, this.saldo);
    }

    public void ejecutarOpcionable() {
        if (this.opcionable != null)
            this.opcionable.ejecutar();
    }

    public void construirCasaEn(Terreno terreno) {
        this.administradorDePropiedades.construirCasaSobre(terreno, this.saldo);
    }

    public void construirHotelEn(Terreno terreno) {
        this.administradorDePropiedades.construirHotelSobre(terreno, this.saldo);
    }

    public double calcularPeajeTerrenos(Propiedad propiedad) {
        return this.administradorDePropiedades.calcularPeajePropiedades(propiedad);
    }

    public int tirarDado() {
        int tirada = this.dado.tirar();
        Logger.getInstance().info("Tira el dado, saca: " + tirada);
        return this.estado.ejecutar(tirada);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void venderHotel(Terreno propiedad) {
        this.administradorDePropiedades.venderHotel(propiedad, this.saldo);
    }

    public void venderCasa(Terreno terreno) {
        this.administradorDePropiedades.venderCasa(terreno, this.saldo);
    }

    public void rematarPropiedades() {
        this.administradorDePropiedades.rematar();
    }

    public void agregarJuegoObserver(JuegoObserver juegoObserver) {
        this.saldo.agregarObserver(juegoObserver);
    }
}
