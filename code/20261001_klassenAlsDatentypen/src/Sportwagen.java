public class Sportwagen {
    private String marke;
    private Person fahrer;

    public Sportwagen(String marke, Person fahrer) {
        this.marke = marke;
        this.fahrer = fahrer;
    }

    @Override
    public String toString() {
        return "Sportwagen{" +
                "marke='" + marke + '\'' +
                ", fahrer=" + fahrer +
                '}';
    }
}
