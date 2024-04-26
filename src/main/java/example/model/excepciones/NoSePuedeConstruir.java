package example.model.excepciones;

public class NoSePuedeConstruir extends RuntimeException{


    public NoSePuedeConstruir() {
        super("No se puede construir");
    }
}
