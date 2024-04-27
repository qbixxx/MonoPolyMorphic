package org.example.model.casilla;

import org.example.configuracion.Configuracion;
import org.example.configuracion.DataCasilla;
import org.example.model.Logger;
import org.example.model.Posicion;
import org.example.model.Tablero;
import org.example.model.estado.propiedades.Disponibilidad;
import org.example.model.estado.propiedades.EnVenta;
import org.example.model.excepciones.NoHipotecable;
import org.example.model.excepciones.NoSePuedeConstruir;
import org.example.model.excepciones.NoVendible;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;
import org.example.model.propiedades.construibles.Casa;
import org.example.model.propiedades.construibles.Edificio;
import org.example.model.propiedades.construibles.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Terreno extends Casilla implements Propiedad {


    private final double coste;
    private final double peaje = Configuracion.peaje;

    private final double precioCasa = Configuracion.precioCasa;

    private double precioHotel = Configuracion.precioHotel;


    private String grupo;
    private Disponibilidad disponibilidad;
    private List<Edificio> edificios;

    protected boolean sePuedeConstruirHotel;
    protected final int cantidadMaximaDeCasas = 4;

    public Terreno(Posicion posicion, String grupo, DataCasilla dataCasilla, double coste) {
        this.disponibilidad = new EnVenta();
        this.edificios = new ArrayList<>();
        this.dataCasilla = dataCasilla;
        this.sePuedeConstruirHotel = false;
        this.posicion = posicion;
        this.grupo = grupo;
        this.coste = coste;
    }

    @Override
    public void interactuarCon(Jugador jugador, Tablero tablero) {
        this.disponibilidad.interactuarCon(jugador, this, this.coste);
    }

    @Override
    public String getGrupo() {
        return this.grupo;
    }

    @Override
    public void cambiarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public void hipotecar(Saldo saldo) {
        this.disponibilidad.hipotecar();
        if (!this.edificios.isEmpty())
            throw new NoHipotecable();
        saldo.recibir(this.precioCasa/2);
        saldo.desInvertir(this.precioCasa/2);
    }

    @Override
    public void venderPropiedad(Saldo saldo) {
        if (!this.edificios.isEmpty())
            throw new NoVendible();
        this.disponibilidad.venderPropiedad();
        saldo.recibir(this.precioCasa/2);
        saldo.desInvertir(this.precioCasa/2);
    }

    public void venderCasa(Saldo saldo) {
        if (this.edificios.isEmpty() || !(this.edificios.getFirst() instanceof Casa))
            throw new NoVendible();
        this.edificios.removeFirst();
        saldo.recibir(this.precioCasa/2);
        saldo.desInvertir(this.precioCasa/2);
    }

    @Override
    public void desHipotecar(Saldo saldo) {
        this.disponibilidad.desHipotecar(saldo, this.precioCasa/2);
    }

    public void construirCasa(Saldo saldo) {
        this.disponibilidad.construirCasa(); //mejorar espara a lanzar la excepcion
        if (this.edificios.size() >= this.cantidadMaximaDeCasas)
            throw new NoSePuedeConstruir();
        if (!this.edificios.isEmpty() && this.edificios.getFirst() instanceof Hotel)
            throw new NoSePuedeConstruir();
        saldo.pagarSinObligacion(this.precioCasa);
        Logger.getInstance().info("Construye casa");
        this.edificios.add(new Casa());
        saldo.invertir(this.precioCasa/2);
    }

    public List<Edificio> getEdificios() {
        return this.edificios;
    }


    public boolean lePerteneceA(Jugador jugador) {
        return this.disponibilidad.lePerteneceA(jugador);
    }

    public void construirHotel(Saldo saldo) {
        this.disponibilidad.construirCasa();
        if (this.edificios.size() < this.cantidadMaximaDeCasas)
            throw new NoSePuedeConstruir();
        saldo.pagarSinObligacion(this.precioHotel);
        this.edificios = new ArrayList<>(List.of(new Hotel()));
        this.sePuedeConstruirHotel = false;
        saldo.invertir(this.precioHotel);
    }

    @Override
    public double calcularPeaje() {
        double peaje = 0;
        for (Edificio edificio :this.edificios)
            peaje += edificio.getPeaje();
        return this.peaje + peaje;
    }

    @Override
    public void rematar() {
        this.edificios.clear();
        this.sePuedeConstruirHotel = false;
        this.disponibilidad = new EnVenta();
    }

    public void venderHotel(Saldo saldo) {
        if (this.edificios.isEmpty() || !(this.edificios.getFirst() instanceof Hotel))
            throw new NoVendible();
        this.edificios.removeFirst();
        saldo.recibir(this.precioCasa/2);
        saldo.desInvertir(this.precioCasa/2);
    }
}
