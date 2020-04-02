package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Prima podatke o vozilu i sprema ih automobil te prosljeduje u artikle
 * na osnovu konjskih snaga sprema u odredenu grupu osiguranja
 */
public class Automobil extends Artikl implements Vozilo {

    private static final BigDecimal GRANICA_PRVE_KATEGORIJE = BigDecimal.valueOf(105);
    private static final BigDecimal GRANICA_DRUGE_KATEGORIJE = BigDecimal.valueOf(140);
    private static final BigDecimal GRANICA_TRECE_KATEGORIJE = BigDecimal.valueOf(180);
    private static final BigDecimal GRANICA_CETVRTE_KATEGORIJE = BigDecimal.valueOf(250);

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
    public BigDecimal izracunajGrupuOsiguranja() {
        int grupa;
        if (snagaKs.compareTo(GRANICA_PRVE_KATEGORIJE) <= 0) {
            grupa = 1;
        } else if (snagaKs.compareTo(GRANICA_DRUGE_KATEGORIJE) <= 0) {
            grupa = 2;
        } else if (snagaKs.compareTo(GRANICA_TRECE_KATEGORIJE) <= 0) {
            grupa = 3;
        } else if (snagaKs.compareTo(GRANICA_CETVRTE_KATEGORIJE) <= 0) {
            grupa = 4;
        } else {
            grupa = 5;
        }
        return BigDecimal.valueOf(grupa);
    }

    @Override
    public String tekstOglasa() throws Exception {
        return String.format("Naslov automobila: %s \nOpis automobila: %s \nSnaga automobila: %s \nIzracun osiguranja automobila: %s \nCijena automobila: %s", getNaslov(), getOpis(), snagaKs, izracunajCijenuOsiguranja(), getCijena());
    }
}
