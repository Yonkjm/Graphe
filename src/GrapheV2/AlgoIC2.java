package GrapheV2;

import java.util.ArrayList;
import java.util.List;

public class AlgoIC2 implements Algo {

    private List<Sommet> externe;
    private List<Sommet> interne;

    @Override
    public void compute(IC ic) {
        for(List<Sommet> ensemble : ic.getDonnees()) {
            externe = new ArrayList<>(ensemble);
            interne = new ArrayList<>();
            interne.add(externe.get(0));
            externe.remove(0);
            while(externe.size() > 0) {
                addVoisin(interne.get(interne.size()-1));
                if(externe.size() > 0) {
                    ic.getGraphe().addEdge(new Arc(interne.get(0), externe.get(0)));
                    interne.add(externe.get(0));
                    externe.remove(0);
                }
            }
        }
    }

    private void addVoisin(Sommet sommet) {
        for(Arc arc : sommet.getArcs()) {
            if(externe.contains(arc.getOppositeVertex(sommet))) {
                interne.add(arc.getOppositeVertex(sommet));
                externe.remove(arc.getOppositeVertex(sommet));
                addVoisin(arc.getOppositeVertex(sommet));
            }
        }
    }
}
