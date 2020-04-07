package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public interface Nekretnina {
    default BigDecimal izracunajPorez(BigDecimal cijena) {
        BigDecimal porez = cijena.multiply(BigDecimal.valueOf(0.03));
        return porez;
    }
}

