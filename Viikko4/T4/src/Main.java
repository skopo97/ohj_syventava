import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        String inputDate = null;
        String inputCategory = null;


        //Tarkistetaan, että syötettyjä parametreja on 2
        if(args.length < 2 || args.length > 2){
            System.out.println("Provide 2 arguments: date in format --MM-dd and " +
                    "event category");
            System.exit(1);
        }else{
            inputDate = args[0];
            inputCategory = args[1];
        }

        //Tarkistetaan, että päivämäärä on oikeassa muodossa
        MonthDay mDay = null;
        try{
            mDay = MonthDay.parse(inputDate, DateTimeFormatter.ofPattern("--MM-dd"));

        }catch(DateTimeParseException e){
            System.out.println("Invalid date, use format --MM-dd");
            System.exit(1);
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
                new Event(LocalDate.of(2020, 11, 12), "Apple announces new Macbooks with Apple Silicon", category),
        };


        //Tulostetaan tapahtumat, jotka ovat samana päivänä kuin syötetty päivämäärä
        //Tarkastetaan myös kategoria
        //Boolean arvolla voidaan tulostaa myös, jos tapahtumia ei löydy
        boolean foundEvent = false;
        int foundEvents = 0;
                
        for(Event e : events){
            if(MonthDay.from(e.getDate()).equals(mDay) &&
                    (e.getCategory().getPrimary().equals(inputCategory) ||
                    e.getCategory().toString().equals(inputCategory))){
                    foundEvents++;
            }
        }
        
        for(Event e : events){
            if(MonthDay.from(e.getDate()).equals(mDay) &&
                    (e.getCategory().getPrimary().equals(inputCategory) ||
                    e.getCategory().toString().equals(inputCategory))){

        if(foundEvents > 1){
            System.out.println(e.getDate().getYear() + " : " + e.getDescription());
        }else{
            System.out.println(e.getDescription());
        }
                foundEvent = true;
            }
        }
        if(!foundEvent){
            System.out.println("No events found on this date");
        }
    }
}