package hr.java.vjezbe.iznimke;

import java.io.Serializable;

public class CijenaJePreniskaException extends Exception implements Serializable {

    private static final long serialVersionUID = 7733110925531243024L;

    public CijenaJePreniskaException() {
        super("Cijena mora biti veca od 10.000kn");
    }

    public CijenaJePreniskaException(String message) {
        super(message);
    }

    public CijenaJePreniskaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CijenaJePreniskaException(Throwable cause) {
        super(cause);
    }
}
