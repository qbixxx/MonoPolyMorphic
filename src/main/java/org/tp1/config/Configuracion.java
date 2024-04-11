package org.tp1.config;

import org.tp1.model.Casillero;
import org.tp1.model.Jugador;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Configuracion {
    int montoSalidaLlegada = 200;

    Casillero[] tablero;
    private Casillero[] cargarTableroDesdeJSON(String rutaArchivo) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde el archivo y mapea a un array de objetos Casillero
            return objectMapper.readValue(new File(rutaArchivo), Casillero[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void inicializarTablero() {
        // Cargar el tablero desde el archivo JSON
        String rutaArchivo = "src/main/resources/tablero.json"; // Reemplaza con la ruta correcta
        Casillero[] tablero = cargarTableroDesdeJSON(rutaArchivo);

        // Verificar si la carga del tablero fue exitosa
        if (tablero != null) {
            this.tablero = tablero;
        } else {
            System.err.println("Error al cargar el tablero desde el archivo JSON.");
        }
    }


    //public Casillero[] getTablero() {
     //   return tablero;
    //}


}
