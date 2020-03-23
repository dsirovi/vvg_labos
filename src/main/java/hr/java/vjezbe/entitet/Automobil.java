package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Automobil extends Artikl implements Vozilo {
    private BigDecimal snagaKs;

    public Automobil(String naslov, String opis, BigDecimal cijena, BigDecimal snagaKs) {
        super(naslov, opis, cijena);
        this.snagaKs = snagaKs;
    }

    public BigDecimal getSnagaKs() {
        return snagaKs;
    }

    public void setSnagaKs(BigDecimal snagaKs) {
        this.snagaKs = snagaKs;
    }

    @Override
    public BigDecimal izracunajKw() {
        return null;
    }

    @Override
    public BigDecimal izracunajGrupuOsiguranja() {
        return null;
    }

    @Override
    public BigDecimal izracunajCijenuOsiguranja() {
        return null;
    }

    @Override
    public String tekstOglasa() {
        return String.format("Naslov: %s, Opis: %s, Snaga: %s, Cijena osiguranja: %s, Cijena automobila: %s", getNaslov(), getOpis(), snagaKs, izracunajCijenuOsiguranja(), getCijena());
    }
}
