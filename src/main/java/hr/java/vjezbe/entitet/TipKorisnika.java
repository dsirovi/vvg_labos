package hr.java.vjezbe.entitet;

public enum  TipKorisnika {
    PRIVATNI("1", "privatni"),
    POSLOVNI("2", "poslovni");

    private final String id;
    private final String naziv;

    TipKorisnika(String id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public String getId() {
        return id;
    }
}
