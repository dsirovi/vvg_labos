package hr.java.vjezbe.entitet;

/**
 * Extenda klasu artikl i ispisuje tekst oglasa
 */

import java.math.BigDecimal;

public class Usluga extends Artikl {
    public Usluga(String naslov, String opis, BigDecimal cijena) {
        super(naslov, opis, cijena);
    }

    @Override
    public String tekstOglasa() {
        return String.format("Naslov: %s \nOpis: %s \ncijena: %s", getNaslov(), getOpis(), getCijena());
    }
}
