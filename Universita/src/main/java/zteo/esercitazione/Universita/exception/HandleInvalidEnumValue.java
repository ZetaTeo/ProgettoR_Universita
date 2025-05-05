package zteo.esercitazione.Universita.exception;

public class HandleInvalidEnumValue extends RuntimeException {
    public HandleInvalidEnumValue(String message) {
        super("Corso di laurea non valido: " + message);
    }
}
