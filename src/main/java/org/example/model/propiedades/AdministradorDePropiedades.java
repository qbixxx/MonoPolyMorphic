package org.example.model.propiedades;

import org.example.model.Posicion;
import org.example.model.casilla.Terreno;
import org.example.model.casilla.Transporte;
import org.example.model.estado.construible.Rojo;
import org.example.model.estado.construible.Semaforo;
import org.example.model.estado.construible.Verde;
import org.example.model.estado.propiedades.Disponible;
import org.example.model.excepciones.NoSePuedeConstruir;
import org.example.model.excepciones.PropiedadNoPerteneceAJugador;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;

import java.util.*;

public class AdministradorDePropiedades {

    private HashMap<List<Propiedad>, List<Semaforo>> propiedades;

    private final int cantidadMaxDePropiedadPorGrupo = 4;

    private boolean romperReglasDeCantidadDeCasasPorCasilla;

    public AdministradorDePropiedades() {
        this.romperReglasDeCantidadDeCasasPorCasilla = false;
        this.propiedades = new HashMap<>();
    }

    private boolean propiedadesContieneElTipoDe(Propiedad propiedad) {
        return propiedades.entrySet().stream()
                .anyMatch(entry -> Objects.equals(entry.getKey().get(0).getGrupo(), propiedad.getGrupo()));
    }


    private List<Propiedad> obtenerYVerificarQuePropiedadesContieneA(Propiedad propiedad) {
        return propiedades.entrySet().stream()
                .filter(entry -> entry.getKey().contains(propiedad))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(PropiedadNoPerteneceAJugador::new);
    }

    private List<Propiedad> obtenerListaQueContieneAlTipoDe(Propiedad propiedad) {
        return propiedades.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getKey().get(0).getGrupo(), propiedad.getGrupo()))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(PropiedadNoPerteneceAJugador::new);
    }

    public void agregarPropiedad(Propiedad propiedad, Jugador jugador) {
        if (this.propiedadesContieneElTipoDe(propiedad)) {
            List<Propiedad> terrenos = this.obtenerListaQueContieneAlTipoDe(propiedad);
            terrenos.add(propiedad);
            this.propiedades.put(terrenos, new ArrayList<>(Collections.nCopies(terrenos.size(), new Verde())));
        } else {
            List<Propiedad> nuevoGrupo = new ArrayList<>(List.of(propiedad));
            this.propiedades.put(nuevoGrupo, new ArrayList<>(List.of(new Verde())));
        }
        propiedad.cambiarDisponibilidad(new Disponible(jugador, propiedad));
    }
    public void construirCasaSobre(Terreno terreno, Saldo saldo) {
        List<Propiedad> propiedades = this.obtenerYVerificarQuePropiedadesContieneA(terreno);
        List<Semaforo> semaforos = this.propiedades.get(propiedades);
        if (propiedades.size() < this.cantidadMaxDePropiedadPorGrupo) throw new NoSePuedeConstruir();
        boolean todosRojos = semaforos.stream().allMatch(s -> s instanceof Rojo);
        if (todosRojos) semaforos.replaceAll(s -> new Verde());
        if (!this.romperReglasDeCantidadDeCasasPorCasilla) {
            int posicionTerreno = propiedades.indexOf(terreno);
            semaforos.get(posicionTerreno).construirCasa(terreno, saldo);
            semaforos.set(posicionTerreno, new Rojo());
        }
        else
            terreno.construirCasa(saldo);
    }

    public void venderCasa(Terreno terreno, Saldo saldo) {
        List<Propiedad> propiedades = this.obtenerYVerificarQuePropiedadesContieneA(terreno);
        List<Semaforo> semaforos = this.propiedades.get(propiedades);
        boolean todosVerdes = semaforos.stream().allMatch(s -> s instanceof Verde);
        if (todosVerdes) semaforos.replaceAll(s -> new Rojo());
        if (!this.romperReglasDeCantidadDeCasasPorCasilla) {
            int posicionTerreno = propiedades.indexOf(terreno);
            semaforos.get(posicionTerreno).venderCasa(terreno, saldo);
            semaforos.set(posicionTerreno, new Verde());
        }
        else
            terreno.venderCasa(saldo);
    }

    public void venderPropiedad(Propiedad propiedad, Saldo saldo) {
        List<Propiedad> propiedadesVendibles = this.obtenerYVerificarQuePropiedadesContieneA(propiedad);
        List<Semaforo> semaforos = this.propiedades.get(propiedadesVendibles);
        int posicionTerreno = propiedadesVendibles.indexOf(propiedad);
        propiedad.venderPropiedad(saldo);
        propiedadesVendibles.remove(propiedad);
        semaforos.remove(posicionTerreno);
        this.propiedades.entrySet().removeIf(entry -> entry.getKey().isEmpty());
    }
    public boolean tieneTransporte() {
        return this.propiedadesContieneElTipoDe(new Transporte(new Posicion(0, 0), null));
    }

    public double calcularPeajePropiedades(Propiedad propiedad) {
        List<Propiedad> propiedades = this.obtenerYVerificarQuePropiedadesContieneA(propiedad);
        if (propiedad instanceof Transporte)
            return propiedades.size() * propiedad.calcularPeaje();
        return propiedad.calcularPeaje();
    }

    public void hipotecar(Propiedad propiedad, Saldo saldo) {
        this.obtenerYVerificarQuePropiedadesContieneA(propiedad);
        propiedad.hipotecar(saldo);
    }

    public void desHiptecar(Propiedad propiedad, Saldo saldo) {
        this.obtenerYVerificarQuePropiedadesContieneA(propiedad);
        propiedad.desHipotecar(saldo);
    }

    public void construirHotelSobre(Terreno terreno, Saldo saldo) {
        this.obtenerYVerificarQuePropiedadesContieneA(terreno);
        terreno.construirHotel(saldo);
        this.romperReglasDeCantidadDeCasasPorCasilla = true;
    }

    public void venderHotel(Terreno terreno, Saldo saldo) {
        this.obtenerYVerificarQuePropiedadesContieneA(terreno);
        terreno.venderHotel(saldo);
    }

    public void rematar() {
        this.propiedades.keySet().forEach(listaPropiedades -> {
            listaPropiedades.forEach(Propiedad::rematar);
        });
    }

}