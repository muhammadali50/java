import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReminderSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a date and time for the reminder (yyyy-MM-dd HH:mm):");
            String dateTimeStr = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime reminderTime = LocalDateTime.parse(dateTimeStr, formatter);

            System.out.println("Enter a reminder message:");
            String message = scanner.nextLine();

            Timer timer = new Timer();
            timer.schedule(new ReminderTask(message), getDelayUntilReminder(reminderTime));

            System.out.println("Reminder scheduled for " + reminderTime.format(formatter));
        }
    }

    private static long getDelayUntilReminder(LocalDateTime reminderTime) {
        LocalDateTime now = LocalDateTime.now();
        long delay = java.time.Duration.between(now, reminderTime).toMillis();
        return delay;
    }
}

class ReminderTask extends TimerTask {
    private String message;

    public ReminderTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Reminder: " + message);
    }
}
