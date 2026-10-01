public class Main {
    public static void main(String[] args) {
        testAufgabe1();
    }

    public static void testAufgabe1() {
        Person p1 = new Person("Max", "Mustermann");

        System.out.println(p1);

        Sportwagen s1 = new Sportwagen("VW", p1);

        System.out.println(s1);
    }
}
