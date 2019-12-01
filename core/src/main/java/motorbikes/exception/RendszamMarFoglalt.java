package motorbikes.exception;

public class RendszamMarFoglalt extends Throwable {
    public RendszamMarFoglalt (String rendszam) {
        super("A megadott rendszam mar szerepel az adatbázisunkban: "+rendszam);
    }
}
