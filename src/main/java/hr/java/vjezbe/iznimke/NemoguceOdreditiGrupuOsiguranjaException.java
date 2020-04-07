package hr.java.vjezbe.iznimke;

import java.io.Serializable;

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception implements Serializable {

    private static final long serialVersionUID = -8951018113490159724L;

    public NemoguceOdreditiGrupuOsiguranjaException() {
        super("Previse kW za odrediti grupu osiguranja");
    }

    public NemoguceOdreditiGrupuOsiguranjaException(String message) {
        super(message);
    }

    public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
        super(message, cause);
    }

    public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
        super(cause);
    }

    public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
