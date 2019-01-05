package GrapheV2;

import java.util.ArrayList;
import java.util.List;

public class Graphe {
    private List<Sommet> sommets;

    public Graphe(){
        sommets = new ArrayList<>();
    }

    public void addVertex(Sommet sommet) {
        sommets.add(sommet);
    }

    @Override
    public String toString() {
        String result = "";
        for(Sommet s : sommets) {
            result += s.toString() + '\n';
        }
        return result;
    }
}
