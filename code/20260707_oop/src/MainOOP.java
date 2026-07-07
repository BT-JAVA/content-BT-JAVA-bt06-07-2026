public class MainOOP {
    public static void main(String[] args) {
        Auto a1 = new Auto("VW", 100);
        Auto a2 = new Auto();

        a1.print();

        a2.print();
        a2.setPs(135);
        a2.print();
    }
}
