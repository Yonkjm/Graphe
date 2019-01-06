package GrapheV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IC {

    private List<List<Sommet>> donnees;
    private List<Sommet> sommets;
    private Graphe graphe;

    public IC() {
        donnees = new ArrayList<>();
        sommets = new ArrayList<>();
        graphe = new Graphe();
    }

    public Graphe getGraphe() {
        return graphe;
    }

    public List<Sommet> getSommets() {
        return sommets;
    }

    public void addSet(List<Sommet> set) {
        for(Sommet s : set) {
            if(!sommets.contains(s)) {
                sommets.add(s);
                graphe.addVertex(s);
            }
        }
        donnees.add(set);
    }

    public List<List<Sommet>> getDonnees() {
        return donnees;
    }

    /**
     *
     * @param t nombre d'ensembles
     * @param n nombre de sommets
     * @param p taille d'un ensemble
     */
    public void generate(int t, int n, int p) {
        createVertex(n);
        if(n < p) {
            System.out.println("erreur : n < p");
            return;
        }
        Random random = new Random();
        for(int i = 0; i < t; ++i) {
            List<Sommet> list = new ArrayList<>();
            List<Sommet> utilises = new ArrayList<>();
            for(int j = 0; j < p; ++j) {
                Sommet s = sommets.get(random.nextInt(n));
                while(utilises.contains(s)) {
                    s = sommets.get(random.nextInt(n));
                }
                utilises.add(s);
                list.add(s);
            }
            donnees.add(list);
        }
        for(Sommet s : sommets) {
            graphe.addVertex(s);
        }
    }

    private void createVertex(int n) {
        for(int i = 1; i <= n; ++i) {
            sommets.add(new Sommet("" + i));
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < donnees.size(); ++i) {
            result += "t" + (i+1) + " : ";
            for(Sommet s : donnees.get(i)) {
                result += s.getName() + " ";
            }
            result += '\n';
        }
        return result;
    }
}
