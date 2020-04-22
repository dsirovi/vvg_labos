package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Sluzi za ispis aktivnih oglasa
 */
public class GlavnaDatoteke {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final Logger logger = LoggerFactory.getLogger(GlavnaDatoteke.class);

    public static void main(String[] args) {

        logger.info("App started    !!!!");
        File file = new File("dat/artikl");
        try (Scanner unos = new Scanner(file)) {
            Map<Long, Korisnik> mapaKorisnika = new HashMap<>();
            while (unos.hasNextLine()) {
                String tipKorisnika = unos.nextLine();

                Korisnik korisnik;
                if (TipKorisnika.PRIVATNI.getId().equals(tipKorisnika)) {
                    korisnik = podaciPrivatnogKorisnika(unos);
                } else if (TipKorisnika.POSLOVNI.getId().equals(tipKorisnika)) {
                    korisnik = podaciPoslovnogKorisnika(unos);
                } else if ("".equals(tipKorisnika)) {
                    break;
                } else {
                    throw new RuntimeException("Krivi tip korisnika");
                }

                mapaKorisnika.put(korisnik.getId(), korisnik);
            }

            Map<Long, Artikl> mapaArtikala = new HashMap<>();
            while (unos.hasNextLine()) {
                String tipArtikla = unos.nextLine();

                Artikl artikl;
                if ("1".equals(tipArtikla)) {
                    artikl = podaciArtiklaUsluge(unos);
                } else if ("2".equals(tipArtikla)) {
                    artikl = podaciArtiklaAutomobila(unos);
                } else if ("3".equals(tipArtikla)) {
                    artikl = podaciArtiklaStana(unos);
                } else if ("".equals(tipArtikla)) {
                    break;
                } else {
                    throw new RuntimeException("Krivi tip artikla");
                }

                mapaArtikala.put(artikl.getId(), artikl);
            }

            Map<Long, Kategorija<Artikl>> mapaKategorija = new HashMap<>();
            while (unos.hasNextLine()) {
                String slijedecaLinija = unos.nextLine();

                if ("".equals(slijedecaLinija)) {
                    break;
                }

                long id = Long.parseLong(slijedecaLinija);
                String naziv = unos.nextLine();
                List<Artikl> artikliKategorije = Arrays.stream(unos.nextLine().split(" "))
                        .map(Long::parseLong)
                        .map(mapaArtikala::get)
                        .collect(Collectors.toList());

                Kategorija<Artikl> kategorija = new Kategorija<>(id, naziv, artikliKategorije);
                mapaKategorija.put(kategorija.getId(), kategorija);
            }

            List<Prodaja> prodaje = new ArrayList<>();
            while (unos.hasNextLine()) {
                long idKorisnika = unos.nextLong();
                long idArtikla = unos.nextLong();
                unos.nextLine();
                LocalDate datumObjave = LocalDate.parse(unos.nextLine(), DATE_FORMAT);

                Prodaja prodaja = new Prodaja(mapaArtikala.get(idArtikla), mapaKorisnika.get(idKorisnika), datumObjave);
                prodaje.add(prodaja);
            }

            System.out.println("Trenutno su oglasi na prodaju");
            System.out.println("--------------------------------------------------------------------------------");
            prodaje.forEach(prodaja -> {
                System.out.println(prodaja);
                System.out.println("--------------------------------------------------------------------------------");
            });

            System.out.println("Ispis po kategorijama:");
            System.out.println("--------------------------------------------------------------------------------");
            ispisKategorija(mapaKategorija.values());

            try(FileOutputStream fos = new FileOutputStream("dat/serijalizacija.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(prodaje);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void ispisKategorija(Collection<Kategorija<Artikl>> kategorije) {
        kategorije
                .forEach(kategorija -> {
                            System.out.println("Kategorija: " + kategorija.getNaziv());
                            System.out.println("-------------------------------------------------------------------------------- ");
                            kategorija.getArtikli()
                                    .forEach(artikl -> {
                                        System.out.println(artikl.tekstOglasa());
                                        System.out.println("-------------------------------------------------------------------------------- ");
                                    });
                        }
                );
    }

    private static Stanje odabirStanja(Scanner unos) {
        int stanjeRedniBroj = unos.nextInt();
        unos.nextLine();
        return Stanje.values()[stanjeRedniBroj - 1];
    }

    /**
     * Uzime unesene podatke o automobilu i sprema ih u artikl
     *
     * @param unos trazi korisnika unos
     * @return vraca podatke artikla
     */
    private static Artikl podaciArtiklaAutomobila(Scanner unos) {
        long id = unos.nextLong();
        unos.nextLine();
        String naslov = unos.nextLine();
        String opis = unos.nextLine();
        BigDecimal snagaKs = BigDecimal.valueOf(unos.nextInt());
        BigDecimal cijena = BigDecimal.valueOf(unos.nextInt());
        Stanje stanje = odabirStanja(unos);
        return new Automobil(id, naslov, opis, cijena, snagaKs, stanje);
    }

    private static Artikl podaciArtiklaStana(Scanner unos) {
        long id = unos.nextLong();
        unos.nextLine();
        String naslov = unos.nextLine();
        String opis = unos.nextLine();
        int kvadratura = unos.nextInt();
        BigDecimal cijena = BigDecimal.valueOf(unos.nextDouble());
        Stanje stanje = odabirStanja(unos);
        return new Stan(id, naslov, opis, cijena, stanje, kvadratura);
    }

    /**
     * Uzima sve unesene podatke o uslugama i sprema ih u artikl
     *
     * @param unos trazi korisnika unos
     * @return vraca podatke usluge
     */
    private static Artikl podaciArtiklaUsluge(Scanner unos) {
        long id = unos.nextLong();
        unos.nextLine();
        String naslov = unos.nextLine();
        String opis = unos.nextLine();
        BigDecimal cijena = BigDecimal.valueOf(unos.nextDouble());
        unos.nextLine();
        return new Usluga(id, naslov, opis, cijena);
    }

    /**
     * Uzima sve podatke o privatnog korisnika i sprema u korisnike
     *
     * @param unos trazi korisnika unos
     * @return vraca podatke privatnog korisnika
     */
    private static Korisnik podaciPrivatnogKorisnika(Scanner unos) {
        String ime = unos.nextLine();
        String prezime = unos.nextLine();
        String email = unos.nextLine();
        String telefon = unos.nextLine();
        return new PrivatniKorisnik(email, telefon, ime, prezime);
    }

    /**
     * Uzima sve podatke o poslovnog korisnika i sprema u korisnike
     *
     * @param unos trazi korisnika unos
     * @return vraca podatke poslovnog korisnika
     */
    private static Korisnik podaciPoslovnogKorisnika(Scanner unos) {
        String naziv = unos.nextLine();
        String email = unos.nextLine();
        String web = unos.nextLine();
        String telefon = unos.nextLine();
        return new PoslovniKorisnik(email, telefon, naziv, web);
    }
}
