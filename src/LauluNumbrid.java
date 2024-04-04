/**
 * Eesmärk: genereerida list, mis sisaldab laulude järjekorranumbreid, mida hiljem väljastada.
 */

import java.util.*;
public class LauluNumbrid {

    private int mituNumbrit = 10; // Vaikeväärtusena võtab 10 laulu.
    private List<Integer> järjestatudList;

    public LauluNumbrid() {
        this.järjestatudList = new ArrayList<>();
    }

    /**
     * Meetod lauluIndeksidRandom genereerib muutuja "mituNumbrit" arvu suvalisi arve,
     * (nt kui mituNumbrit = 5, siis genereerib 5 suvalist arvu).
     * @return Tagastab listi, mis koosneb suvalistest arvudest ja mis on sorteeritud väiksemast suuremani.
     */
    public List<Integer> lauluIndeksidRandom(){
        Set<Integer> indeksiteHulk = new HashSet<>();
        while (indeksiteHulk.size() < mituNumbrit) {
            int number = (int) (1 + Math.random() * 95);
            indeksiteHulk.add(number);
        }
        this.järjestatudList = new ArrayList<>(indeksiteHulk);
        Collections.sort(järjestatudList);
        return järjestatudList;
    }

    /**
     * Meetod lauluIndeksidTop loob listi, mis koosneb arvudest 1 - mituNumbrit. (nt kui mituNumbrit = 5, siis loodud list oleks {1,2,3,4,5}.
     * @return Tagastab loodud listi, mis koosneb valitud arvude vahemikust.
     */
    public List<Integer> lauluIndeksidTop(){
        for (int i = 1; i <= mituNumbrit; i++) {
            järjestatudList.add(i);
        }
        return järjestatudList;
    }

    public int getMituNumbrit() {
        return mituNumbrit;
    }

    public List<Integer> getJärjestatudList() {
        return lauluIndeksidRandom();
    }

    public void setMituNumbrit(int mituNumbrit) {
        this.mituNumbrit = mituNumbrit;
    }
}
