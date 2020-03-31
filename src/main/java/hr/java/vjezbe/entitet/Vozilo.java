package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public interface Vozilo {
    double KILOWATTS = 0.7457;

    default BigDecimal izracunajKw(BigDecimal horsePower) {
        return horsePower.multiply(new BigDecimal(KILOWATTS));
    }

    BigDecimal izracunajGrupuOsiguranja() throws Exception;

    default BigDecimal izracunajCijenuOsiguranja() throws Exception {
        BigDecimal grupa = izracunajGrupuOsiguranja();

        int cijena = 0;
        switch (grupa.intValue()) {
            case 1:
                cijena = (int) (Math.random() * 500 + 1);
                break;
            case 2:
                cijena = (int) (Math.random() * 1000 + 501);
                break;
            case 3:
                cijena = (int) (Math.random() * 1500 + 1001);
                break;
            case 4:
                cijena = (int) (Math.random() * 2000 + 1501);
                break;
            case 5:
                cijena = (int) (Math.random() * 3000 + 2001);
                break;
        }

        return BigDecimal.valueOf(cijena);
    }
}

