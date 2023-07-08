import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestEqual {

    private Rational rational1;
    private Rational rational2;
    private Rational rational3;

    @Before
    public void initialize() {
        rational1 = new Rational(3, 4);
        rational2 = new Rational(5, 2);
        rational3 = new Rational(6, 8);
    }

    @After
    public void drop() {
        rational1 = null;
        rational2 = null;
        rational3 = null;
    }

    @Test
    public void testEqual() {
        assertEquals("Test equal with reduce", rational1, rational3);
    }
    @Test
    public void testNotEquals() {
        assertNotEquals("3/4 != 5/2", rational1, rational2);
    }
}
