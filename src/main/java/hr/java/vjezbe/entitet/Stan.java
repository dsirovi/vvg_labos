package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Stan extends Artikl implements Nekretnina {
    private int kvadratura;

    public Stan(String naslov, String opis, BigDecimal cijena, int kavadratura, Stanje stanje) {
        super(naslov, opis, cijena, stanje);
        this.kvadratura = kavadratura;
    }

    public int getKavadratura() {
        return kvadratura;
    }

    public void setKavadratura(int kavadratura) {
        this.kvadratura = kavadratura;
    }

    @Override
    public String tekstOglasa() {
       return String.format("Naslov nakretnine: %s \nStanje nekretnine: %s \nOpis nekretnine: %s \nSKvadratura nekretnine: %s \nCijena nekretnine: %s \nPorez nekretnine: %s", getNaslov(), getStanje(), getOpis(), kvadratura, getCijena(), izracunajPorez(getCijena()));

    }
}
