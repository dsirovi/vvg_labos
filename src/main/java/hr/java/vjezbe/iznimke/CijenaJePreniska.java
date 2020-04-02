package hr.java.vjezbe.iznimke;

public class CijenaJePreniska extends Exception {
    public CijenaJePreniska() {
    }

    public CijenaJePreniska(String message) {
        super(message);
    }

    public CijenaJePreniska(String message, Throwable cause) {
        super(message, cause);
    }

    public CijenaJePreniska(Throwable cause) {
        super(cause);
    }
}
