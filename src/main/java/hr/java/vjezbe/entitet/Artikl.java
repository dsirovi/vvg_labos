package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Podatke arikla posljeduje u tekst oglasa
 */
public abstract class Artikl extends Entitet {

    private static long nextId = 1L;

    private String naslov;
    private String opis;
    private BigDecimal cijena;
    private Stanje stanje;

    public Artikl(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje) {
        super(id);
        this.naslov = naslov;
        this.opis = opis;
        this.cijena = cijena;
        this.stanje = stanje;
    }

    public Artikl(String naslov, String opis, BigDecimal cijena, Stanje stanje) {
        super(nextId++);
        this.naslov = naslov;
        this.opis = opis;
        this.cijena = cijena;
        this.stanje = stanje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artikl artikl = (Artikl) o;
        return naslov.equals(artikl.naslov) &&
                opis.equals(artikl.opis) &&
                cijena.equals(artikl.cijena) &&
                stanje == artikl.stanje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(naslov, opis, cijena, stanje);
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    public abstract String tekstOglasa();
}
