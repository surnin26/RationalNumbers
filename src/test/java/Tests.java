import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    private Rational r1;
    private Rational r2;
    private Rational r3;
    private Rational r4;
    private Rational r5;
    private Rational r6;
    private Rational r7;
    private Rational r8;
    private Rational r9;


    @Before
    public void initialize() {
        r1 = new Rational(3, 4);
        r2 = new Rational(5, 2);
        r3 = new Rational(7, 8);
        r4 = new Rational(6, 8);
        r5 = new Rational(-2, 5);
        r6 = new Rational(-3, 7);
        r7 = new Rational(7, 8);
        r8 = new Rational(-12, 24);
        r9 = new Rational(-1, 2);
    }

    @After
    public void drop() {
        r1 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        r5 = null;
        r6 = null;
        r7 = null;
        r8 = null;
        r9 = null;
    }

    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testConstructorWithDenominatorZero() {
        Rational r = new Rational(3, 0);
    }

    @Test
    public void testEquals() {
        assertTrue("3/4 == 6/8", r1.equals(r4));
        assertFalse("3/4 != 5/2", r1.equals(r2));
        assertFalse("3/4 != 7/8", r1.equals(r3));
        assertFalse("7/8 != 6/8", r3.equals(r4));
        assertTrue("3/4 == 3/4", r1.equals(r1));
        assertFalse("-2/5 != -3/7", r5.equals(r6));
        assertTrue("-1/2 == -1/2", r8.equals(r9));
    }

    @Test
    public void testPlus() {
        Rational result1 = r1.plus(r2);
        Rational result2 = r1.plus(r5);
        Rational result3 = r5.plus(r6);
        assertEquals(13, result1.getNumerator());
        assertEquals(4, result1.getDenominator());
        assertEquals(7, result2.getNumerator());
        assertEquals(20, result2.getDenominator());
        assertEquals(-29, result3.getNumerator());
        assertEquals(35, result3.getDenominator());
    }

    @Test
    public void testMinus() {
        Rational result = r1.minus(r2);
        Rational result2 = r3.minus(r5);
        Rational result3 = r5.minus(r6);
        assertEquals(-7, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals(51, result2.getNumerator());
        assertEquals(40, result2.getDenominator());
        assertEquals(1, result3.getNumerator());
        assertEquals(35, result3.getDenominator());
    }

    @Test
    public void testMultiply() {
        Rational result = r1.multiply(r2);
        Rational result2 = r3.multiply(r5);
        Rational result3 = r5.multiply(r6);
        assertEquals(15, result.getNumerator());
        assertEquals(8, result.getDenominator());
        assertEquals(-7, result2.getNumerator());
        assertEquals(20, result2.getDenominator());
        assertEquals(6, result3.getNumerator());
        assertEquals(35, result3.getDenominator());
    }

    @Test
    public void testDivide() {
        Rational result1 = r1.divide(r2);
        Rational result2 = r1.divide(r5);
        Rational result3 = r5.divide(r6);
        assertEquals(3, result1.getNumerator());
        assertEquals(10, result1.getDenominator());
        assertEquals(-15, result2.getNumerator());
        assertEquals(8, result2.getDenominator());
        assertEquals(14, result3.getNumerator());
        assertEquals(15, result3.getDenominator());
    }

    @Test
    public void testReduce() {
        assertEquals(3, r4.getNumerator());
        assertEquals(4, r4.getDenominator());
        assertEquals(-1, r8.getNumerator());
        assertEquals(2, r8.getDenominator());
    }

    @Test
    public void testLess() {
        assertTrue("3/4 < 5/2", r1.less(r2));
        assertFalse("5/2 !< 3/4", r2.less(r1));
        assertFalse("-14/35 !< -15/35", r5.less(r6));
    }

    @Test
    public void testLessOrEqual() {
        assertTrue("7/8 == 7/8", r3.lessOrEqual(r7));
        assertFalse("5/2 !<= 3/4", r2.lessOrEqual(r1));
        assertTrue("6/8 < 7/8", r4.lessOrEqual(r3));
        assertFalse("-14/35 !<= -15/35", r5.less(r6));

    }

//    @Test
//    public void testGetGCD() {
//        assertEquals("GCD 6/8 is 2", 2, r4.getGCD()); // private
//    }

    @Test
    public void testToString() {
        assertEquals("Fraction to string", "3/4", r1.toString());
        assertEquals("Fraction to string", "7/8", r3.toString());
        assertEquals("Fraction to string", "-1/2", r8.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Rational r2 = new Rational(0, 1);
        r1.divide(r2);
    }
}