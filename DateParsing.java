import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParsing {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.println("Enter a date (yyyy-MM-dd):");
            String dateStr = scanner.next();

            try {
                LocalDate date = LocalDate.parse(dateStr, formatter);
                System.out.println("Parsed date: " + date);
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please enter a date in the format yyyy-MM-dd.");
            }
        }
    }
}
