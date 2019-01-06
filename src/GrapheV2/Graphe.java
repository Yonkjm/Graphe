package GrapheV2;

import java.util.ArrayList;
import java.util.List;

public class Graphe {

    private List<Arc> arcs;
    private List<Sommet> sommets;

    public Graphe(){
        sommets = new ArrayList<>();
        arcs = new ArrayList<>();
    }

    public void addVertex(Sommet sommet) {
        sommets.add(sommet);
    }

    public void addEdge(Arc arc) {
        arcs.add(arc);
    }

    public List<Arc> getArcs() {
        return arcs;
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
