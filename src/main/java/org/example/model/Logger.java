package org.example.model;

public class Logger {
    private static Logger instance = null;

    private String texto;

    private Logger() {
        this.texto = "";
    }

    public Logger(Logger logger) {
        instance = logger;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        this.texto += "\n" + message;
        System.out.println(message);
    }

    public String mostrarInfo() {
        String text = this.texto;
        this.texto = "";
        return text;
    }

    public void error(String message) {
        System.out.println(message);
    }

}
