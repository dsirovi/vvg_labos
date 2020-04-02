package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Stan extends Artikl implements Nekretnina {
    private int kvadratura;

    public Stan(String naslov, String opis, BigDecimal cijena, int kavadratura) {
        super(naslov, opis, cijena);
        this.kvadratura = kavadratura;
    }

    public int getKavadratura() {
        return kvadratura;
    }

    public void setKavadratura(int kavadratura) {
        this.kvadratura = kavadratura;
    }

    @Override
    public String tekstOglasa() throws Exception {
        return null;
    }

    @Override
    public BigDecimal izracunajPorez() {
        return null;
    }
}
