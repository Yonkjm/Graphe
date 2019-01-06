package GrapheV2;

import java.util.ArrayList;
import java.util.List;

public class AlgoIC3 implements Algo {

    private List<Sommet> interne;
    private List<Sommet> externe;

    @Override
    public void compute(IC ic) {
        genererArcs(ic);
        for(Arc arc : ic.getGraphe().getArcs()) {
            arc.getOrigin().removeArc(arc);
            arc.getDestination().removeArc(arc);
            if(!isComplet(ic)) {
                arc.getOrigin().addArc(arc);
                arc.getDestination().addArc(arc);
            }
        }
    }

    private boolean isComplet(IC ic) {
        for(List<Sommet> list : ic.getDonnees()) {
            externe = new ArrayList<>(list);
            interne = new ArrayList<>();
            interne.add(externe.get(0));
            externe.remove(0);
            addVoisin(interne.get(0));
            if(externe.size() > 0) return false;
        }
        return true;
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

    private void genererArcs(IC ic) {
        for(List<Sommet> list : ic.getDonnees()) {
            for (int i = 1; i < list.size(); ++i) {
                ic.getGraphe().addEdge(new Arc(list.get(i-1), list.get(i)));
            }
        }
    }
}
