package org.example.configuracion;

import javafx.scene.paint.Color;
import org.example.model.Posicion;
import org.example.model.casilla.*;

import java.util.List;

public class Configuracion {
    public static final double peaje = 100;
    public static final double precioHotel = 5000;
    public static final double precioCasa = 1000;

    public static final double valorMulta = 500;
    public static final double premioLoteria = 100;

    public static final double montoPorRondaCompleta = 1;
    public static final List<Casilla> casillas = List.of(
            new LLegadaPartida(new Posicion(0, 0), new DataCasilla("Llegada\nPartida", Color.WHITE, null)),
            new Multa(new Posicion(0, 1), new DataCasilla("Multa", Color.WHITE, null)),
            new Terreno(new Posicion(0, 2), "Terreno A", new DataCasilla("Manzana 1", Color.MEDIUMSEAGREEN, null),
                    1000),
            new Terreno(new Posicion(0, 3), "Terreno A", new DataCasilla("Manzana 2", Color.MEDIUMSEAGREEN, null),
                    2000),
            new Transporte(new Posicion(0, 4), new DataCasilla("Ferrocaril 1", Color.WHITE, null)),
            new Terreno(new Posicion(0, 5), "Terreno A", new DataCasilla("Manzana 3", Color.MEDIUMSEAGREEN, null),
                    1500),
            new Terreno(new Posicion(0, 6), "Terreno A", new DataCasilla("Manzana 4", Color.MEDIUMSEAGREEN, null), 980),
            new DePaso(new Posicion(0, 7), new DataCasilla("De Paso", Color.WHITE, null)),
            new Terreno(new Posicion(1, 7), "Terreno B", new DataCasilla("Manzana 5", Color.RED, null), 700),
            new Terreno(new Posicion(2, 7), "Terreno B", new DataCasilla("Manzana 6", Color.RED, null), 1200),
            new Transporte(new Posicion(3, 7), new DataCasilla("Ferrocaril 2", Color.WHITE, null)),
            new Terreno(new Posicion(4, 7), "Terreno B", new DataCasilla("Manzana 7", Color.RED, null),1350),
            new Terreno(new Posicion(5, 7), "Terreno B", new DataCasilla("Manzana 8", Color.RED, null), 1400),
            new Carcel(new Posicion(6, 7), new DataCasilla("Carcel", Color.WHITE, null)),
            new Loteria(new Posicion(6, 6), new DataCasilla("Loteria", Color.WHITE, null)),
            new Terreno(new Posicion(6, 5), "Terreno C", new DataCasilla("Manzana 9", Color.ORANGE, null), 1000),
            new Transporte(new Posicion(6, 4), new DataCasilla("Ferrocaril 3", Color.WHITE, null)),
            new Terreno(new Posicion(6, 3), "Terreno C", new DataCasilla("Manzana 10", Color.ORANGE, null), 2500),
            new Terreno(new Posicion(6, 2), "Terreno C", new DataCasilla("Manzana 11", Color.ORANGE, null), 1500),
            new Terreno(new Posicion(6, 1), "Terreno C", new DataCasilla("Manzana 12", Color.ORANGE, null), 1300),
            new Encarcelar(new Posicion(6, 0),  new DataCasilla("Ir a la carcel", Color.WHITE, null)),
            new Terreno(new Posicion(5, 0), "Terreno D", new DataCasilla("Manzana 13", Color.BLUE, null), 1600),
            new Terreno(new Posicion(4, 0), "Terreno D", new DataCasilla("Manzana 14", Color.BLUE, null), 1350),
            new Transporte(new Posicion(3, 0), new DataCasilla("Ferrocaril 4", Color.WHITE, null)),
            new Terreno(new Posicion(2, 0), "Terreno D", new DataCasilla("Manzana 15", Color.BLUE, null), 2000),
            new Terreno(new Posicion(1, 0), "Terreno D", new DataCasilla("Manzana 16", Color.BLUE, null), 780)
    );//factory
}
