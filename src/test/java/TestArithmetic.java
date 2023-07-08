import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArithmetic {

    private Rational rational1;
    private Rational rational2;
    private Rational rational3;
    private Rational rational4;

    @Before
    public void initialize() {
        rational1 = new Rational(3, 4);
        rational2 = new Rational(5, 2);
        rational3 = new Rational(0, 1);
        rational4 = new Rational(-5, 9);
    }

    @After
    public void drop() {
        rational1 = null;
        rational2 = null;
        rational3 = null;
        rational4 = null;
    }

    @Test
    public void testPlus() {
        Rational result1 = rational1.plus(rational2);
        assertEquals("Wrong test plus", 13, result1.getNumerator());
        assertEquals("Wrong test plus", 4, result1.getDenominator());
    }

    @Test
    public void testMinus() {
        Rational result = rational1.minus(rational2);
        Rational result2 = rational4.minus(rational1);
        assertEquals("Wrong test minus", -7, result.getNumerator());
        assertEquals("Wrong test minus", 4, result.getDenominator());
        assertEquals("Wrong test minus", -47, result2.getNumerator());
        assertEquals("Wrong test minus", 36, result2.getDenominator());

    }

    @Test
    public void testMultiply() {
        Rational result = rational1.multiply(rational2);
        assertEquals("Wrong test multiply", 15, result.getNumerator());
        assertEquals("Wrong test multiply", 8, result.getDenominator());
    }

    @Test
    public void testDivide() {
        Rational result1 = rational1.divide(rational2);
        assertEquals("Wrong test divide", 3, result1.getNumerator());
        assertEquals("Wrong test divide", 10, result1.getDenominator());
    }
}
