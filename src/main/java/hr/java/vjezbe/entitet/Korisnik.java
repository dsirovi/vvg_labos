package hr.java.vjezbe.entitet;

public abstract class Korisnik {
    private String email;
    private String telefon;

    public Korisnik(String email, String telefon) {
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
