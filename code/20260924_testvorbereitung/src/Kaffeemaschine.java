public class Kaffeemaschine {
    private boolean eingeschaltet;
    private double wasserFuellstand;
    private double wasserKapazitaet;
    private int bohnenFuellstand;
    private int bohnenKapazitaet;

    public Kaffeemaschine(boolean eingeschaltet, double wasserFuellstand, double wasserKapazitaet, int bohnenFuellstand, int bohnenKapazitaet) {
        setEingeschaltet(eingeschaltet);
        setBohnenKapazitaet(bohnenKapazitaet);
        setBohnenFuellstand(bohnenFuellstand);
        setWasserKapazitaet(wasserKapazitaet);
        setWasserFuellstand(wasserFuellstand);
    }

    public Kaffeemaschine() {
        eingeschaltet = true;
        wasserFuellstand = 0.0;
        wasserKapazitaet = 2000.0;
        bohnenFuellstand = 0;
        bohnenKapazitaet = 1000;
    }

    public void einschalten() {
        if(!eingeschaltet) {
            eingeschaltet = true;
            System.out.println("Kaffeemaschine wurde eingeschaltet.");
            return;
        }
        System.out.println("Kaffeemaschine ist bereits eingeschaltet.");
    }

    public void ausschalten() {
        if(eingeschaltet) {
            eingeschaltet = false;
            System.out.println("Kaffeemaschine wurde ausgeschaltet. Tschüss");
            return;
        }
        System.out.println("Kaffeemaschine ist bereits ausgeschaltet.");
    }

    public void wasserAuffuellen(double menge) {
        if(menge > 0) {
            setWasserFuellstand(wasserFuellstand + menge);
            return;
        }
        printFehlermeldung("Menge (wasserAuffuellen)");
    }

    public void bohnenAuffuellen(int menge) {
        if(menge > 0) {
            setBohnenFuellstand(bohnenFuellstand + menge);
            return;
        }
        printFehlermeldung("Menge (bohnenAuffuellen)");
    }

    public void kochen(String art) {
        if(!eingeschaltet && wasserFuellstand < 200) {
            printFehlermeldung("Kochen");
            return;
        }

        switch (art.toLowerCase()) {
            case "espresso" -> pruefeKochen("Espresso", 30, 10);
            case "latte" -> pruefeKochen("Latte", 100, 20);
            case "capuccino" -> pruefeKochen("Capuccino", 120, 25);
        }
    }

    public void print() {
        System.out.println("Wasserfüllstand: " +  wasserFuellstand);
        System.out.println("Wasserkapazität: " +  wasserKapazitaet);
        System.out.println("Bohnenfüllstand: " +  bohnenFuellstand);
        System.out.println("Bohnenkapazität: " +  bohnenKapazitaet);
    }

    private void pruefeKochen(String art, double wasserBedarf, int bohnenBedarf) {
        if(wasserFuellstand >= wasserBedarf && bohnenFuellstand >= bohnenBedarf) {
            wasserFuellstand -= wasserBedarf;
            bohnenFuellstand -= bohnenBedarf;
            System.out.println(art + " wird gekocht. Vorsicht heiß!");
        } else {
            printFehlermeldung("Kochen");
        }
    }

    public boolean isEingeschaltet() {
        return eingeschaltet;
    }

    public void setEingeschaltet(boolean eingeschaltet) {
        this.eingeschaltet = eingeschaltet;
    }

    public double getWasserFuellstand() {
        return wasserFuellstand;
    }

    public void setWasserFuellstand(double wasserFuellstand) {
        if (wasserFuellstand >= 0 && wasserFuellstand <= wasserKapazitaet) {
            this.wasserFuellstand = wasserFuellstand;
        } else {
            printFehlermeldung("Wasserfüllstand");
        }
    }

    public double getWasserKapazitaet() {
        return wasserKapazitaet;
    }

    public void setWasserKapazitaet(double wasserKapazitaet) {
        if (wasserKapazitaet >= 500 && wasserKapazitaet <= 2000) {
            this.wasserKapazitaet = wasserKapazitaet;
        } else {
            printFehlermeldung("Wasserkapazität");
        }
    }

    public int getBohnenFuellstand() {
        return bohnenFuellstand;
    }

    public void setBohnenFuellstand(int bohnenFuellstand) {
        if (bohnenFuellstand >= 0 && bohnenFuellstand <= bohnenKapazitaet) {
            this.bohnenFuellstand = bohnenFuellstand;
        } else {
            printFehlermeldung("Bohnenfüllstand");
        }
    }

    public int getBohnenKapazitaet() {
        return bohnenKapazitaet;
    }

    public void setBohnenKapazitaet(int bohnenKapazitaet) {
        if (bohnenKapazitaet >= 100 && bohnenKapazitaet <= 1000) {
            this.bohnenKapazitaet = bohnenKapazitaet;
        } else {
            printFehlermeldung("Bohnenkapazität");
        }
    }

    private void printFehlermeldung(String eigenschaft) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "Fehler: " + eigenschaft +  " ungültig." + ANSI_RESET);
    }
}
