package hr.java.vjezbe.entitet;

/**
 *Prima podatke o mailu i telefonu koriniska
 */
public abstract class Korisnik extends Entitet{

    private static long nextId = 1L;

    private String email;
    private String telefon;

    public Korisnik(String email, String telefon) {
        super(nextId++);
        this.email = email;
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public abstract String dohvatiKontakt();
}
