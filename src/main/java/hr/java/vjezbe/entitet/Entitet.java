package hr.java.vjezbe.entitet;

public abstract class Entitet {
    long id;

    public Entitet(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
