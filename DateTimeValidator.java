import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeValidator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            System.out.println("Enter a date and time (yyyy-MM-dd HH:mm):");
            String input = scanner.next();

            try {
                LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
                if (dateTime.isAfter(LocalDateTime.now())) {
                    System.out.println("Valid date and time: " + input);
                } else {
                    System.out.println("Error: Date and time must be in the future.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date and time format. Please use yyyy-MM-dd HH:mm.");
            }
        }
    }
}
