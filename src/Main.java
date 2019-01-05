import GrapheV2.Graphe;
import GrapheV2.Sommet;
import GrapheV2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String ...args ){
        testAlgoIC1();
    }

    private static void testAlgoIC1() {
        List<List<Sommet>> donnees = new ArrayList<>();
        Sommet s1 = new Sommet("1");
        Sommet s2 = new Sommet("2");
        Sommet s3 = new Sommet("3");
        Sommet s4 = new Sommet("4");
        Sommet s5 = new Sommet("5");
        Sommet s6 = new Sommet("6");
        Sommet s7 = new Sommet("7");
        Sommet s8 = new Sommet("8");
        donnees.add(new ArrayList<Sommet>() {{
            add(s1);
            add(s2);
            add(s3);
        }});
        donnees.add(new ArrayList<Sommet>() {{
            add(s2);
            add(s4);
            add(s5);
        }});
        donnees.add(new ArrayList<Sommet>() {{
            add(s1);
            add(s4);
            add(s6);
            add(s7);
        }});
        donnees.add(new ArrayList<Sommet>() {{
            add(s3);
            add(s5);
            add(s6);
            add(s8);
        }});
        Graphe graphe = new Graphe();
        graphe.addVertex(s1);
        graphe.addVertex(s2);
        graphe.addVertex(s3);
        graphe.addVertex(s4);
        graphe.addVertex(s5);
        graphe.addVertex(s6);
        graphe.addVertex(s7);
        graphe.addVertex(s8);
        AlgoIC1 algoIC1 = new AlgoIC1();

        String depart = "";
        for(int i = 0; i < donnees.size(); ++i) {
            depart += "t" + (i+1) + " : ";
            for(Sommet s : donnees.get(i)) {
                depart += s.getName() + " ";
            }
            depart += '\n';
        }
        System.out.println(depart);
        algoIC1.compute(donnees);
        System.out.println(graphe.toString());
    }
}