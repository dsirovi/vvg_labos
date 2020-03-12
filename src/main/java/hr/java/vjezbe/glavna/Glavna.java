package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;

import java.math.BigDecimal;
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
