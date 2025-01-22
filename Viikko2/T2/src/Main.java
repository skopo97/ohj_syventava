import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String birthDay = System.getenv("BIRTHDATE");


        if (birthDay == null) {
            System.out.println("Please set the BIRTHDATE environment variable in format YYYY-MM-DD." +
                    " export BIRTHDATE=YYYY-MM-DD");
            return;
        }
        LocalDate birthDate;
        try {
            //Yritetään tehdä annetusta stringistä localDate olio, jos ei onnistu niin tulostetaan virheilmoitus
            birthDate = LocalDate.parse(birthDay);
        } catch (Exception e) {
            System.out.println("Invalid format for BIRTHDAY, export BIRTHDATE=YYYY-MM-DD");
            return;
        }

        //Tehdään nykyhetkestä localDate olio
        LocalDate currentDate = LocalDate.now();
        if (birthDate.getMonth() == currentDate.getMonth() && birthDate.getDayOfMonth() == currentDate.getDayOfMonth()) {
            System.out.println("Happy Birthday!");
        } else {
            System.out.println("Sorry, it's not your birthday yet");
        }
    }
}
