package hr.java.vjezbe.sortiranje;

import java.util.Comparator;

public class ArtiklSorter implements Comparator<String> {

    @Override
    public int compare(String artik1, String artikl2) {
        return artik1.compareTo(artikl2);
    }

}
