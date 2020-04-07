package hr.java.vjezbe.sortiranje;

import hr.java.vjezbe.entitet.Artikl;

import java.util.Comparator;

public class ArtiklSorter implements Comparator<Artikl> {

    @Override
    public int compare(Artikl artikl1, Artikl artikl2) {
        int usporedbaNaslova = artikl1.getNaslov().compareTo(artikl2.getNaslov());
        if (usporedbaNaslova == 0) {
            return artikl1.getOpis().compareTo(artikl2.getOpis());
        } else {
            return usporedbaNaslova;
        }
    }
}