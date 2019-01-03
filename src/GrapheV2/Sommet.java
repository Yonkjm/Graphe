package GrapheV2;

import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private String name;
    List<Arc> arcs;

    Sommet(String name){
        this.name = name;
        this.arcs = new ArrayList<>();
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
    }
}
