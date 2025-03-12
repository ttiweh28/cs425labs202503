import static org.junit.Assert.*;

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
    public void computeCorrectMortgageForArchitect() {
        int birthYear = 1967;
        int experienceYears = 5;
        int dependents = 2;
        double salary = 3000;
        boolean hasLoan = false;
        double loanAmount = 0;
        String profession = "Architect";

        double result = mc.computeMaxMortgage(birthYear, experienceYears, dependents, salary, hasLoan, loanAmount, profession);
        assertEquals("Expected mortgage calculation for Architect", 180000, result, 0.001);
    }

    @Test
    public void shouldReturnZeroForUnderageApplicant() {
        // Ensuring age < 18
        int birthYear = 2010;
        double result = mc.computeMaxMortgage(birthYear, 5, 2, 3000, false, 0, "Architect");
        assertEquals("Expected 0 mortgage for underage applicant", 0, result, 0.001);
    }

    @Test
    public void shouldCalculateMortgageForDeveloper() {
        double result = mc.computeMaxMortgage(1977, 12, 2, 4000, true, 2000, "Developer");
        assertEquals("Expected mortgage for Developer with 4000 salary and loan", 220000, result, 0.001);
    }

    @Test
//    public void test4() {
//        double result = mc.computeMaxMortgage(1954, 5, 12, 5500, false, 0, "Professor");
//        assertEquals(280000, result, 0.001);
//    }
    public void shouldCalculateMortgageForProfessor() {
        double result = mc.computeMaxMortgage(1954, 5, 12, 5500, false, 0, "Professor");
        assertEquals("Expected mortgage for Professor with 5500 salary", 280000, result, 0.001);
    }
}

