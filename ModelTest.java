public class ModelTest {
    static void check(String label, String got, String expected) {
        System.out.println((got.equals(expected) ? "OK   " : "FAIL ") + label + " -> " + got);
        if (!got.equals(expected)) System.exit(1);
    }

    public static void main(String[] a) {
        CalcModel m = new CalcModel();
        check("inicio", m.getValue(), "1");
        m.multiplyBy("111");
        check("1 x 111", m.getValue(), "111");
        m.multiplyBy("111");
        check("x 111", m.getValue(), "12321");
        m.reset();
        check("clear", m.getValue(), "1");
        m.multiplyBy("5");
        check("despues de clear x5 (no da 0)", m.getValue(), "5");
        m.reset();
        m.multiplyBy("0.1");
        m.multiplyBy("0.1");
        check("0.1 x 0.1 exacto", m.getValue(), "0.01");
        m.reset();
        m.multiplyBy("3,14159265358979323846");
        m.multiplyBy("2.71828182845904523536");
        check("flotantes largos", m.getValue(), "8.5397342226735670654554622909226073039456");
        m.reset();
        for (int i = 0; i < 10; i++) m.multiplyBy("1.5");
        check("1.5^10", m.getValue(), "57.6650390625");
        try { m.multiplyBy("abc"); System.out.println("FAIL sin excepcion"); System.exit(1); }
        catch (NumberFormatException e) { System.out.println("OK   entrada invalida lanza NumberFormatException"); }
    }
}
