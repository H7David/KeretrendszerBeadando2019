package motorbikes.model;

import motorbikes.exception.RosszRendszam;
import motorbikes.exception.RosszEvjarat;
import motorbikes.exception.RosszDatum;
import java.time.LocalDate;
import java.util.Objects;

public class Motor {

    private String marka;
    private String tipus;
    private String rendszam;
    private LocalDate uzembehelyezes_datuma;
    private int loero;
    private int suly;
    private int sebessegek_szama;
    private int szalithatoszemelyek_szama;
    private int kerek_atmero;
    private int evjarat;
    private String szinkod;
    private Allapot allapot;


    public Motor(){}

    public String getMarka() {
        return marka;
    }

    public Motor(String marka, String tipus, String rendszam,
                 LocalDate uzembehelyezes_datuma, int loero, int suly, int sebessegek_szama,
                 int szalithatoszemelyek_szama, int kerek_atmero, int evjarat, String szinkod,
                 Allapot allapot)throws RosszDatum , RosszRendszam, RosszEvjarat {
        this.marka = marka;
        this.tipus = tipus;
       setRendszam(rendszam);
        setUzembehelyezes_datuma(uzembehelyezes_datuma);
        this.loero = loero;
        this.suly = suly;
        this.sebessegek_szama = sebessegek_szama;
        this.szalithatoszemelyek_szama = szalithatoszemelyek_szama;
        this.kerek_atmero = kerek_atmero;
        setEvjarat(evjarat);
        this.szinkod = szinkod;
        this.allapot = allapot;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) throws RosszRendszam {
        if(rendszam.matches("^\\w\\w\\w-\\d\\d\\d$")){
            this.rendszam = rendszam;
        }
        else{
            throw new RosszRendszam(rendszam);
        }
    }

    public LocalDate getUzembehelyezes_datuma() {
        return uzembehelyezes_datuma;
    }

    public void setUzembehelyezes_datuma(LocalDate uzembehelyezes_datuma) throws RosszDatum {
        if(uzembehelyezes_datuma.isBefore(LocalDate.MIN) ||uzembehelyezes_datuma.isAfter(LocalDate.now())){
            throw new RosszDatum(uzembehelyezes_datuma.toString());}
        this.uzembehelyezes_datuma = uzembehelyezes_datuma;
    }
    public int getLoero() {
        return loero;
    }

    public void setLoero(int loero) {
        this.loero = loero;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public int getSebessegek_szama() {
        return sebessegek_szama;
    }

    public void setSebessegek_szama(int sebessegek_szama) {
        this.sebessegek_szama = sebessegek_szama;
    }

    public int getSzalithatoszemelyek_szama() {
        return szalithatoszemelyek_szama;
    }

    public void setSzalithatoszemelyek_szama(int szalithatoszemelyek_szama) {
        this.szalithatoszemelyek_szama = szalithatoszemelyek_szama;
    }

    public int getKerek_atmero() {
        return kerek_atmero;
    }

    public void setKerek_atmero(int kerek_atmero) {
        this.kerek_atmero = kerek_atmero;
    }

    public int getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(int evjarat)throws RosszEvjarat  {
            if(evjarat<0 || evjarat> LocalDate.now().getYear()){
                throw new RosszEvjarat(String.valueOf(evjarat));
            }
        this.evjarat = evjarat;
    }

    public String getSzinkod() {
        return szinkod;
    }

    public void setSzinkod(String szinkod) {
        this.szinkod = szinkod;
    }

    public Allapot getAllapot() {
        return allapot;
    }

    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }
    @Override
    public String toString() {
        return "Auto{" +
                "marka='" + marka + '\'' +
                ", tipus='" + tipus + '\'' +
                ", rendszam='" + rendszam + '\'' +
                ", uzembehelyezes_datuma=" + uzembehelyezes_datuma +
                ", loero=" + loero +
                ", suly=" + suly +
                ", sebessegek_szama=" + sebessegek_szama +
                ", szallithatoszemelyek_szsma=" + szalithatoszemelyek_szama +
                ", kerek_atmero=" + kerek_atmero +
                ", evjarat=" + evjarat +
                ", szinkod='" + szinkod + '\'' +
                ", allapot=" + allapot +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return loero == motor.loero &&
                suly == motor.suly &&
                sebessegek_szama == motor.sebessegek_szama&&
                szalithatoszemelyek_szama == motor.szalithatoszemelyek_szama &&
                kerek_atmero == motor.kerek_atmero &&
                evjarat == motor.evjarat &&
                Objects.equals(marka, motor.marka) &&
                Objects.equals(tipus, motor.tipus) &&
                Objects.equals(rendszam, motor.rendszam) &&
                Objects.equals(uzembehelyezes_datuma, motor.uzembehelyezes_datuma) &&
                Objects.equals(szinkod, motor.szinkod) &&
                allapot == motor.allapot;
    }

    @Override
    public int hashCode() { return Objects.hash(marka, tipus, rendszam, uzembehelyezes_datuma, loero, suly,
            sebessegek_szama , szalithatoszemelyek_szama , kerek_atmero, evjarat, szinkod, allapot); }
}
