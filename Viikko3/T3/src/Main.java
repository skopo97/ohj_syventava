import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Category category = new Category("apple", "macOS");

        Event[] events = {
                new Event(LocalDate.of(2024,9,16), "macOS 15 Sequoia released", category),
                new Event(LocalDate.of(2023,9,26), "macOS 14 Sonoma released", category),
                new Event(LocalDate.of(2022,10,24), "macOS 13 Ventura released", category),
                new Event(LocalDate.of(2021,10,25), "macOS 12 Monterey released", category),
                new Event(LocalDate.of(2020,11,12), "macOS 11 Big Sur released", category),
        };

        for (Event event : events) {
            System.out.println(formatPrint(event));
        }

        String[] operatingSystems = new String[events.length];
        for(int i = 0; i < events.length; i++){
            operatingSystems[i] = getOsName(events[i].getDescription());
        }

        Arrays.sort(operatingSystems);
        System.out.print("in alphabetical order: ");
        System.out.println(String.join(", ", operatingSystems));
    }

    private static String formatPrint(Event event){
        String description = event.getDescription();
        String versionNumber = description.substring(6, 8);
        String versionName = description.substring(9, description.indexOf(" released"));
        String dayOfWeek = event.getDate().getDayOfWeek().toString().toLowerCase();
        dayOfWeek = dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
        return "macOS " + versionNumber + " " + versionName + " was released on a " + dayOfWeek + ".";
    }

    private static String getOsName(String description){
        return description.substring(9, description.indexOf(" released"));
    }


}

