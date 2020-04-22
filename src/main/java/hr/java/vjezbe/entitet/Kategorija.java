package hr.java.vjezbe.entitet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * podatke o nazivu i artiklima sprema u kategorije
 */
public class Kategorija<T extends Artikl> extends Entitet implements Serializable {

    private static final long serialVersionUID = 310669404121831716L;
    private static long nextId = 1L;

    private String naziv;
    private List<T> artikli;


    public Kategorija(long id, String naziv, List<T> artikli) {
        super(id);
        this.naziv = naziv;
        this.artikli = artikli;
    }

    public Kategorija(String naziv, List<T> artikli) {
        this(nextId++, naziv, artikli);
    }

    public Kategorija(String naziv) {
        this(naziv, new ArrayList<>());
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

    public void dodajArtikl(T artikl){
        artikli.add(artikl);
    }

    public T dohvatiArtikl(int index){
        return artikli.get(index);
    }
}
