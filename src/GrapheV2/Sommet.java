package GrapheV2;

import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private String name;
    private List<Arc> arcs;

    public Sommet(String name){
        this.name = name;
        this.arcs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
    }

    @Override
    public String toString() {
        String result = name + " -> ";
        for(Arc arc : arcs) {
            result += arc.getOppositeVertex(this).getName() + " ";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Sommet) {
            Sommet s = (Sommet) o;
            return name.equals(s.getName());
        }
        return false;
    }
}
