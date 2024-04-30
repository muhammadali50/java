import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonalCalendar {
    private static List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            System.out.println("1. Add event");
            System.out.println("2. Edit event");
            System.out.println("3. Delete event");
            System.out.println("4. View events");
            System.out.println("5. Exit");

            System.out.println("Choose an option:");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addEvent(scanner, dateFormatter, timeFormatter);
                    break;
                case 2:
                    editEvent(scanner, dateFormatter, timeFormatter);
                    break;
                case 3:
                    deleteEvent(scanner);
                    break;
                case 4:
                    viewEvents();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void addEvent(Scanner scanner, DateTimeFormatter dateFormatter, DateTimeFormatter timeFormatter) {
        System.out.println("Enter event name:");
        String name = scanner.next();

        System.out.println("Enter event date (yyyy-MM-dd):");
        String dateStr = scanner.next();
        LocalDate date = LocalDate.parse(dateStr, dateFormatter);

        System.out.println("Enter event time (HH:mm):");
        String timeStr = scanner.next();
        LocalTime time = LocalTime.parse(timeStr, timeFormatter);

        Event event = new Event(name, date, time);
        events.add(event);
        System.out.println("Event added successfully");
    }

    private static void editEvent(Scanner scanner, DateTimeFormatter dateFormatter, DateTimeFormatter timeFormatter) {
        System.out.println("Enter event name to edit:");
        String name = scanner.next();
        Event eventToEdit = findEvent(name);
        if (eventToEdit != null) {
            System.out.println("Enter new event date (yyyy-MM-dd):");
            String dateStr = scanner.next();
            LocalDate date = LocalDate.parse(dateStr, dateFormatter);

            System.out.println("Enter new event time (HH:mm):");
            String timeStr = scanner.next();
            LocalTime time = LocalTime.parse(timeStr, timeFormatter);

            eventToEdit.setDate(date);
            eventToEdit.setTime(time);
            System.out.println("Event edited successfully");
        } else {
            System.out.println("Event not found");
        }
    }

    private static void deleteEvent(Scanner scanner) {
        System.out.println("Enter event name to delete:");
        String name = scanner.next();

        Event eventToDelete = findEvent(name);
        if (eventToDelete != null) {
            events.remove(eventToDelete);
            System.out.println("Event deleted successfully");
        } else {
            System.out.println("Event not found");
        }
    }

    private static void viewEvents() {
        for (Event event : events) {
            System.out.println(event.getName() + " - " + event.getDate() + " " + event.getTime());
        }
    }

    private static Event findEvent(String name) {
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }
}

class Event {
    private String name;
    private LocalDate date;
    private LocalTime time;

    public Event(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
