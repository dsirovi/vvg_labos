package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Glavna {

    private static final Logger logger = LoggerFactory.getLogger(Glavna.class);

    public static void main(String[] args) {

        logger.info("App started    !!!!");
        boolean petlja;
        Scanner unos = new Scanner(System.in);

        int brojKorisnika = unosBroja(unos, "Unesite koliko korisnika zelite imati: ");

        Korisnik[] korisnici = new Korisnik[brojKorisnika];
        for (int i = 0; i < brojKorisnika; i++) {
            System.out.println("Unesite tip " + (i + 1) + ". korisnika -> ");
            tipoviKorisnika();
            int odabraniKorisnik = dohvatiOdabir(unos);
            if (odabraniKorisnik == 1) {
                korisnici[i] = podaciPrivatnogKorisnika(unos, i);
            } else {
                korisnici[i] = podaciPoslovnogKorisnika(unos, i);
            }
        }

        int brojKategorija = unosBroja(unos, "Unesite broj kategorija koliko zelite imati: ");

        Kategorija[] kategorije = new Kategorija[brojKategorija];

        for (int i = 0; i < brojKategorija; i++) {
            String nazivKategorije = podaciKategorije(unos, i);
            int brojArtikala = unosBroja(unos, "Unesite broj atikala koliko zelite u kategoriji: ");
            Artikl[] artikli = new Artikl[brojArtikala];
            for (int j = 0; j < brojArtikala; j++) {
                System.out.println("Unesite tip " + (j + 1) + ". oglasa");
                tipoviOglasa();
                int odabraniOglas = dohvatiOdabir(unos);
                if (odabraniOglas == 1) {
                    Artikl artikl = podaciArtiklaUsluge(unos, j);
                    artikli[j] = artikl;
                } else {
                    Artikl artikl = podaciArtiklaAutomobila(unos, j);
                    artikli[j] = artikl;
                }

            }

            kategorije[i] = new Kategorija(nazivKategorije, artikli);
        }

        System.out.print("Unesite broj artikala koji su aktivno na prodaju: ");
        int brojOglasa = unos.nextInt();
        unos.nextLine();
        obaviObjavuAtrikala(unos, korisnici, kategorije, brojOglasa);
    }


    private static int unosBroja(Scanner unos, String poruka) {
        int broj = 0;
        boolean petlja;

        do {
            try {
                System.out.print(poruka);
                broj = unos.nextInt();
                unos.nextLine();
                petlja = false;
            } catch (InputMismatchException | ArithmeticException e) {
                logger.error("unesite brojacane vrijednosti", e);
                unos.nextLine();
                petlja = true;
            }
        } while (petlja);
        return broj;
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

        System.out.println("Trenutno su na prodaju: ");
        System.out.println("_____________________________________________");
        for (Prodaja prodaja : prodaje) {
            System.out.println(prodaja);
            System.out.println("_____________________________________________");
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
            System.out.println((i + 1) + " " + korisnik.dohvatiKontakt());
        }
    }

    private static int dohvatiOdabir(Scanner unos) {
        int broj = unosBroja(unos, "Odabir -> ");
        return broj;
    }

    private static void tipoviOglasa() {
        System.out.println("1. Usluge");
        System.out.println("2. Automobil");
    }

    private static Artikl podaciArtiklaAutomobila(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa automobila -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa automobila -> ");
        String opis = unos.nextLine();
        BigDecimal snagaKs = BigDecimal.valueOf(unosBroja(unos, "Unesite snagu " + (i + 1) + ". u (Ks) oglasa automobila -> "));
        System.out.print("Unesite cijenu " + (i + 1) + ". oglasa automobila -> ");
        BigDecimal cijena = BigDecimal.valueOf(unosBroja(unos, "Unesite cijenu " + (i + 1) + ". oglasa automobila -> "));
        return new Automobil(naslov, opis, cijena, snagaKs);
    }

    private static Artikl podaciArtiklaUsluge(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa usluge -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa usluge -> ");
        String opis = unos.nextLine();
        BigDecimal cijena = BigDecimal.valueOf(unosBroja(unos, "Unesite cijenu " + (i + 1) + ". oglasa usluge -> "));
        return new Usluga(naslov, opis, cijena);
    }

    private static String podaciKategorije(Scanner unos, int i) {
        System.out.print("Unesite naziv " + (i + 1) + ". kategorije -> ");
        return unos.nextLine();
    }

    private static void tipoviKorisnika() {
        System.out.println("1. Privatni");
        System.out.println("2. Poslovni");
    }


    private static Korisnik podaciPrivatnogKorisnika(Scanner unos, int i) {
        System.out.print("Unesite ime " + (i + 1) + ". osobe -> ");
        String ime = unos.nextLine();
        System.out.print("Unesite prezime " + (i + 1) + ". osobe -> ");
        String prezime = unos.nextLine();
        System.out.print("Unesite email " + (i + 1) + ". osobe -> ");
        String email = unos.nextLine();
        System.out.print("Unesite telefon " + (i + 1) + ". osobe -> ");
        String telefon = unos.nextLine();
        return new Korisnik(email, telefon) {
            @Override
            public String dohvatiKontakt() {
                return String.format("Osobni podaci prodavatelja: %s, email: %s, tel: %s", ime + " " + prezime, getEmail(), getTelefon());
            }
        };
    }

    private static Korisnik podaciPoslovnogKorisnika(Scanner unos, int i) {
        System.out.print("Unesite naziv " + (i + 1) + ". tvrtke -> ");
        String naziv = unos.nextLine();
        System.out.print("Unesite email " + (i + 1) + ". tvrtke -> ");
        String email = unos.nextLine();
        System.out.print("Unesite web " + (i + 1) + ". tvrtke -> ");
        String web = unos.nextLine();
        System.out.print("Unesite telefon " + (i + 1) + ". tvrtke -> ");
        String telefon = unos.nextLine();
        return new Korisnik(email, telefon) {
            @Override
            public String dohvatiKontakt() {
                return String.format("Naziv tvrtke: %s, email: %s, web: %s, tel: %s", naziv, getEmail(), web, getTelefon());
            }
        };
    }
}
