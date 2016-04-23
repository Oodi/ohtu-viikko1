package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaLukuJoukkoon(int luku) {
        if (!sisaltyyJoukkoon(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                kasvataTaulukko();
            }
            return true;
        }
        return false;
    }

    public boolean sisaltyyJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;

    }

    public boolean poistaLukuJoukosta(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                poistaIndeksista(i);
                return true;
            }
        }
        return false;
    }

    private void poistaIndeksista(int i) {
        for (int j = i; j < alkioidenLkm; j++) {
            ljono[j] = ljono[j + 1];
        }
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int joukonAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "";
        for (int i = 0; i < alkioidenLkm; i++) {
            if (i> 0) tuotos += ", ";
            tuotos += ljono[i];
        }
        return "{" + tuotos + "}";

    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(ljono, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            a.lisaaLukuJoukkoon(bTaulu[i]);
        }
        return a;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            if (!a.sisaltyyJoukkoon(bTaulu[i])) {
                a.poistaLukuJoukosta(bTaulu[i]);
            }
        }
        return a;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            a.poistaLukuJoukosta(bTaulu[i]);
        }
        return a;
    }

    private void kasvataTaulukko() {
        int[] taulukkoNew = new int[ljono.length + kasvatuskoko];
        kopioiTaulukko(ljono, taulukkoNew);
        ljono = taulukkoNew;
    }

}
