package hr.java.vjezbe.entitet;

import java.io.Serializable;

/**
 * Prima podatke o privatnim korisnicima
 */

public class PrivatniKorisnik extends Korisnik implements Serializable {

    private static final long serialVersionUID = 2861547898541255562L;

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
    /**
     * @return vraca podatke o privatnim korisnicima
     */
    @Override
    public String dohvatiKontakt() {
        return String.format("Ime: %s, Prezime: %s, email: %s, tel: %s", ime, prezime, getEmail(), getTelefon());
    }
}
