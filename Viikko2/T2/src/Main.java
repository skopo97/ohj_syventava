import java.time.DateTimeException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String birthDay = System.getenv("BIRTHDATE");


        if (birthDay == null) {
            System.out.println("Please set the BIRTHDATE environment variable in format YYYY-MM-DD." +
                    " Use export BIRTHDATE=YYYY-MM-DD");
            return;
        }
        //Tehdään nykyhetkestä LocalDate olio
        LocalDate currentDate = LocalDate.now();

        LocalDate birthDate;
        try {
            //Yritetään tehdä annetusta stringistä LocalDate olio, jos ei onnistu niin tulostetaan virheilmoitus.
            birthDate = LocalDate.parse(birthDay);
            if (birthDate.getYear() < 1910 || birthDate.getYear() > currentDate.getYear()) {
                System.out.println("Invalid year, please use year between 1910 and the current year");
                return;
            }
            if (birthDate.isAfter(currentDate)) {
                System.out.println("Invalid date, please use a date before the current date");
                return;
            }
        } catch (DateTimeException dte) {
            System.err.println("Invalid date or formatting for BIRTHDAY, please use a valid date");
            return;
        }

        if (birthDate.getMonth() == currentDate.getMonth() && birthDate.getDayOfMonth() == currentDate.getDayOfMonth()) {
            System.out.println("Happy Birthday!");
        } else {
            System.out.println("Sorry, it's not your birthday yet");
        }
    }
}
