package org.example;

import org.example.model.*;
import org.example.model.casilla.*;
import org.example.model.excepciones.NoHipotecable;
import org.example.model.excepciones.NoSePuedeConstruir;
import org.example.model.excepciones.NoVendible;
import org.example.model.excepciones.SaldoNoDisponible;
import org.example.model.jugador.Jugador;
import org.example.model.jugador.Saldo;
import org.example.model.propiedades.Propiedad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JuegoIntegracionTest {

    private Dado dadoMock;
    private Logger loggerMock;

    @BeforeEach
    public void beforeEach() {
        dadoMock = mock(Dado.class);
        loggerMock = mock(Logger.class);
        new Logger(loggerMock);

    }
    @Test
    public void test01ElBancoLePagaAlJugadorRondaCompleta() {

        //Arrange
        Saldo saldo = new Saldo(2000);
        Jugador jugador = new Jugador(saldo, new Dado(), "Pepito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Banco banco = new Banco(2000);

        //Act
        banco.pagarRondaCompletaA(jugador);
        jugador.comprarPropiedad(propiedadDePrueba, 4000);

        //Assert
        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(propiedadDePrueba, 1));
    }

    @Test
    public void test02AlIniciarLaPartidaElBancoLePagaAlJugadorElMontoDeRondaCompleta() {
        //Arrange
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Banco banco = new Banco(2000);
        Juego juego = new Juego();
        Terreno terreno = new Terreno(new Posicion(0,0), "Terrero A", null);

        //Act
        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(terreno, 1));
        banco.pagarRondaCompletaA(jugador);


        //Assert
        assertDoesNotThrow(() -> jugador.comprarPropiedad(terreno, 2000));

    }

    @Test
    public void test03JugadorSaleDeLaCasillaInicial() {

        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Banco banco = new Banco(2000);
        Terreno terreno = new Terreno(new Posicion(0,4), "Terreno A", null);
        Tablero tablero = new Tablero(
                List.of(new DePaso(new Posicion(0, 0), null),
                        new Loteria(new Posicion(0, 1), null),
                        new Loteria(new Posicion(0, 2), null)
                ),
                List.of(jugador), banco
        );

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(terreno, 100));
        tablero.mover(jugador, 1); //recibe 100 de loteria

        assertDoesNotThrow(() -> jugador.comprarPropiedad(terreno, 100));
    }

    @Test
    public void test04CuandoJugadorAterrizaEnCasillaLoteriaCobra() {

        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Casilla loteria = new Loteria(new Posicion(0, 0), null);

        loteria.interactuarCon(jugador, null);

        assertDoesNotThrow(() -> jugador.comprarPropiedad(new Transporte(new Posicion(0,0), null), 100));
    }


    @Test
    public void test05CuandoUnJugadorAterrizaEnCasillaMultaDebePagar() {

        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(500), new Dado(), "Pepito");
        Tablero tablero = new Tablero(
                List.of(
                    new Multa(new Posicion(0,0), null),
                    new Multa(new Posicion(0,1), null),
                    new Multa(new Posicion(0,2), null)
                ),
                List.of(jugador), banco);

        tablero.mover(jugador, 2);
        jugador.ejecutarOpcionable();

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(new Transporte(new Posicion(0,0), null), 1));
    }

    @Test
    public void test06CuandoUnJugadorAterrizaEnCasillaDeCarcelVaALaCarcel() {

        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new Encarcelar(new Posicion(0,1), null),
                        new Carcel(new Posicion(10,10), null))
                , List.of(jugador), banco);

        tablero.mover(jugador, 1);
        jugador.ejecutarOpcionable();

        verify(loggerMock).info("Encarcelar");
    }

    @Test
    public void test061UnJugadorEncarceladoTiraElDadoYSacaUnNumeroMayorALaCantidadDeTurnosCondenadoEsLiberado() {

        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(0), dadoMock, "Pepito");
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new Encarcelar(new Posicion(0,1), null),
                        new Carcel(new Posicion(10,10), null))
                , List.of(jugador), banco);

        tablero.mover(jugador, 1);
        jugador.ejecutarOpcionable();

        verify(loggerMock).info("Encarcelar");
        when(dadoMock.tirar()).thenReturn(1);
        jugador.tirarDado();
        assertEquals(0, jugador.tirarDado());
        when(dadoMock.tirar()).thenReturn(50);
        assertEquals(0, jugador.tirarDado());
        verify(loggerMock).info("Es libre");
    }

    @Test
    public void test07CuandoJugadorPasaPorCasillaInicioLLegadaCobraDinero() {

        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new DePaso(new Posicion(0, 1), null),
                        new DePaso(new Posicion(0,2), null)
                ),
                List.of(jugador), banco);

        tablero.mover(jugador, 4);

        assertDoesNotThrow(() -> jugador.comprarPropiedad(new Transporte(new Posicion(0,4), null), 2000));
    }

    @Test
    public void test08JugadorPasaPorCasillaInicioLLegadaYCaeEnCasillaLoteriaCobra2500() {

        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new DePaso(new Posicion(0,0), null),
                        new Loteria(new Posicion(0,0), null)
                ),
                List.of(jugador), banco);

        tablero.mover(jugador, 5);


        assertDoesNotThrow(() -> jugador.comprarPropiedad(new Transporte(new Posicion(0,0), null), 2500));
    }

    @Test
    public void test09JugadorCompraTransporteCuandoCaeEnCasillaDeTransporte() {

        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Propiedad transporte = new Transporte(new Posicion(0,0), null);

        jugador.recibirPago(2000.0);
        jugador.comprarPropiedad(transporte, 500);

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(transporte, 1501));
    }

    @Test
    public void test10JugadorCaeEnCasillaDeTransportePropiedadDeOtroJugadorYDebePajarPeaje() {

        Banco banco = new Banco(2000);
        Jugador propietario = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Juancito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Casilla transporte = new Transporte(new Posicion(0,0), null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new DePaso(new Posicion(0,0), null),
                        transporte),
                List.of(jugador, propietario), banco);

        jugador.recibirPago(2000.0);
        propietario.recibirPago(2000.0);
        tablero.mover(propietario, 2);
        propietario.ejecutarOpcionable();//compra la propiedad
        tablero.mover(jugador, 2);
        jugador.ejecutarOpcionable();//paga el peaje

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(propiedadDePrueba, 1951));
        assertDoesNotThrow(() -> jugador.comprarPropiedad(propiedadDePrueba, 1950));

    }

    @Test
    public void test11JugadorCaeEnCasillaDeTransportePropiaYNoDebePagarPeaje() {

        Banco banco = new Banco(2000);
        Jugador propietario = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Casilla transporte = new Transporte(new Posicion(0, 0), null);
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new DePaso(new Posicion(0,0), null),
                        transporte
                ),
                List.of(propietario), banco);

        banco.pagarRondaCompletaA(propietario);
        propietario.comprarPropiedad((Propiedad) transporte, 1000);
        tablero.mover(propietario, 2);
        propietario.ejecutarOpcionable();

        assertThrows(SaldoNoDisponible.class, () -> propietario.comprarPropiedad(propiedadDePrueba, 1001));
        assertDoesNotThrow(() -> propietario.comprarPropiedad(propiedadDePrueba, 1000));

    }

    @Test
    public void test12JugadorAterrizaEnCasillaTransporteDebePagarPeajePorCadaTransporteDelPropietario() {

        Banco banco = new Banco(2000);
        Jugador propietario = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Juancito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Casilla transporte1 = new Transporte(new Posicion(0,1), null);
        Casilla transporte2 = new Transporte(new Posicion(0, 2), null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        transporte1,
                        transporte2
                ), List.of(jugador, propietario), banco);

        banco.pagarRondaCompletaA(jugador);
        banco.pagarRondaCompletaA(propietario);
        transporte1.interactuarCon(propietario, tablero);
        propietario.ejecutarOpcionable();
        transporte2.interactuarCon(propietario, tablero);
        propietario.ejecutarOpcionable();
        tablero.mover(jugador, 2);
        jugador.ejecutarOpcionable();

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(propiedadDePrueba, 1901));
        assertDoesNotThrow(() -> jugador.comprarPropiedad(propiedadDePrueba, 1900));
    }

    @Test
    public void test13JugadorAterrizaEnCasillaTransporteNoDebePagarPeajePorQueTambienEsPropietarioDeOtroTransporte() {

        Banco banco = new Banco(2000);
        Jugador propietario1 = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Jugador propietario2 = new Jugador(new Saldo(0), new Dado(), "Juancito");
        Casilla transporte1 = new Transporte(new Posicion(0,1), null);
        Casilla transporte2 = new Transporte(new Posicion(0,2), null);
        Casilla inicial = new LLegadaPartida(new Posicion(0,3), null);
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Tablero tablero = new Tablero(List.of(inicial, transporte1, transporte2), List.of(propietario1, propietario2), banco);

        propietario1.recibirPago(2000.0);
        propietario2.recibirPago(2000.0);
        tablero.mover(propietario1, 1);
        propietario1.ejecutarOpcionable();
        tablero.mover(propietario2, 2);
        propietario2.ejecutarOpcionable();
        tablero.mover(propietario1, 1);
        propietario1.ejecutarOpcionable();

        assertThrows(SaldoNoDisponible.class, () -> propietario1.comprarPropiedad(propiedadDePrueba, 1501));
        assertDoesNotThrow(() -> propietario1.comprarPropiedad(propiedadDePrueba, 1500));
    }


    @Test
    public void test14JugadorCompraPropiedadCuandoCaeEnCasillaPropiedad() {

        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new DePaso(new Posicion(0,0), null),
                        new Terreno(new Posicion(0,0), "TerrenoA", null))
                , List.of(jugador), banco);

        banco.pagarRondaCompletaA(jugador);
        tablero.mover(jugador, 2);
        jugador.ejecutarOpcionable();

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(propiedadDePrueba, 1001));
        assertDoesNotThrow(() -> jugador.comprarPropiedad(propiedadDePrueba, 1000));
    }


    @Test
    public void test15JugadorCaeEnCasillaPropiedadDeOtroJugadorYDebePagarPeaje() {

        Banco banco = new Banco(2000);
        Jugador propietario = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Juancito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new Terreno(new Posicion(0,1), "TerrenoA", null)),
                List.of(propietario, jugador), banco);

        banco.pagarRondaCompletaA(jugador);
        banco.pagarRondaCompletaA(propietario);
        tablero.mover(propietario, 1);
        propietario.ejecutarOpcionable(); // compra la propiedad
        tablero.mover(jugador, 1); //cae en casilla comprada
        jugador.ejecutarOpcionable(); //paga el peaje

        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(propiedadDePrueba, 1901));
        assertDoesNotThrow(() -> jugador.comprarPropiedad(propiedadDePrueba, 1900));
    }

    @Test
    public void test16JugadorAdquiereSoloUnTerrenoNoPuedeConstruirYLanzaUnaExcepcion() {

        Banco banco = new Banco(4000);
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Terreno terreno = new Terreno(new Posicion(0,0), "TerreoA", null);

        banco.pagarRondaCompletaA(jugador);
        jugador.comprarPropiedad(terreno, 2000);

        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirCasaEn(terreno));
    }

    @Test
    public void test17JugadorConGrupoCompletoDePropiedadesPuedeConstruirCasa() {

        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "Terreno A", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "Terreno A", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "Terreno A", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "Terreno A", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirCasaEn(terrenoA1));
        jugador.comprarPropiedad(terrenoA4, 0);

        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA1));
    }

    @Test
    public void test18JugadorConGrupoCompletoDePropiedadesNoPuedeConstruir2CasasEnSoloUnTerreno() {

        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        jugador.comprarPropiedad(terrenoA4, 0);

        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA1));
        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirCasaEn(terrenoA1));
        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA2));
    }

    @Test
    public void test19LaDiferenciaEntreCantidadDeCasasPorTerrenoAgrupableNoPuedeSerMayorA1() {

        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        jugador.comprarPropiedad(terrenoA4, 0);

        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA1));
        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirCasaEn(terrenoA1));//no puede construir sobre el mismo terreno

        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA2));// debe construir al menos una casa en cada terreno
        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA3));
        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA4));

        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA1)); //al final debe poder construir en terreno1

    }

    @Test
    public void test20ConstruirUnEdificioSobreUnTerrenoSiAntesConstruirTodasLasCasasNoLanzaraUnaExcepcion() {

        Jugador jugador = new Jugador(new Saldo(100000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        jugador.comprarPropiedad(terrenoA4, 0);

        jugador.construirCasaEn(terrenoA1);
        jugador.construirCasaEn(terrenoA2);
        jugador.construirCasaEn(terrenoA3);
        jugador.construirCasaEn(terrenoA4);

        jugador.construirCasaEn(terrenoA1);
        jugador.construirCasaEn(terrenoA2);
        jugador.construirCasaEn(terrenoA3);
        jugador.construirCasaEn(terrenoA4);

        jugador.construirCasaEn(terrenoA1);
        jugador.construirCasaEn(terrenoA2);
        jugador.construirCasaEn(terrenoA3);
        jugador.construirCasaEn(terrenoA4);

        jugador.construirCasaEn(terrenoA1);
        jugador.construirCasaEn(terrenoA2);
        jugador.construirCasaEn(terrenoA3);
        jugador.construirCasaEn(terrenoA4);

        assertDoesNotThrow(() -> jugador.construirHotelEn(terrenoA1));
    }

    @Test
    public void test21ConstruirUnEdificioSobreUnTerrenoSinAntesConstruirTodasLasCasasLanzaraUnaExcepcion() {

        Jugador jugador = new Jugador(new Saldo(100000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        jugador.comprarPropiedad(terrenoA4, 0);

        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirHotelEn(terrenoA1));
    }

    @Test
    public void test22JugadorCaeEnCasillaPropiedadDeOtroJugadorQueTiene4CasasYDebePagarPeaje() {

        Banco banco = new Banco(2000);
        Jugador propietario = new Jugador(new Saldo(0), new Dado(), "Pepito");
        Jugador jugador = new Jugador(new Saldo(0), new Dado(), "Juancito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Terreno propiedad = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        propiedad
                ), List.of(propietario, jugador), banco);

        banco.pagarRondaCompletaA(jugador);
        banco.pagarRondaCompletaA(propietario);
        propietario.comprarPropiedad(propiedad, 2000);
        propiedad.construirCasa(new Saldo(10000));
        propiedad.construirCasa(new Saldo(10000));
        propiedad.construirCasa(new Saldo(10000));
        propiedad.construirCasa(new Saldo(10000));

        tablero.mover(jugador, 1); //cae en casilla comprada
        jugador.ejecutarOpcionable();
        assertThrows(SaldoNoDisponible.class, () -> jugador.comprarPropiedad(propiedadDePrueba, 1101));
        assertDoesNotThrow(() -> jugador.comprarPropiedad(propiedadDePrueba, 1100));
    }

    @Test
    public void test24JugadorCompraYVendePropiedad() {
        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Propiedad propiedad = new Terreno(new Posicion(0, 0), "Terreno A", null);

        jugador.comprarPropiedad(propiedad, 2000);
        jugador.venderPropiedad(propiedad);

        assertDoesNotThrow(() -> jugador.comprarPropiedad(propiedad, 2000));

    }

    @Test
    public void test25JugadorHipotecaYDesHipotecaPropiedad() {
        Jugador jugador = new Jugador(new Saldo(10000), new Dado(), "Pepito");
        Propiedad propiedad = new Terreno(new Posicion(0, 0), "Terreno A", null);

        jugador.comprarPropiedad(propiedad, 2000);
        jugador.hipotecarPropiedad(propiedad);

        assertThrows(NoHipotecable.class, () -> jugador.hipotecarPropiedad(propiedad));

    }

    @Test
    public void test26JugadorConPropiedadHipotecadaNoPuedeConstruir() {

        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        jugador.comprarPropiedad(terrenoA4, 0);

        jugador.hipotecarPropiedad(terrenoA1);

        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirCasaEn(terrenoA1));
        jugador.desHipotecar(terrenoA1);
        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA1)); //gasta
        assertDoesNotThrow(() -> jugador.construirCasaEn(terrenoA2)); //verificar que el saldo justo
        assertThrows(SaldoNoDisponible.class, () -> jugador.construirCasaEn(terrenoA3)); //verificar que el saldo justo
    }

    @Test
    public void test27JugadorConPropiedadHipotecadaNoLaPuedeVenderYlanzaUnaExcepcion() {
        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.hipotecarPropiedad(terrenoA1);

        assertThrows(NoVendible.class, () -> jugador.venderPropiedad(terrenoA1));
    }

    @Test
    public void test28JugadorConPropiedadHipotecadaNoPuedeConstruir() {

        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.hipotecarPropiedad(terrenoA1);

        assertThrows(NoSePuedeConstruir.class, () -> jugador.construirCasaEn(terrenoA1));
    }

    @Test
    public void test29JugadorCompraPropiedadYLaHipotecaYLuegoLaVendeLanzaUnaExcecion() {

        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.hipotecarPropiedad(terrenoA1);

        assertThrows(NoVendible.class, () -> jugador.venderPropiedad(terrenoA1));
    }

    @Test
    public void test30JugadorCompraPropiedadYLaHipotecaYLaVendeLanzaExepcionLuegoLaDesHipotecaYLuegoLaVendeNoLanzaUnaExcecion() {

        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.hipotecarPropiedad(terrenoA1);

        assertThrows(NoVendible.class, () -> jugador.venderPropiedad(terrenoA1));
        jugador.desHipotecar(terrenoA1);
        assertDoesNotThrow(() -> jugador.venderPropiedad(terrenoA1));
    }

    @Test
    public void test31JugadorConPropiedadQueCaeEnSuPropiedadNoDebePagarPeaje() {

        Banco banco = new Banco(2000);
        Jugador propietario = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Propiedad propiedadDePrueba = new Transporte(new Posicion(0,0), null);
        Terreno propiedad = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        propiedad
                ), List.of(propietario), banco);

        propietario.comprarPropiedad(propiedad, 2000);
        tablero.mover(propietario, 1);

        assertDoesNotThrow(propietario::ejecutarOpcionable);

    }

    @Test
    public void test32JugadorVendeUnaPropiedadConEdificiosLanzaraUnaExcepcion() {

        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Terreno terrenoA1 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA2 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA3 = new Terreno(new Posicion(0,0), "TerrenoA", null);
        Terreno terrenoA4 = new Terreno(new Posicion(0,0), "TerrenoA", null);

        jugador.comprarPropiedad(terrenoA1, 0);
        jugador.comprarPropiedad(terrenoA2, 0);
        jugador.comprarPropiedad(terrenoA3, 0);
        jugador.comprarPropiedad(terrenoA4, 0);
        jugador.construirCasaEn(terrenoA1);

        assertThrows(NoVendible.class, () -> jugador.venderPropiedad(terrenoA1));
    }

    @Test
    public void test33JugadorPreso() {
        Banco banco = new Banco(2000);
        Jugador jugador = new Jugador(new Saldo(2000), new Dado(), "Pepito");
        Tablero tablero = new Tablero(
                List.of(
                        new LLegadaPartida(new Posicion(0,0), null),
                        new Encarcelar(new Posicion(0,1), null),
                        new Carcel(new Posicion(0,2), null)
                ), List.of(jugador), banco);

        tablero.mover(jugador, 1);
        jugador.ejecutarOpcionable();
        jugador.tirarDado();
        jugador.ejecutarOpcionable();
    }

}
