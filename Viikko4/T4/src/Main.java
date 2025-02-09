import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class Main {
    public static void main(String[] args) {

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

        String inputDate = null;
        String inputCategory = null;


        //Tarkistetaan, että syötettyjä parametreja on 2
        if(args.length != 2){
            System.out.println("Provide 2 arguments: date in format --MM-dd and " +
                    "event category");
            System.exit(1);
        }else{
            inputDate = args[0];
            inputCategory = args[1].toLowerCase();

            //Tarkistetaan, että syötetty kategoria on joko primary tai primary/secondary
            if(inputCategory.equals(category.getSecondary().toLowerCase())){
                System.out.println("Please provide primary category or primary/secondary category");
                System.out.println("Valid categories found : " + category.getPrimary() + " and " + category.toString());
                System.exit(1);
            }
        }
        //Tarkistetaan, että päivämäärä on oikeassa muodossa
        MonthDay mDay = null;
        try{
            mDay = MonthDay.parse(inputDate, DateTimeFormatter.ofPattern("--MM-dd"));

        }catch(DateTimeParseException e){
            System.out.println("Invalid date, use format --MM-dd");
            System.exit(1);
        }
        //Tarkastetaan löytyykö syötettyä kategoriaa tapahtumista
        boolean foundCategory = false;
        for(Event e : events){
            if(e.getCategory().getPrimary().toLowerCase().equals(inputCategory) ||
                    e.getCategory().getSecondary().toLowerCase().equals(inputCategory) ||
                    e.getCategory().toString().toLowerCase().equals(inputCategory)){
                foundCategory = true;
                break;
            }
        }
        if (!foundCategory){
            System.out.println("No events found for category : " + inputCategory);

            System.exit(1);
        }
        //Tulostetaan tapahtumat, jotka ovat samana päivänä kuin syötetty päivämäärä
        //Tarkastetaan myös kategoria
        //Boolean arvolla voidaan tulostaa myös, jos tapahtumia ei löydy
        boolean foundEvent = false;
        for(Event e : events){
            if(MonthDay.from(e.getDate()).equals(mDay) &&
                    (e.getCategory().getPrimary().toLowerCase().equals(inputCategory) ||
                    e.getCategory().toString().toLowerCase().equals(inputCategory))){
            }
        }
        for(Event e : events){
            if(MonthDay.from(e.getDate()).equals(mDay) &&
                    (e.getCategory().getPrimary().toLowerCase().equals(inputCategory) ||
                    e.getCategory().toString().toLowerCase().equals(inputCategory))) {

                System.out.println(e.getDate().getYear() + " : " + e.getDescription());
                foundEvent = true;
            }
        }
        if(!foundEvent){
            System.out.println("No events found on this date");
        }
    }
}