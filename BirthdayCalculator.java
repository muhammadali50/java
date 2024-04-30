import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class BirthdayCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your birth date (yyyy-MM-dd):");
            String birthDate = scanner.next();

            LocalDate birthday = LocalDate.parse(birthDate);
            LocalDate today = LocalDate.now();

            Period period = Period.between(birthday, today);
            int age = period.getYears();

            System.out.println("You are " + age + " years old.");
        }
    }
}
