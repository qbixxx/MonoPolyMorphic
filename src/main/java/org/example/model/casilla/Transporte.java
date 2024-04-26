package org.example.model.casilla;

import org.example.configuracion.DataCasilla;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.estado.propiedades.Disponibilidad;
import org.example.model.estado.propiedades.EnVenta;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;

public class Transporte extends Casilla implements Propiedad {
    private static final double coste = 500;
    private  final double peaje = 50;

    private String grupo;
    private Disponibilidad disponibilidad;

    public Transporte(Posicion posicion, DataCasilla dataCasilla) {
        this.posicion = posicion;
        this.grupo = "Transporte";
        this.dataCasilla = dataCasilla;
        this.disponibilidad = new EnVenta();
    }

    @Override
    public String getGrupo() {
        return this.grupo;
    }
    @Override
    public void interactuarCon(Jugador jugador, Tablero tablero) {
        this.disponibilidad.interactuarCon(jugador, this, coste);
    }

    public boolean lePerteneceA(Jugador jugador) {
        return this.disponibilidad.lePerteneceA(jugador);
    }

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

    @Override
    public void cambiarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public void hipotecar(Saldo saldo) {
        this.disponibilidad.hipotecar();
        saldo.recibir(coste/2);
        saldo.desInvertir(coste/2);
    }

    @Override
    public void venderPropiedad(Saldo saldo) {
        this.disponibilidad.venderPropiedad();
        saldo.recibir(coste/2);
        saldo.desInvertir(coste/2);
    }

    @Override
    public void desHipotecar(Saldo saldo) {
        this.disponibilidad.desHipotecar(saldo,coste/2);
    }

    @Override
    public double calcularPeaje() {
        return this.peaje;
    }

    @Override
    public void rematar() {
        this.disponibilidad = new EnVenta();
    }
}
