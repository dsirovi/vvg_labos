package hr.java.vjezbe.entitet;

import java.util.Set;

/**
 * podatke o nazivu i artiklima sprema u kategorije
 */
public class Kategorija {
    private String naziv;
    private Set<Artikl> artikli;

    public Kategorija(String naziv, Set<Artikl> artikli) {
        this.naziv = naziv;
        this.artikli = artikli;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<Artikl> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikl> artikli) {
        this.artikli = artikli;
    }
}
