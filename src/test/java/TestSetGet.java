import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSetGet {

    private Rational rational1;
    private Rational rational2;

    @Before
    public void initialize() {
        rational2 = new Rational(3, 4);
        rational1 = new Rational(1, 2);
    }

    @After
    public void drop() {
        rational2 = null;
        rational1 = null;
    }

    @Test
    public void testSetDenominator() {
        rational1.setDenominator(1);
        assertEquals("Set denominator couldn't set", 1, rational1.getDenominator());
    }

    @Test
    public void testReSetDenominator() {
        rational2.setDenominator(0);
        assertEquals("Denominator isn't re-set", 0, rational2.getDenominator());
    }

    @Test
    public void testSetNumerator() {
        rational1.setNumerator(5);
        assertEquals("Numerator isn't set", 5, rational1.getNumerator());
    }

    @Test
    public void testReSetNumerator() {
        rational2.setNumerator(5);
        assertEquals("Numerator isn't re-set", 5, rational2.getNumerator());
    }
}
