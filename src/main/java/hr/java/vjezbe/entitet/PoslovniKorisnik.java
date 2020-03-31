package hr.java.vjezbe.entitet;

/**
 * Prima podatke o poslovnim korisnicima
 */

public class PoslovniKorisnik extends Korisnik {
    private String naziv;
    private String web;

    public PoslovniKorisnik(String email, String telefon, String naziv, String web) {
        super(email, telefon);
        this.naziv = naziv;
        this.web = web;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @return vraca podatke o poslovnim korisnicima
     */
    @Override
    public String dohvatiKontakt() {
        return String.format("Naziv: %s, email: %s, web: %s, tel: %s", naziv, getEmail(), web, getTelefon());
    }
}
