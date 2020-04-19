package hr.java.vjezbe.entitet;

import java.util.List;
import java.util.Objects;

/**
 * podatke o nazivu i artiklima sprema u kategorije
 */
public class Kategorija<T extends Artikl> {
    private String naziv;
    private List<T> artikli;

    public Kategorija(String naziv, List<T> artikli) {
        this.naziv = naziv;
        this.artikli = artikli;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<T> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<T> artikli) {
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
