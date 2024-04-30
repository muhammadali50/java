import java.time.LocalDateTime;
import java.time.Duration;

public class EventDuration {
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.of(2023, 5, 20, 9, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 5, 20, 12, 15);

        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println("Event duration: " + hours + " hours and " + minutes + " minutes");
    }
}
