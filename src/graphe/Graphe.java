package graphe;

import java.util.LinkedList;
import java.util.List;

public class Graphe {
    private List<Arc>  graphe;

    Graphe(){
        graphe = new LinkedList<Arc>();
    }

    public void addArc(Arc arc){
        if(!graphe.contains(arc)) {
            if(containSommet(arc.getO()) || containSommet(arc.getD()) ){

            }
            graphe.add(arc);
        }
    }

    public String toString(){
        StringBuilder answer = null;
        for(Arc arc : graphe ){
            if (arc != null) {
                answer.append(arc.string());
            }
        }
        return answer.toString();
    }
    public boolean containSommet(Sommet o){
        for(Arc arc :graphe){
            if(arc.getD() == o ||arc.getO() == o)
                return true;
        }
        return false;
    }

    public List<Arc> getList() {
        return graphe;
    }

    public void addGraphe(Graphe graphe) {
        for(Arc arc :graphe.graphe){
            if(!containArc(arc))
                this.graphe.add(arc);
        }
    }

    private boolean containArc(Arc arc) {
        for(Arc arc1 : graphe){
            if(arc1.equals(arc)){
                return true;
            }
        }
        return false;
    }
}
