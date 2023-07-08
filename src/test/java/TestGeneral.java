import org.junit.*;
import static org.junit.Assert.*;

public class TestGeneral {
    private Rational rational1;
    private Rational rational2;
    private Rational rational3;

    @Before
    public void initialize() {
        rational1 = new Rational(3, 4);
        rational2 = new Rational(6, 8);
        rational3 = new Rational(2, -3);
    }

    @After
    public void drop() {
        rational1 = null;
        rational2 = null;
        rational3 = null;
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
    public void testReduce() {
        assertEquals("Test reduce", 3, rational2.getNumerator());
        assertEquals("Test reduce", 4, rational2.getDenominator());
    }

    @Test
    public void testToString() {
        assertEquals("Fraction couldn't to string", "3/4", rational1.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Rational rational2 = new Rational(0, 1);
        rational1.divide(rational2);
    }

    @Test
    public void testSimplifyMinuses() {
        assertEquals("Cannot simplify minuses", -2, rational3.getNumerator());
        assertEquals("Cannot simplify minuses", 3, rational3.getDenominator());
    }
}