package hr.java.vjezbe.entitet;

/**
 * Podatke privatnog korisnika ispisuje prilikom kreiranja oglasa
 */

public class PrivatniKorisnik extends Korisnik {
    private String ime;
    private String prezime;

    public PrivatniKorisnik(String email, String telefon, String ime, String prezime) {
        super(email, telefon);
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String dohvatiKontakt() {
        return String.format("Ime: %s, Prezime: %s, email: %S, tel: %s,", ime, prezime, getEmail(), getTelefon());
    }
}
