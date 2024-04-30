import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;

public class HolidayCalendar {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a year:");
            int year = scanner.nextInt();

            System.out.println("Major holidays in " + year + ":");

            LocalDate newYearsDay = LocalDate.of(year, 1, 1);
            System.out.println("New Year's Day: " + newYearsDay);

            LocalDate christmas = LocalDate.of(year, 12, 25);
            System.out.println("Christmas: " + christmas);

            int thanksgivingDay = 4;
            int weekOfMonth = 4;
            Month month = Month.NOVEMBER;
            int day = getDayOfWeek(year, month, weekOfMonth, thanksgivingDay);
            LocalDate thanksgiving = LocalDate.of(year, month, day);
            System.out.println("Thanksgiving: " + thanksgiving);
        }
    }

    private static int getDayOfWeek(int year, Month month, int weekOfMonth, int dayOfWeek) {
        int firstDay = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int offset = (dayOfWeek - firstDay) % 7;
        return 1 + (weekOfMonth - 1) * 7 + offset;
    }
}
