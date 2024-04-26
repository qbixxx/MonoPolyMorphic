package example.model;

import java.util.Random;

public class Dado {

    public int tirar() {
        return new Random().nextInt(5) + 1;
    }
}
