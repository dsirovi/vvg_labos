package hr.java.vjezbe.entitet;

import hr.java.vjezbe.glavna.Glavna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Sprema podatke artikla, korisnika i datum obajve te ispisuje tekst oglasa
 */

public class Prodaja {

    private static final Logger logger = LoggerFactory.getLogger(Glavna.class);

    private static final DateTimeFormatter MOJ_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

    private Artikl artikl;
    private Korisnik korisnik;
    private LocalDate datumObjave;

    public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
        this.artikl = artikl;
        this.korisnik = korisnik;
        this.datumObjave = datumObjave;
    }

    public Artikl getArtikl() {
        return artikl;
    }

    public void setArtikl(Artikl artikl) {
        this.artikl = artikl;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public LocalDate getDatumObjave() {
        return datumObjave;
    }

    public void setDatumObjave(LocalDate datumObjave) {
        this.datumObjave = datumObjave;
    }

    @Override
    public String toString() {
        try {
            return getArtikl().tekstOglasa() +
                    "\n" +
                    "Datum objave: " + getDatumObjave().format(MOJ_FORMAT) +
                    "\n" +
                    getKorisnik().dohvatiKontakt();
        } catch (Exception e) {
            logger.error("Dogodila se greska", e);
        }
        return toString();
    }
}
