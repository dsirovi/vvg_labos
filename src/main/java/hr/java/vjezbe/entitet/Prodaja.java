package hr.java.vjezbe.entitet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prodaja {

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
        return getArtikl().tekstOglasa() +
                "\n" +
                "Datum objave: " + getDatumObjave().format(MOJ_FORMAT) +
                "\n" +
                getKorisnik().dohvatiKontakt();
    }
}
