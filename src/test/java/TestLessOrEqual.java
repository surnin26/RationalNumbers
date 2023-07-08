import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLessOrEqual {

    private Rational rational2;
    private Rational rational5;
    private Rational rational1;
    private Rational rational3;

    @Before
    public void initialize() {
        rational1 = new Rational(3, 4);
        rational2 = new Rational(5, 2);
        rational3 = new Rational(7, 8);
        rational5 = new Rational(6, 8);
    }

    @After
    public void drop() {
        rational1 = null;
        rational2 = null;
        rational5 = null;
    }

    @Test
    public void testLessTrue() {
        assertTrue("Test less true fall", rational1.less(rational2));
    }

    @Test
    public void testLessFalse() {
        assertFalse("Test less false fall", rational2.less(rational1));
    }

    @Test
    public void testLessOrEqualTrue() {
        assertTrue("Fraction less or equal don't true", rational3.lessOrEqual(rational5));
    }

    @Test
    public void testLessOrEqualFalse() {
        assertFalse("Fraction less or equal don't false", rational2.lessOrEqual(rational1));
    }
}
