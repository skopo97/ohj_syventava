import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        String birthDay = System.getenv("BIRTHDATE");


        if (birthDay == null) {
            System.out.println("Please set the BIRTHDATE environment variable in format YYYY-MM-DD." +
                    " Use export BIRTHDATE=YYYY-MM-DD");
            return;
        }
        LocalDate birthDate;
        try {
            //Yritetään tehdä annetusta stringistä LocalDate olio, jos ei onnistu niin tulostetaan virheilmoitus.
            birthDate = LocalDate.parse(birthDay);
            if (birthDate.getYear() < 1910 || birthDate.getYear() > 2025) {
                System.out.println("Invalid year, please use year between 1910 and the current year");
                return;
            }

        } catch (DateTimeParseException dtpe) {
            System.err.println("Invalid format for BIRTHDAY, use export BIRTHDATE=YYYY-MM-DD");
            return;
        }

        //Tehdään nykyhetkestä LocalDate olio
        LocalDate currentDate = LocalDate.now();
        if (birthDate.getMonth() == currentDate.getMonth() && birthDate.getDayOfMonth() == currentDate.getDayOfMonth()) {
            System.out.println("Happy Birthday!");
        } else {
            System.out.println("Sorry, it's not your birthday yet");
        }
    }
}
