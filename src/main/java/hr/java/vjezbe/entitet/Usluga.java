package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Extenda klasu artikl i ispisuje tekst oglasa
 */
public class Usluga extends Artikl {
    public Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje) {
        super(naslov, opis, cijena, stanje);
    }

    @Override
    public String tekstOglasa() {
        return String.format("Naslov: %s \nOpis: %s \ncijena: %s", getNaslov(), getOpis(), getCijena());
    }
}
