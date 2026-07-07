public class Auto {
    private String marke;
    private int ps;

    public Auto(String marke, int ps) {
        setMarke(marke);
        setPs(ps);
    }

    public Auto() {
        marke = "Dacia";
        ps = 35;
    }

    public void print() {
        System.out.println("#######################################");
        System.out.println("Marke: " + marke);
        System.out.println("PS: " + ps);
        System.out.println("#######################################");
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getMarke() {
        return marke;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPs() {
        return ps;
    }
}
