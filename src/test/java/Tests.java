import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    private Rational rational1;
    private Rational rational2;
    private Rational rational3;
    private Rational rational4;
    private Rational rational7;

    @Before
    public void initialize() {
        rational1 = new Rational(3, 4);
        rational2 = new Rational(5, 2);
        rational3 = new Rational(7, 8);
        rational4 = new Rational(6, 8);
        rational7 = new Rational(7, 8);
    }

    @After
    public void drop() {
        rational1 = null;
        rational2 = null;
        rational3 = null;
        rational4 = null;
        rational7 = null;
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
    public void testEqual() {
        assertEquals("Test equal with reduce", rational1, rational4);
    }
    @Test
    public void testNotEquals() {
        assertNotEquals("3/4 != 5/2", rational1, rational2);
    }

    @Test
    public void testPlus() {
        Rational result1 = rational1.plus(rational2);
        assertEquals("Test plus", 13, result1.getNumerator());
        assertEquals("Test plus", 4, result1.getDenominator());
    }

    @Test
    public void testMinus() {
        Rational result = rational1.minus(rational2);
        assertEquals("Test minus", -7, result.getNumerator());
        assertEquals("Test minus", 4, result.getDenominator());
    }

    @Test
    public void testMultiply() {
        Rational result = rational1.multiply(rational2);
        assertEquals("Test multiply", 15, result.getNumerator());
        assertEquals("Test multiply", 8, result.getDenominator());
    }

    @Test
    public void testDivide() {
        Rational result1 = rational1.divide(rational2);
        assertEquals("Test divide", 3, result1.getNumerator());
        assertEquals("Test divide", 10, result1.getDenominator());
    }

    @Test
    public void testReduce() {
        assertEquals("Test reduce", 3, rational4.getNumerator());
        assertEquals("Test reduce", 4, rational4.getDenominator());
    }

    @Test
    public void testLessTrue() {
        assertTrue("Test less true", rational1.less(rational2));
    }

    @Test
    public void testLessFalse() {
        assertFalse("Test less false", rational2.less(rational1));
    }

    @Test
    public void testLessOrEqualTrue() {
        assertTrue("Fraction less or equal true", rational3.lessOrEqual(rational7));
    }

    @Test
    public void testLessOrEqualFalse() {
        assertFalse("Fraction less or equal false", rational2.lessOrEqual(rational1));
    }

    @Test
    public void testToString() {
        assertEquals("Fraction to string", "3/4", rational1.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Rational r2 = new Rational(0, 1);
        rational1.divide(r2);
    }
}