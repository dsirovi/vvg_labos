package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.Prodaja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Glavna {

    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);

        System.out.print("Unesite koliko korisnika zelite imati: ");
        int brojKorisnika = unos.nextInt();
        unos.nextLine();

        Korisnik[] korisnici = new Korisnik[brojKorisnika];
        for (int i = 0; i < brojKorisnika; i++) {
            korisnici[i] = podaciKorisnika(unos, i);
        }

        System.out.print("Unesite broj kategorija koliko zelite imati: ");
        int brojKategorija = unos.nextInt();
        unos.nextLine();

        Kategorija[] kategorije = new Kategorija[brojKategorija];

        for (int i = 0; i < brojKategorija; i++) {
            String nazivKategorije = podaciKategorije(unos, i);
            System.out.print("Unesite broj atikala koliko zelite u kategoriji: ");
            int brojArtikala = unos.nextInt();
            unos.nextLine();
            Artikl[] artikli = new Artikl[brojArtikala];
            for (int j = 0; j < brojArtikala; j++) {
                Artikl artikl = podaciArtikla(unos, j);
                artikli[j] = artikl;
            }

            kategorije[i] = new Kategorija(nazivKategorije, artikli);
        }

        System.out.print("Unesite broj artikala koji su aktivno na prodaju: ");
        int brojOglasa = unos.nextInt();
        unos.nextLine();
        obaviObjavuAtrikala(unos, korisnici, kategorije, brojOglasa);
    }





    private static void obaviObjavuAtrikala(Scanner unos, Korisnik[] korisnici, Kategorija[] kategorije, int brojOglasa) {
        Prodaja[] prodaje = new Prodaja[brojOglasa];
        for (int i = 0; i < brojOglasa; i++) {
            System.out.println("Odaberite korisnika: ");
            ispisiKorisnike(korisnici);
            int odabirKorisnika = dohvatiOdabir(unos);
            Korisnik odabraniKorisnik = korisnici[odabirKorisnika - 1];

            System.out.println("Odaberi kategoriju: ");
            ispisiKategoije(kategorije);
            int odabirKategorije = dohvatiOdabir(unos);
            Kategorija odabranaKategorija = kategorije[odabirKategorije - 1];

            System.out.println("Odaberi artikl: ");
            ispisiArtikle(odabranaKategorija.getArtikli());
            int odabirArtikla = dohvatiOdabir(unos);
            Artikl odabraniArtikl = odabranaKategorija.getArtikli()[odabirArtikla - 1];

            Prodaja prodaja = new Prodaja(odabraniArtikl, odabraniKorisnik, LocalDate.now());
            prodaje[i] = prodaja;
        }
        DateTimeFormatter mojFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        System.out.println("Trenutno su na prodaju: ");
        for (int i = 0; i < prodaje.length; i++) {
            Prodaja prodaja = prodaje[i];
            Artikl artikl = prodaja.getArtikl();
            Korisnik korisnik = prodaja.getKorisnik();
            System.out.println("Naslov: " + artikl.getNaslov());
            System.out.println("Opis: " + artikl.getOpis());
            System.out.println("Cijena: " + artikl.getCijena());
            System.out.println("Datum obajve: " + prodaja.getDatumObjave().format(mojFormat));
            System.out.println("Kontakt podaci: " + korisnik.getImeIPrezime() + ", mail: " + korisnik.getEmail() + ", tel: " + korisnik.getTelefon());
            System.out.println("_________________________________");
        }
    }

    private static void ispisiArtikle(Artikl[] artikli) {
        for (int i = 1; i <= artikli.length; i++) {
            Artikl artikl = artikli[i - 1];
            System.out.println(i + " " + artikl.getNaslov());
        }
    }

    private static void ispisiKategoije(Kategorija[] kategorije) {
        for (int i = 1; i <= kategorije.length; i++) {
            Kategorija kategorija = kategorije[i - 1];
            System.out.println(i + " " + kategorija.getNaziv());
        }
    }

    private static void ispisiKorisnike(Korisnik[] korisnici) {
        for (int i = 0; i < korisnici.length; i++) {
            Korisnik korisnik = korisnici[i];
            System.out.println((i + 1) + " " + korisnik.getImeIPrezime());
        }
    }

    private static int dohvatiOdabir(Scanner unos) {
        System.out.print("Odabir -> ");
        return unos.nextInt();
    }


    private static Artikl podaciArtikla(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa artikla -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa artikla -> ");
        String opis = unos.nextLine();
        System.out.print("Unesite cijenu " + (i + 1) + ". oglasa artikla -> ");
        BigDecimal cijena = unos.nextBigDecimal();
        unos.nextLine();
        return new Artikl(naslov, opis, cijena);
    }

    private static String podaciKategorije(Scanner unos, int i) {
        System.out.print("Unesite naziv " + (i + 1) + ". kategorije -> ");
        return unos.nextLine();
    }

    private static Korisnik podaciKorisnika(Scanner unos, int i) {
        System.out.print("Unesite ime " + (i + 1) + ". korisnika -> ");
        String ime = unos.nextLine();
        System.out.print("Unesite prezime " + (i + 1) + ". korisnika -> ");
        String prezime = unos.nextLine();
        System.out.print("Unesite email " + (i + 1) + ". korisnika -> ");
        String email = unos.nextLine();
        System.out.print("Unesite telefon " + (i + 1) + ". korisnika -> ");
        String telefon = unos.nextLine();
        return new Korisnik(ime, prezime, email, telefon);
    }
}
