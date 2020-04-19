package hr.java.vjezbe.entitet;

import hr.java.vjezbe.glavna.Glavna;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

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
    private static final BigDecimal GRANICA_PETE_KATEGORIJE = BigDecimal.valueOf(300);

    private BigDecimal snagaKs;

    public Automobil(String naslov, String opis, BigDecimal cijena, BigDecimal snagaKs, Stanje stanje) {
        super(naslov, opis, cijena, stanje);
        this.snagaKs = snagaKs;
    }

    public BigDecimal getSnagaKs() {
        return snagaKs;
    }

    public void setSnagaKs(BigDecimal snagaKs) {
        this.snagaKs = snagaKs;
    }

    @Override
    public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
        int grupa;
        if (snagaKs.compareTo(GRANICA_PRVE_KATEGORIJE) <= 0) {
            grupa = 1;
        } else if (snagaKs.compareTo(GRANICA_DRUGE_KATEGORIJE) <= 0) {
            grupa = 2;
        } else if (snagaKs.compareTo(GRANICA_TRECE_KATEGORIJE) <= 0) {
            grupa = 3;
        } else if (snagaKs.compareTo(GRANICA_CETVRTE_KATEGORIJE) <= 0) {
            grupa = 4;
        } else if (snagaKs.compareTo(GRANICA_PETE_KATEGORIJE) <= 0){
            grupa = 5;
        }else {
            throw new NemoguceOdreditiGrupuOsiguranjaException();
        }
        return BigDecimal.valueOf(grupa);
    }

    @Override
    public String tekstOglasa() {
        String tekstIzracunaOsiguranja;
        try {
            tekstIzracunaOsiguranja = izracunajCijenuOsiguranja().toString();
        }catch (NemoguceOdreditiGrupuOsiguranjaException e){
            Glavna.logger.error(e.getMessage(), e);
            tekstIzracunaOsiguranja = e.getMessage();
        }
        return String.format(
                "Naslov automobila: %s \nOpis automobila: %s \nStanje automobila: %s \nSnaga automobila: %s \nIzracun osiguranja automobila: %s \nCijena automobila: %s",
                getNaslov(),
                getOpis(),
                getStanje().toString().toLowerCase(),
                izracunajKw(snagaKs),
                tekstIzracunaOsiguranja,
                getCijena()
        );
    }
}
