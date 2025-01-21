import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        int satunnainenLuku = (int) (Math.random() * 100 + 1);
        System.out.println("Tervetuloa peliin! Arvaa luku väliltä 1-100.");
        int arvauksetMaksimi = 7;
        int arvaukset = 0;

        System.out.println("Arvauksia jäljellä: " + (arvaukset + arvauksetMaksimi));

        do {
            System.out.print("Arvaa luku: ");
            int arvaus = lukija.nextInt();

            if(arvaus < satunnainenLuku){
                System.out.println("Arvaamasi luku on pienempi kuin oikea luku.");
                System.out.println("Arvauksia jäljellä: " + (arvauksetMaksimi - arvaukset - 1));
            }
            else if(arvaus > satunnainenLuku) {
                System.out.println("Arvaamasi luku on suurempi kuin oikea luku.");
                System.out.println("Arvauksia jäljellä: " + (arvauksetMaksimi - arvaukset - 1));

            }
            else {
                System.out.println("Onneksi olkoon! Arvasit oikein!");
                break;
            }
            arvaukset++;

        }while (arvaukset < arvauksetMaksimi);

        if(arvaukset == arvauksetMaksimi){
            System.out.println("Hävisit pelin, oikea luku oli " + satunnainenLuku);

        }
    }
}
