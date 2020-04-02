package hr.java.vjezbe.iznimke;

public class NeispravnaUslugaException extends Exception {
    public NeispravnaUslugaException() {
    }

    public NeispravnaUslugaException(String message) {
        super(message);
    }

    public NeispravnaUslugaException(String message, Throwable cause) {
        super(message, cause);
    }

    public NeispravnaUslugaException(Throwable cause) {
        super(cause);
    }

    public NeispravnaUslugaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
