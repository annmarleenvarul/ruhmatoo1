/**
 * Eesmärk: lugeda veebilehelt infot ning see väljatada.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.List;

public class LeheltLugemine {
    private List<Integer> listNumbritest; // listNumbritest väärtuseks on Peaklassis määratud parameeter.

    public LeheltLugemine(List<Integer> massiivNumbritest) {
        this.listNumbritest = massiivNumbritest;
    }

    /**
     * Meetod loeb veebilehelt laulude nimesid ja esitajaid.
     * Veebilehelt lugemiseks kasutame jsoup-i.
     */
    public void loebLehelt() {
        String url = "https://www.billboard.com/charts/hot-100/";
        for (int i : listNumbritest) { // Käib ükshaaval läbi listi, kus on mingid soovitud laulude järjekorra numbrid.
            try {
                Document dokument = Jsoup.connect(url).get(); // Loome ühenduse veebilehega.
                Elements laulud = dokument.select(".o-chart-results-list-row-container"); // Valib välja meie soovitud veebilehe osa.
                Elements lauluPealkiri = laulud.get(i-1).select("li > h3"); // Valitud osast saame laulu pealkirja ja esitajad, aga võtame ainult pealkirja.
                String esitajad = lauluPealkiri.next("span").text(); // Eelnevalt saadud osast võtame esitajad.
                System.out.println(i + ". LAUL: " + lauluPealkiri.text() +  ", ESITAJA(D):" + esitajad); // Väljastab igale reale eraldi laulu info.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
