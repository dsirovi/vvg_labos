package hr.java.vjezbe.entitet;

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
        return String.valueOf(new PrivatniKorisnik(getEmail(), getTelefon(), getIme(), getPrezime()));
    }
}
