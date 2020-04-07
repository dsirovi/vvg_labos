package hr.java.vjezbe.entitet;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija that = (Kategorija) o;
        return Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }
}
