import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a time in 24-hour format (HH:mm):");
            String time = scanner.next();

            LocalTime localTime = LocalTime.parse(time);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

            String convertedTime = localTime.format(formatter);

            System.out.println("The time in 12-hour format is: " + convertedTime);
        }
    }
}
