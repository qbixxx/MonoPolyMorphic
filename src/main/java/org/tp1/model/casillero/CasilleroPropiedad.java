package org.tp1.model.casillero;


import org.tp1.model.Jugador;
import org.tp1.model.comportamiento.ComportamientoCasilla;
import org.tp1.model.comportamiento.ComportamientoPropiedad;
import org.tp1.model.construibles.Casa;
import org.tp1.model.construibles.Edificio;

import java.util.ArrayList;
import java.util.List;

public class CasilleroPropiedad extends Casillero {
    String grupo;
    private final double costoCompra;
    private double renta;
    private double hipoteca;
    private boolean hipotecada;
    private Jugador dueno;
    private List<Edificio> edificios;
    private final int cantidadMaxCasas = 4;

    public CasilleroPropiedad(String nombre, TipoCasillero tipoCasillero, double costoCompra, double renta,
                              String grupo, double valorHipoteca) {
        super(nombre, tipoCasillero);
        this.grupo = grupo;
        this.costoCompra = costoCompra;
        this.renta = renta;
        this.dueno = null;
        this.hipoteca = valorHipoteca;
        this.hipotecada = false;
        this.edificios = new ArrayList<>();
    }
    public boolean estaHipotecada(){
        return this.hipotecada;
    }

    public void hipotecar(){
        this.hipotecada = true;
    }
    public void deshipotecar(){
        this.hipotecada = false;
    }
    public double getHipoteca(){
        return this.hipoteca;
    }
    public String getGrupo() {
        return this.grupo;
    }

    public double getCostoCompra() {
        return this.costoCompra;
    }

    public double getRenta() {
        double valorRealRenta = this.renta;
        if (this.edificios != null) {
            for (Edificio edificio: this.edificios) {
                valorRealRenta += edificio.obtenerPeaje();
            }
        }
        return valorRealRenta;
    }

    public Jugador getDueno() {
        return this.dueno;
    }

    public void comprar(Jugador comprador) {
        this.dueno = comprador;
        comprador.agregarPropiedad(this);
    }

    public void vender(Jugador vendedor) {
        this.dueno = null;
        vendedor.venderPropiedad(this);
    }

    public void pagarRenta(Jugador inquilino) {
        if (this.dueno != null) {
            this.dueno.recibirDinero(inquilino, this.renta);
        }

    }

    public List<Edificio> obtenerEdificios() {
        return this.edificios;
    }

    public void construirCasa() {
        this.edificios.add(new Casa());
    }

    public ComportamientoCasilla getComportamientoCasilla() {
        return new ComportamientoPropiedad();
    }
}