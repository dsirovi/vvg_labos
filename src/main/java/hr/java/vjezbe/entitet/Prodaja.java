package hr.java.vjezbe.entitet;

import java.time.LocalDate;

public class Prodaja {
    private Kategorija kategorija;
    private Artikl artikl;
    private Korisnik korisnik;
    private LocalDate datumObjave;

    public Prodaja(Kategorija kategorija, Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
        this.kategorija = kategorija;
        this.artikl = artikl;
        this.korisnik = korisnik;
        this.datumObjave = datumObjave;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
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

}
