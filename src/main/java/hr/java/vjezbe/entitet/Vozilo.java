package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public interface Vozilo {
    double KILOWATTS = 0.7457;

    default BigDecimal izracunajKw(BigDecimal horsePower) {
        return horsePower.multiply(new BigDecimal(KILOWATTS));
    }

    BigDecimal izracunajGrupuOsiguranja();

    default BigDecimal izracunajCijenuOsiguranja() {
        BigDecimal grupa = izracunajGrupuOsiguranja();

        int cijena = 0;
        switch (grupa.intValue()) {
            case 1:
                cijena = (int) (Math.random() * 100 + 1);
                break;
            case 2:
                cijena = (int) (Math.random() * 200 + 101);
                break;
            case 3:
                cijena = (int) (Math.random() * 300 + 201);
                break;
            case 4:
                cijena = (int) (Math.random() * 400 + 301);
                break;
            case 5:
                cijena = (int) (Math.random() * 1000 + 401);
                break;
        }

        return BigDecimal.valueOf(cijena);
    }
}

