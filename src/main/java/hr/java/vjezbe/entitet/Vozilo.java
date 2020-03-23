package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.util.Scanner;

public interface Vozilo {
    double KILOWATTS = 0.7457;
    default BigDecimal izracunajKw() {
        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite snagu 1. (u ks) oglasa automobila -> ");
        BigDecimal horsePower = unos.nextBigDecimal();
        BigDecimal convertHptoKw = horsePower.multiply(new BigDecimal(KILOWATTS));
        return convertHptoKw;
    }
    BigDecimal izracunajGrupuOsiguranja();

    default BigDecimal izracunajCijenuOsiguranja() {
        izracunajGrupuOsiguranja()
        int num1;

        num1 = (int) (Math.random()* 5+1);
        switch (num1){
            case 1:
                BigDecimal.valueOf(num1);
                break;
            case 2:
                BigDecimal.valueOf(num1);
                break;
            case 3:
                BigDecimal.valueOf(num1);
                break;
            case 4:
                BigDecimal.valueOf(num1);
                break;
            case 5:
                BigDecimal.valueOf(num1);
                break;
        }

        return ;
    }
}

