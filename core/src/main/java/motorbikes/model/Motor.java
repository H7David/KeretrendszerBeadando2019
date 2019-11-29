package motorbikes.model;

import motorbikes.exception.RosszRendszam;

import java.time.LocalDate;

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

    public void setUzembehelyezes_datuma(LocalDate uzembehelyezes_datuma) {
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

    public void setEvjarat(int evjarat) {
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

}
