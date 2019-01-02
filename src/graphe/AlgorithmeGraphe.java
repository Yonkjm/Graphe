package graphe;

import java.util.*;

class AlgorithmeGraphe {
    private List<Set<Sommet>> sommets;
    private Graphe grapheFinal;


    AlgorithmeGraphe(){
        sommets = new ArrayList<>();
    }

    private void dataBase(){
        Set<Sommet> set1 = new HashSet<>();
        set1.add(new Sommet(""+1,0));
        set1.add(new Sommet(""+2,0));
        set1.add(new Sommet(""+3,0));

        Set<Sommet> set2 = new HashSet<>();
        set2.add(new Sommet(""+2,0));
        set2.add(new Sommet(""+4,0));
        set2.add(new Sommet(""+5,0));

        Set<Sommet> set3 = new HashSet<>();
        set3.add(new Sommet(""+3,0));
        set3.add(new Sommet(""+4,0));
        set3.add(new Sommet(""+5,0));

        Set<Sommet> set4 = new HashSet<>();
        set4.add(new Sommet(""+4,0));
        set4.add(new Sommet(""+5,0));
        set4.add(new Sommet(""+6,0));
        set4.add(new Sommet(""+7,0));

        sommets.add(set1);
        sommets.add(set2);
        sommets.add(set3);
        sommets.add(set4);
    }

    void compute(){
        dataBase();
        grapheFinal = new Graphe();
        boolean firstIteration = true;
        for(Set<Sommet> set : sommets ) {
            Graphe graphe = createGrapheSousEnsemble(set);
            grapheFinal.addGraphe(graphe);
        }
        for(Set<Sommet> set : sommets ){
            if(!isConnexe(grapheFinal,createGrapheSousEnsemble(set))){
                System.out.println("graphe non connexe avec un de ses sous ensembles");
            }
        }
        int test = 0;
    }

    private boolean isConnexe(Graphe graphe1,Graphe graphe2 ){
        List<Arc> arc1 = graphe1.getList();

        for(Arc arc : arc1){
            if(graphe2.containSommet(arc.getO())  ||graphe2.containSommet(arc.getD())){
                return true;
            }
        }
        return false;
    }

    private Graphe createGrapheSousEnsemble(Set<Sommet> set) {
        Graphe graphe = new Graphe();
        Sommet previousSommet = null;
        Iterator<Sommet> iterator = set.iterator();
        boolean firstIteration = true;
        while(iterator.hasNext()) {
            if(firstIteration) {
                Sommet element1 = iterator.next();
                Sommet element2 = iterator.next();
                graphe.addArc(new Arc(element1, element2));
                previousSommet =element2;
                firstIteration =false;
            }
            else{
                Sommet element2 = iterator.next();
                graphe.addArc(new Arc(previousSommet, element2));
            }





        }
        return graphe;
    }



}
