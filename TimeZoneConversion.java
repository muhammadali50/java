import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConversion {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a date and time (yyyy-MM-dd HH:mm):");
            String dateTimeStr = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, formatter);

            System.out.println("Enter the source time zone (e.g., UTC):");
            String sourceTimeZone = scanner.next();

            System.out.println("Enter the target time zone (e.g., America/Los_Angeles):");
            String targetTimeZone = scanner.next();

            ZoneId sourceZoneId = ZoneId.of(sourceTimeZone);
            ZoneId targetZoneId = ZoneId.of(targetTimeZone);

            ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceZoneId);
            ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);

            System.out.println("Date and time in " + targetTimeZone + ": " + targetZonedDateTime.format(formatter));
        }
    }
}
