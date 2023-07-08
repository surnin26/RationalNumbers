import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLimit {

    private Rational rational;

    @Before
    public void initialize() {
        rational = new Rational(3, 4);
    }

    @After
    public void drop() {
        rational = null;
    }

    @Test
    public void testLimitValueForZeroNumerator() {
        rational.setNumerator(0);
        assertEquals("Couldn't create zero for zero numerator and zero denominator", "0", rational.toString());
    }

    @Test
    public void testLimitValueFor1Numerator() {
        rational.setNumerator(1);
        rational.setDenominator(1);
        assertEquals("Couldn't create 1 for numerator", 1, rational.getNumerator());
        assertEquals("Couldn't create 1 for numerator", 1, rational.getDenominator());
    }

    @Test
    public void testLimitValueForMinus1Numerator() {
        rational.setNumerator(-1);
        assertEquals("Couldn't create minus fraction numerator", -1, rational.getNumerator());
        assertEquals("Couldn't create minus fraction denominator", 4, rational.getDenominator());

    }
}
