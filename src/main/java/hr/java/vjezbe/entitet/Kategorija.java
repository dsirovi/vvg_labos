package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.util.List;

public class Kategorija {
    private String naziv;
    private List<Artikl> artikli;
    private BigDecimal donjaGranicaVrijednosti;
    private BigDecimal gornjaGranicaVrijednosti;

    public Kategorija(String naziv, List<Artikl> artikli, BigDecimal donjaGranicaVrijednosti, BigDecimal gornjaGranicaVrijednosti) {
        this.naziv = naziv;
        this.artikli = artikli;
        this.donjaGranicaVrijednosti = donjaGranicaVrijednosti;
        this.gornjaGranicaVrijednosti = gornjaGranicaVrijednosti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Artikl> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikl> artikli) {
        this.artikli = artikli;
    }

    public BigDecimal getDonjaGranicaVrijednosti() {
        return donjaGranicaVrijednosti;
    }

    public void setDonjaGranicaVrijednosti(BigDecimal donjaGranicaVrijednosti) {
        this.donjaGranicaVrijednosti = donjaGranicaVrijednosti;
    }

    public BigDecimal getGornjaGranicaVrijednosti() {
        return gornjaGranicaVrijednosti;
    }

    public void setGornjaGranicaVrijednosti(BigDecimal gornjaGranicaVrijednosti) {
        this.gornjaGranicaVrijednosti = gornjaGranicaVrijednosti;
    }
}
