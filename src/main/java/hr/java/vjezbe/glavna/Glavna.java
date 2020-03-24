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
            System.out.println("Unesite tip " + (i + 1) + ". korisnika -> ");
            tipoviKorisnika();
            int odabraniKorisnik = dohvatiOdabir(unos);
            unos.nextLine();
            if (odabraniKorisnik == 1) {
                korisnici[i] = podaciPrivatnogKorisnika(unos, i);
            } else {
                korisnici[i] = podaciPoslovnogKorisnika(unos, i);
            }
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
                System.out.println("Unesite tip " + (j + 1) + ". oglasa");
                tipoviOglasa();
                int odabraniOglas = dohvatiOdabir(unos);
                unos.nextLine();
                if (odabraniOglas == 1){
                    Artikl artikl = podaciArtiklaUsluge(unos, j);
                    artikli[j] = artikl;
                }else{
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
        System.out.println("_____________________________________________");
        for (Prodaja prodaja : prodaje) {
            Artikl artikl = prodaja.getArtikl();
            Korisnik korisnik = prodaja.getKorisnik();
            System.out.println(artikl.tekstOglasa());
            System.out.println("Datum obajve: " + prodaja.getDatumObjave().format(mojFormat));
            System.out.println(korisnik.dohvatiKontakt());
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
        System.out.print("Odabir -> ");
        return unos.nextInt();
    }

    public static void tipoviOglasa() {
        System.out.println("1. Usluge");
        System.out.println("2. Automobil");
    }

    private static Artikl podaciArtiklaAutomobila(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa automobila -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa automobila -> ");
        String opis = unos.nextLine();
        System.out.print("Unesite snagu " + (i+1) + ". u (Ks) oglasa automobila -> ");
        BigDecimal snagaKs = unos.nextBigDecimal();
        unos.nextLine();
        System.out.print("Unesite cijenu " + (i + 1) + ". oglasa automobila -> ");
        BigDecimal cijena = unos.nextBigDecimal();
        unos.nextLine();
        return new Artikl(naslov, opis, cijena) {
            @Override
            public String tekstOglasa() {
                return String.format("""
                        Naslov automobila: %s\040
                        Opis automobila: %s\040
                        Snaga automobila: %s\040
                        Cijena automobila: %s""", naslov, opis, snagaKs, cijena);
            }
        };
    }

    private static Artikl podaciArtiklaUsluge(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa usluge -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa usluge -> ");
        String opis = unos.nextLine();
        System.out.print("Unesite cijenu " + (i + 1) + ". oglasa usluge -> ");
        BigDecimal cijena = unos.nextBigDecimal();
        unos.nextLine();
        return new Artikl(naslov, opis, cijena) {
            @Override
            public String tekstOglasa() {
                return String.format("""
                        Naslov: %s\040
                        Opis: %s\040
                        cijena: %s""", naslov, opis, cijena);
            }
        };
    }

    private static String podaciKategorije(Scanner unos, int i) {
        System.out.print("Unesite naziv " + (i + 1) + ". kategorije -> ");
        return unos.nextLine();
    }

    public static void tipoviKorisnika() {
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
