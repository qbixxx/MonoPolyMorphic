package example.model.excepciones;

public class NoDesHipotecable extends RuntimeException {

    public NoDesHipotecable() {
        super("No se puede deshipotecar esta propiedad");
    }
}
