package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public interface Nekretnina {
    default BigDecimal izracunajPorez() {
        return null;
    }
}

