package hr.java.vjezbe.iznimke;

public class CijenaJePreniskaException extends Exception {
    public CijenaJePreniskaException() {
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
