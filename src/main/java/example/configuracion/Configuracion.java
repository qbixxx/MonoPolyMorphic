package example.configuracion;

import example.model.casilla.LLegadaPartida;
import javafx.scene.paint.Color;
import org.example.model.Posicion;
import org.example.model.casilla.*;

import java.util.List;

public class Configuracion {


    public static final List<Casilla> casillas = List.of(
            new LLegadaPartida(new Posicion(0, 0), new DataCasilla("Llegada\nPartida", Color.WHITE, null)),
            new Multa(new Posicion(0, 1), new DataCasilla("Multa", Color.WHITE, null)),
            new Terreno(new Posicion(0, 2), "Terreno A", new DataCasilla("Manzana 1", Color.MEDIUMSEAGREEN, null)),
            new Terreno(new Posicion(0, 3), "Terreno A", new DataCasilla("Manzana 2", Color.MEDIUMSEAGREEN, null)),
            new Transporte(new Posicion(0, 4), new DataCasilla("Ferrocaril 1", Color.WHITE, null)),
            new Terreno(new Posicion(0, 5), "Terreno A", new DataCasilla("Manzana 3", Color.MEDIUMSEAGREEN, null)),
            new Terreno(new Posicion(0, 6), "Terreno A", new DataCasilla("Manzana 4", Color.MEDIUMSEAGREEN, null)),
            new DePaso(new Posicion(0, 7), new DataCasilla("De Paso", Color.WHITE, null)),
            new Terreno(new Posicion(1, 7), "Terreno B", new DataCasilla("Manzana 5", Color.RED, null)),
            new Terreno(new Posicion(2, 7), "Terreno B", new DataCasilla("Manzana 6", Color.RED, null)),
            new Transporte(new Posicion(3, 7), new DataCasilla("Ferrocaril 2", Color.WHITE, null)),
            new Terreno(new Posicion(4, 7), "Terreno B", new DataCasilla("Manzana 7", Color.RED, null)),
            new Terreno(new Posicion(5, 7), "Terreno B", new DataCasilla("Manzana 8", Color.RED, null)),
            new Carcel(new Posicion(6, 7), new DataCasilla("Carcel", Color.WHITE, null)),
            new Loteria(new Posicion(6, 6), new DataCasilla("Loteria", Color.WHITE, null)),
            new Terreno(new Posicion(6, 5), "Terreno C", new DataCasilla("Manzana 9", Color.ORANGE, null)),
            new Transporte(new Posicion(6, 4), new DataCasilla("Ferrocaril 3", Color.WHITE, null)),
            new Terreno(new Posicion(6, 3), "Terreno C", new DataCasilla("Manzana 10", Color.ORANGE, null)),
            new Terreno(new Posicion(6, 2), "Terreno C", new DataCasilla("Manzana 11", Color.ORANGE, null)),
            new Terreno(new Posicion(6, 1), "Terreno C", new DataCasilla("Manzana 12", Color.ORANGE, null)),
            new Encarcelar(new Posicion(6, 0),  new DataCasilla("Ir a la carcel", Color.WHITE, null)),
            new Terreno(new Posicion(5, 0), "Terreno D", new DataCasilla("Manzana 13", Color.BLUE, null)),
            new Terreno(new Posicion(4, 0), "Terreno D", new DataCasilla("Manzana 14", Color.BLUE, null)),
            new Transporte(new Posicion(3, 0), new DataCasilla("Ferrocaril 4", Color.WHITE, null)),
            new Terreno(new Posicion(2, 0), "Terreno D", new DataCasilla("Manzana 15", Color.BLUE, null)),
            new Terreno(new Posicion(1, 0), "Terreno D", new DataCasilla("Manzana 16", Color.BLUE, null))
    );//factory
}
