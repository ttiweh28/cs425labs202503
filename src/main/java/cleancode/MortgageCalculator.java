package cleancode;



import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class MortgageCalculator {

        public double computeMaxMortgage(int yearOfBirth, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
            int age = calculateAge(yearOfBirth, month, day);
            if (age < 18) return 0;

            double totalIncome = married ? monthlyIncome + (monthlyIncomePartner * 0.94) : monthlyIncome;
            return determineMortgageAmount(totalIncome, profession);
        }

        private int calculateAge(int year, int month, int day) {
            LocalDate today = LocalDate.now();
            LocalDate birthday = LocalDate.of(year, month, day);
            return Period.between(birthday, today).getYears();
        }

        private double determineMortgageAmount(double income, String profession) {
            Set<String> highCategory = Set.of("Developer", "Architect", "Scrum master");
            Set<String> midCategory = Set.of("Tester", "System Administrator", "Technical writer");
            Set<String> topCategory = Set.of("Department head", "Professor");

            if (income >= 5000) {
                return getMortgageAmount(profession, 220000, 160000, 280000);
            } else if (income >= 3000) {
                return getMortgageAmount(profession, 180000, 140000, 250000);
            } else if (income >= 2000) {
                return getMortgageAmount(profession, 160000, 120000, 220000);
            }
            return 0;
        }

        private double getMortgageAmount(String profession, double high, double mid, double top) {
            if (Set.of("Developer", "Architect", "Scrum master").contains(profession)) return high;
            if (Set.of("Tester", "System Administrator", "Technical writer").contains(profession)) return mid;
            if (Set.of("Department head", "Professor").contains(profession)) return top;
            return 0;
        }
    }



