import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        if(args.length < 2){
            System.out.println("Provide 2 arguments: date in format --MM-dd and " +
                    "event description");
            System.exit(1);
        }

        String date = null;
        String description = null;

        //Luetaan komentoriviparametrit
        try{
            date = args[0];
            description = args[1];
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Provide 2 arguments: date in format --MM-dd and " +
                    "event description");
        }

        //Tarkistetaan, että päivämäärä on oikeassa muodossa
        try{
            MonthDay mDay = MonthDay.parse(date, DateTimeFormatter.ofPattern("--MM-dd"));
            System.out.println("Formatted date: " + date);

        }catch(DateTimeParseException e){
            System.out.println("Invalid date, use format --MM-dd");
        }









        //Luodaan Category-olio
        Category category = new Category("apple", "macOS");
        //Luodaan Event-olioita
        Event[] events = {
                new Event(LocalDate.of(2024,9,16), "macOS 15 Sequoia released", category),
                new Event(LocalDate.of(2023,9,26), "macOS 14 Sonoma released", category),
                new Event(LocalDate.of(2022,10,24), "macOS 13 Ventura released", category),
                new Event(LocalDate.of(2021,10,25), "macOS 12 Monterey released", category),
                new Event(LocalDate.of(2020,11,12), "macOS 11 Big Sur released", category),
        };

    }
}