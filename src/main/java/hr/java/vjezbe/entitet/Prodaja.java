package hr.java.vjezbe.entitet;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Sprema podatke artikla, korisnika i datum obajve te ispisuje tekst oglasa
 */

public class Prodaja extends Entitet implements Serializable {

    private static final DateTimeFormatter MOJ_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
    private static final long serialVersionUID = 938329775386513542L;

    private static long nextId = 1L;

    private Artikl artikl;
    private Korisnik korisnik;
    private LocalDate datumObjave;

    public Prodaja(long id, Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
        super(id);
        this.artikl = artikl;
        this.korisnik = korisnik;
        this.datumObjave = datumObjave;
    }

    public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
        super(nextId++);
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
            return getArtikl().tekstOglasa() +
                    "\n" +
                    "Datum objave: " + getDatumObjave().format(MOJ_FORMAT) +
                    "\n" +
                    getKorisnik().dohvatiKontakt();
    }
}
