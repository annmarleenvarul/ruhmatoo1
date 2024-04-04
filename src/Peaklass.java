/*********************
 * Rühmatöö 1
 * Aksel Kaasik
 * Ann Marleen Varul
 *********************/
/**
 * Eesmärk: suhelda kasutajaga ning kutsuda välja teiste klasside meetodeid.
 */

import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        boolean kasEdasi = true; // Algselt on true, ehk programm töötab, kui väärtus muutub false, siis programm lõpeb töö.

        // Kasutajaga suhtluseks kasutame Scannerit.
        Scanner scan = new Scanner(System.in);
        System.out.println("Siin programmis saate infot hetkel populaarsete laulude kohta. Andmed on võetud Billboard Hot 100 lehelt. " +
                "Kas soovite näha x arv suvalisi laule, x arv Top esimesi laule? Kui soovite programmi sulgeda, siis sisestage 'Exit'");
        System.out.println();

        // Kui programm pannakse tööle, siis programm töötab seni kuni, kasutaja sisestab "Exit".

        while(kasEdasi) {
            System.out.println("Sisestage: Suvalised/Top/Exit");
            String kuidas = scan.next();
            if (kuidas.equals("Exit")){
                kasEdasi = false;
                System.out.println("Programmi töö lõpetatud!");
                break;
            } else if(kuidas.equals("Suvalised")){
                System.out.println("Mitut suvalist laulu soovite? (1-95)");
                int mituSuvalist = scan.nextInt(); // muutuja saab väärtuseks eelnevalt sisestatud arvu.
                LauluNumbrid objekt = new LauluNumbrid();
                objekt.setMituNumbrit(mituSuvalist); // Klassis "LauluNumbrid" muudetakse muutuja "mituNumbrit" väärtuseks "mituSuvalist".
                List<Integer> list = objekt.lauluIndeksidRandom();
                System.out.println("Suvalised " + objekt.getMituNumbrit() + " laulu:");
                LeheltLugemine leheltLugemine = new LeheltLugemine(list);
                leheltLugemine.loebLehelt();
            } else if (kuidas.equals("Top")) {
                System.out.println("Mitut Top laulu soovite? (1-95)");
                int mituTop = scan.nextInt();
                LauluNumbrid objekt = new LauluNumbrid();
                objekt.setMituNumbrit(mituTop);
                List<Integer> list = objekt.lauluIndeksidTop();
                System.out.println("Esimesed " + objekt.getMituNumbrit() + " laulu:");
                LeheltLugemine leheltLugemine = new LeheltLugemine(list);
                leheltLugemine.loebLehelt();
            } else {
                LauluNumbrid objekt = new LauluNumbrid();
                List<Integer> list = objekt.lauluIndeksidTop();
                System.out.println("Esimesed " + objekt.getMituNumbrit() + " laulu:");
                LeheltLugemine leheltLugemine = new LeheltLugemine(list);
                leheltLugemine.loebLehelt();
            }

        }
    }
}
