import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        int satunnainenLuku = (int) (Math.random() * 100 + 1);
        int arvaukset = 0;
        Scanner lukija = new Scanner(System.in);

        System.out.println("Luku on " + satunnainenLuku);

        System.out.println("Tervetuloa peliin! Arvaa luku väliltä 1-100.");
        System.out.println("Arvauksia jäljellä: " + (arvaukset + 7));

        do {
            int arvaus = lukija.nextInt();

            if(arvaus < satunnainenLuku){
                System.out.println("Arvaamasi luku on pienempi kuin oikea luku.");
                System.out.println("Arvauksia jäljellä: " + (6 - arvaukset));
            }
            else if(arvaus > satunnainenLuku) {
                System.out.println("Arvaamasi luku on suurempi kuin oikea luku.");
                System.out.println("Arvauksia jäljellä: " + (6 - arvaukset));
            }
            else {
                System.out.println("Onneksi olkoon! Arvasit oikein!");
                break;
            }
            arvaukset++;

        }while (arvaukset < 7);

        System.out.println("Hävisit pelin, oikea luku oli " + satunnainenLuku);

    }
}