import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        String inputDate = null;
        String description = null;

        if(args.length < 2 || args.length > 2){
            System.out.println("Provide 2 arguments: date in format --MM-dd and " +
                    "event description");
            System.exit(1);
        }else{
            inputDate = args[0];
            description = args[1];
        }

        //Tarkistetaan, että päivämäärä on oikeassa muodossa
        MonthDay mDay = null;
        try{
            mDay = MonthDay.parse(inputDate, DateTimeFormatter.ofPattern("--MM-dd"));

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

        //Tulostetaan tapahtumat, jotka ovat samana päivänä kuin syötetty päivämäärä
        boolean foundEvent = false;
        for(Event e : events){
            if(MonthDay.from(e.getDate()).equals(mDay)){
                System.out.println(e.getDescription());
                foundEvent = true;
            }
        }

        if(!foundEvent){
            System.out.println("No events found on this date");
        }

    }
}