package prac5anotaciones.ejer1;

//@SuppressWarnings({"deprecation"})
public class TestAnotaciones {
    public static void main(String arg[]) throws Exception {
        new TestAnotaciones().testearYa();
        new TestAnotaciones().testearYa2();
    }

    @SuppressWarnings({"deprecation"})
    public void testearYa() {
        TestDeprecated t2 = new TestDeprecated();
        t2.hacer();
    }
    public void testearYa2() {
        TestDeprecated t2 = new TestDeprecated();
        t2.hacer();
    }
}
