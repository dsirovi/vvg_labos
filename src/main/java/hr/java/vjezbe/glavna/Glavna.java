package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;
import hr.java.vjezbe.sortiranje.ArtiklSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Sluzi za ispis aktivnih oglasa
 */
public class Glavna {

    public static final Logger logger = LoggerFactory.getLogger(Glavna.class);

    public static void main(String[] args) {

        logger.info("App started    !!!!");
        Scanner unos = new Scanner(System.in);

        int brojKorisnika = unosBroja(unos, "Unesite koliko korisnika zelite imati: ");

        List<Korisnik> korisnici = new ArrayList<>();
        for (int i = 0; i < brojKorisnika; i++) {
            System.out.println("Unesite tip " + (i + 1) + ". korisnika -> ");
            tipoviKorisnika();
            int odabraniKorisnik = dohvatiOdabir(unos);
            if (odabraniKorisnik == 1) {
                korisnici.add(podaciPrivatnogKorisnika(unos, i));
            } else {
                korisnici.add(podaciPoslovnogKorisnika(unos, i));
            }
        }

        int brojKategorija = unosBroja(unos, "Unesite broj kategorija koliko zelite imati: ");

        List<Kategorija> kategorije = new ArrayList<>();
        Map<Kategorija, List<Artikl>> mapaKategorija = new HashMap<>();
        for (int i = 0; i < brojKategorija; i++) {
            String nazivKategorije = podaciKategorije(unos, i);
            int brojArtikala = unosBroja(unos, "Unesite broj atikala koliko zelite u kategoriji: ");
            List<Artikl> artikli = new ArrayList<>();
            for (int j = 0; j < brojArtikala; j++) {
                System.out.println("Unesite tip " + (j + 1) + ". oglasa");
                tipOglasa();
                int odabraniOglas = dohvatiOdabir(unos);
                if (odabraniOglas == 1) {
                    artikli.add(podaciArtiklaUsluge(unos, j));
                } else if (odabraniOglas == 2) {
                    artikli.add(podaciArtiklaAutomobila(unos, j));
                } else {
                    artikli.add(podaciArtiklaStana(unos, j));
                }
            }

            Kategorija novaKategorija = new Kategorija(nazivKategorije, artikli);
            kategorije.add(novaKategorija);
            mapaKategorija.put(novaKategorija, new ArrayList<>(artikli));
        }

        int brojOglasa = unosBroja(unos, "Unesite broj artikala koji su aktivno na prodaju: ");
        obaviObjavuAtrikala(unos, korisnici, kategorije, brojOglasa);
        System.out.println("Ispis po kategorijama: ");
        ispisKategorija(mapaKategorija);
    }

    private static void ispisKategorija(Map<Kategorija, List<Artikl>> mapaKategorija) {
        mapaKategorija.entrySet()
                .forEach(kategorijaListEntry -> {
                    System.out.println("-------------------------------------------------------------------------------- ");
                    System.out.println("Kategorija: " + kategorijaListEntry.getKey().getNaziv());
                    System.out.println("-------------------------------------------------------------------------------- ");
                    kategorijaListEntry.getValue()
                            .forEach(artikl -> {
                        System.out.println(artikl.tekstOglasa());
                        System.out.println("-------------------------------------------------------------------------------- ");
                    });
                }
                );
//        for (Map.Entry<Kategorija, List<Artikl>> entry : mapaKategorija.entrySet()) {
//            System.out.println(entry.getKey().getNaziv() + ":");
//            System.out.println("-------------------------------------------------------------------------------- ");
//            for (Artikl artikl : entry.getValue()) {
//                System.out.println(artikl.tekstOglasa());
//                System.out.println("-------------------------------------------------------------------------------- ");
//            }
//        }
    }




    private static Stanje odabirStanja(Scanner unos) {
        for (int i = 0; i < Stanje.values().length; i++) {
            System.out.println((i + 1) + ". " + Stanje.values()[i].toString().toLowerCase());
        }
        int stanjeRedniBroj;
        while (true) {
            stanjeRedniBroj = dohvatiOdabir(unos);
            if (stanjeRedniBroj >= 1 && stanjeRedniBroj <= Stanje.values().length) {
                return Stanje.values()[stanjeRedniBroj - 1];
            } else {
                System.out.println("Neispravan unos!");
            }

        }
    }

    private static void tipOglasa() {
        for (int i = 0; i < TipOglasa.values().length; i++) {
            System.out.println((i + 1) + ". " + TipOglasa.values()[i].toString().toLowerCase());
        }

    }


    /**
     * Provjera dali su uneseni brojevi
     *
     * @param unos   trazi unos korisnika
     * @param poruka ispisuje poruku korinisku
     * @return vraca kosnicki unos
     */
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
                System.out.println("Molim vas unesite brojacane vrijednosti");
                logger.error("Molim vas unesite brojacane vrijednosti", e);
                unos.nextLine();
                petlja = true;
            }
        } while (petlja);
        return broj;
    }

    /**
     * Uzima unesene podatke i radi ispis aktivnih oglasa
     *
     * @param unos       trazi unos korisnika
     * @param korisnici  ispisuje sve korisnike i trazi odabir
     * @param kategorije ispisuje sve kategorije i trazi odabir
     * @param brojOglasa trayi korisnika da unese broj aktivnih oglasa
     */
    private static void obaviObjavuAtrikala(Scanner unos, List<Korisnik> korisnici, List<Kategorija> kategorije, int brojOglasa) {
        List<Prodaja> prodaje = new ArrayList<>();
        for (int i = 0; i < brojOglasa; i++) {
            System.out.println("Odaberite korisnika: ");
            ispisiKorisnike(korisnici);
            int odabirKorisnika = dohvatiOdabir(unos);
            Korisnik odabraniKorisnik = korisnici.get(odabirKorisnika - 1);

            System.out.println("Odaberi kategoriju: ");
            ispisiKategoije(kategorije);
            int odabirKategorije = dohvatiOdabir(unos);
            Kategorija odabranaKategorija = kategorije.get(odabirKategorije - 1);


            System.out.println("Odaberi artikl: ");
            List<Artikl> sortiraniArtikli = ispisiArtikle(odabranaKategorija.getArtikli());
            int odabirArtikla = dohvatiOdabir(unos);

            Prodaja novaProdaja = new Prodaja(sortiraniArtikli.get(odabirArtikla - 1), odabraniKorisnik, LocalDate.now());
            prodaje.add(novaProdaja);

        }

        System.out.println("Trenutno su na prodaju: ");
        System.out.println("-------------------------------------------------------------------------------- ");
        for (Prodaja prodaja : prodaje) {
            System.out.println(prodaja);
            System.out.println("-------------------------------------------------------------------------------- ");
        }
    }

    /**
     * Ispisi artikle
     *
     * @param artikli ispisuje sve artikle
     * @return
     */
    private static List<Artikl> ispisiArtikle(List<Artikl> artikli) {
        List<Artikl> sortiraniArtikli = new ArrayList<>(artikli);
        sortiraniArtikli.sort(new ArtiklSorter());
        for (int i = 0; i < sortiraniArtikli.size(); i++) {
            Artikl artikl = sortiraniArtikli.get(i);
            System.out.println((i + 1) + ". " + artikl.getNaslov());
        }
        return sortiraniArtikli;
    }

    /**
     * Ispisi kategorije
     *
     * @param kategorije ispisuje sve kategorije
     */
    private static void ispisiKategoije(List<Kategorija> kategorije) {
        for (int i = 1; i <= kategorije.size(); i++) {
            Kategorija kategorija = kategorije.get(i - 1);
            System.out.println(i + " " + kategorija.getNaziv());
        }
    }

    /**
     * Ispisi korisnike
     *
     * @param korisnici ispisuje sve korisnike
     */
    private static void ispisiKorisnike(List<Korisnik> korisnici) {
        for (int i = 0; i < korisnici.size(); i++) {
            Korisnik korisnik = korisnici.get(i);
            System.out.println((i + 1) + " " + korisnik.dohvatiKontakt());
        }
    }

    /**
     * Dohvaca odabir i provjerava da li je unesen broj
     *
     * @param unos trazi korisnika unos
     * @return vraca korisnicki unos
     */
    private static int dohvatiOdabir(Scanner unos) {
        int broj = unosBroja(unos, "Odabir -> ");
        return broj;
    }

    /**
     * Uzime unesene podatke o automobilu i sprema ih u artikl
     *
     * @param unos trazi korisnika unos
     * @param i    generira redna mjesta artikla
     * @return vraca podatke artikla
     */
    private static Artikl podaciArtiklaAutomobila(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa automobila -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa automobila -> ");
        String opis = unos.nextLine();
        BigDecimal snagaKs = BigDecimal.valueOf(unosBroja(unos, "Unesite snagu " + (i + 1) + ". u (Ks) oglasa automobila -> "));
        BigDecimal cijena = BigDecimal.valueOf(unosBroja(unos, "Unesite cijenu " + (i + 1) + ". oglasa automobila -> "));
        Stanje stanje = odabirStanja(unos);
        return new Automobil(naslov, opis, cijena, snagaKs, stanje);
    }

    private static Artikl podaciArtiklaStana(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa nekretnine -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa nekretnine -> ");
        String opis = unos.nextLine();
        int kvadratura = unosBroja(unos, "Unesite kvadraturu " + (i + 1) + ". nekretnine -> ");
        BigDecimal cijena = BigDecimal.valueOf(unosBroja(unos, "Unesite cijenu " + (i + 1) + ". nekretnine -> "));
        Stanje stanje = odabirStanja(unos);
        return new Stan(naslov, opis, cijena, kvadratura, stanje);
    }

    /**
     * Uzima sve unesene podatke o uslugama i sprema ih u artikl
     *
     * @param unos trazi korisnika unos
     * @param i    generira redna mjesta artikla
     * @return vraca podatke usluge
     */
    private static Artikl podaciArtiklaUsluge(Scanner unos, int i) {
        System.out.print("Unesite naslov " + (i + 1) + ". oglasa usluge -> ");
        String naslov = unos.nextLine();
        System.out.print("Unesite opis " + (i + 1) + ". oglasa usluge -> ");
        String opis = unos.nextLine();
        BigDecimal cijena = BigDecimal.valueOf(unosBroja(unos, "Unesite cijenu " + (i + 1) + ". oglasa usluge -> "));
        return new Usluga(naslov, opis, cijena);
    }

    /**
     * Uzima podatke o kategoriji
     *
     * @param unos trazi korisnika unos
     * @param i    generira redna mjesta artikla
     * @return vraca podatke kategorije
     */
    private static String podaciKategorije(Scanner unos, int i) {
        System.out.print("Unesite naziv " + (i + 1) + ". kategorije -> ");
        return unos.nextLine();
    }

    /**
     * Ispisuje sve tipove korisnika
     */
    private static void tipoviKorisnika() {
        for (int i = 0; i < TipKorisnika.values().length; i++) {
            System.out.println((i + 1) + ". " + TipKorisnika.values()[i].toString().toLowerCase());
        }
    }

    /**
     * Uzima sve podatke o privatnog korisnika i sprema u korisnike
     *
     * @param unos trazi korisnika unos
     * @param i    generira redna mjesta korisnika
     * @return vraca podatke privatnog korisnika
     */
    private static Korisnik podaciPrivatnogKorisnika(Scanner unos, int i) {
        System.out.print("Unesite ime " + (i + 1) + ". osobe -> ");
        String ime = unos.nextLine();
        System.out.print("Unesite prezime " + (i + 1) + ". osobe -> ");
        String prezime = unos.nextLine();
        System.out.print("Unesite email " + (i + 1) + ". osobe -> ");
        String email = unos.nextLine();
        System.out.print("Unesite telefon " + (i + 1) + ". osobe -> ");
        String telefon = unos.nextLine();
        return new PrivatniKorisnik(email, telefon, ime, prezime);
    }

    /**
     * Uzima sve podatke o poslovnog korisnika i sprema u korisnike
     *
     * @param unos trazi korisnika unos
     * @param i    generira redna mjesta korisnika
     * @return vraca podatke poslovnog korisnika
     */
    private static Korisnik podaciPoslovnogKorisnika(Scanner unos, int i) {
        System.out.print("Unesite naziv " + (i + 1) + ". tvrtke -> ");
        String naziv = unos.nextLine();
        System.out.print("Unesite email " + (i + 1) + ". tvrtke -> ");
        String email = unos.nextLine();
        System.out.print("Unesite web " + (i + 1) + ". tvrtke -> ");
        String web = unos.nextLine();
        System.out.print("Unesite telefon " + (i + 1) + ". tvrtke -> ");
        String telefon = unos.nextLine();
        return new PoslovniKorisnik(email, telefon, naziv, web);
    }
}
