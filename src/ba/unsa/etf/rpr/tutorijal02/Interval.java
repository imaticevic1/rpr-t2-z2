package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTocka, krajnjaTocka;
    boolean daLiPocetna, daLiKrajnja;

    public Interval(double poc, double kraj, boolean dalipoc, boolean dalikraj) {
        if (poc > kraj) throw new IllegalArgumentException("");
        pocetnaTocka = poc;
        krajnjaTocka = kraj;
        daLiPocetna = dalipoc;
        daLiKrajnja = dalikraj;
    }

    public Interval() {
        pocetnaTocka = krajnjaTocka = 0;
        daLiKrajnja = daLiPocetna = false;
    }

    public boolean isIn(double tocka) {
        if (tocka >= pocetnaTocka && tocka <= krajnjaTocka) {
            if (!daLiPocetna && tocka == pocetnaTocka) return false;
            if (!daLiKrajnja && tocka == krajnjaTocka) return false;
            return true;
        }
        return false;
    }

    public boolean isNull() {
        if (pocetnaTocka == 0 && krajnjaTocka == 0 && daLiKrajnja == false && daLiPocetna == false) return true;
        return false;
    }

    public Interval intersect(Interval i) {
        double pocetna = pocetnaTocka, krajnja = krajnjaTocka;
        boolean dalipoc = false, dalikraj = false;
        if (i.isIn(pocetnaTocka)) {
            pocetna = pocetnaTocka;
            dalipoc = daLiPocetna;
        }
        if (i.isIn(krajnjaTocka)) {
            krajnja = krajnjaTocka;
            dalikraj = daLiKrajnja;
        }
        if (isIn(i.krajnjaTocka)) {
            krajnja = i.krajnjaTocka;
            dalikraj = i.daLiKrajnja;
        }
        if(isIn(i.pocetnaTocka)){
            pocetna = i.pocetnaTocka;
            dalipoc = i.daLiPocetna;
        }
        if(i.isNull()) return new Interval();
        if(pocetna < krajnja) return new Interval(pocetna, krajnja, dalipoc, dalikraj);
        return new Interval(krajnja, pocetna, dalikraj, dalipoc);
    }
    public static Interval intersect(Interval i1, Interval i2) {
        return i1.intersect(i2);
    }
    public String toString(){
        String znak1 = "(", znak2 = ")";
        if(daLiPocetna) znak1 = "[";
        if(daLiKrajnja) znak2 = "]";
        if(isNull()) return "()";
        return znak1 + pocetnaTocka + "," + krajnjaTocka + znak2;
    }
    public boolean equals (Interval i) {
        if(krajnjaTocka == i.krajnjaTocka && pocetnaTocka == i.pocetnaTocka && daLiKrajnja == i.daLiKrajnja && daLiPocetna == i.daLiPocetna)
            return true;
        return false;
    }
    public static void main (String[] args){}



}
