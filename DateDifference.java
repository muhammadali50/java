import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class DateDifference {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the first date (yyyy-MM-dd):");
            String date1 = scanner.nextLine();
            LocalDate startDate = LocalDate.parse(date1);

            System.out.println("Enter the second date (yyyy-MM-dd):");
            String date2 = scanner.nextLine();
            LocalDate endDate = LocalDate.parse(date2);

            Period period = Period.between(startDate, endDate);
            long days = period.getDays();

            System.out.println("The difference between the two dates is " + days + " days.");
        }
    }
}
