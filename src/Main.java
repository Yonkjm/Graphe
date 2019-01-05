import GrapheV2.Graphe;
import GrapheV2.Sommet;
import GrapheV2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String ...args ){
        testGenerateIC(5, 6, 3);
        testGenerateIC(6, 10, 2);
        testGenerateIC(3, 2, 6);
    }

    private static void testGenerateIC(int t, int n, int p) {
        System.out.println("----------GenerateIC----------\n");
        IC ic = new IC();
        ic.generate(t, n, p);
        System.out.println(ic.toString());
    }

    private static void testAlgoIC1() {
        System.out.println("----------AlgoIC1----------\n");
        IC ic = new IC();
        Sommet s1 = new Sommet("1");
        Sommet s2 = new Sommet("2");
        Sommet s3 = new Sommet("3");
        Sommet s4 = new Sommet("4");
        Sommet s5 = new Sommet("5");
        Sommet s6 = new Sommet("6");
        Sommet s7 = new Sommet("7");
        Sommet s8 = new Sommet("8");
        ic.addSet(new ArrayList<Sommet>() {{
            add(s1);
            add(s2);
            add(s3);
        }});
        ic.addSet(new ArrayList<Sommet>() {{
            add(s2);
            add(s4);
            add(s5);
        }});
        ic.addSet(new ArrayList<Sommet>() {{
            add(s1);
            add(s4);
            add(s6);
            add(s7);
        }});
        ic.addSet(new ArrayList<Sommet>() {{
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

        System.out.println(ic.toString());
        algoIC1.compute(ic);
        System.out.println(graphe.toString());
    }
}