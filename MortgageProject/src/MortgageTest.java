import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MortgageTest {

    private MortgageCalculator mc;

    @Before
    public void setUp() {
        mc = new MortgageCalculator();
    }

    @Test
    public void test1() {
        double result = mc.computeMaxMortgage(1967, 5, 2, 3000, false, 0, "Architect");
        assertEquals(180000, result, 0.001);
    }

    @Test
    public void test2() {
        // Ensuring age < 18
        double result = mc.computeMaxMortgage(2010, 5, 2, 3000, false, 0, "Architect");
        assertEquals(0, result, 0.001);
    }

    @Test
    public void test3() {
        double result = mc.computeMaxMortgage(1977, 12, 2, 4000, true, 2000, "Developer");
        assertEquals(220000, result, 0.001); // Income is 5880, falls in the 5000+ range.
    }

    @Test
    public void test4() {
        double result = mc.computeMaxMortgage(1954, 5, 12, 5500, false, 0, "Professor");
        assertEquals(280000, result, 0.001);
    }
}

