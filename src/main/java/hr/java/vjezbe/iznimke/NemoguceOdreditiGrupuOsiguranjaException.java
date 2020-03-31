package hr.java.vjezbe.iznimke;

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {

    private static final long serialVersionUID = -2291535264076831445L;


    public NemoguceOdreditiGrupuOsiguranjaException() {
        super("Dogodila se greska!!!");
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
