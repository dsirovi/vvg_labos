package hr.java.vjezbe.entitet;

/**
 * podatke o nazivu i artiklima sprema u kategorije
 */
public class Kategorija {
    private String naziv;
    private Artikl[] artikli;

    public Kategorija(String naziv, Artikl[] artikli) {
        this.naziv = naziv;
        this.artikli = artikli;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Artikl[] getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikl[] artikli) {
        this.artikli = artikli;
    }
}
