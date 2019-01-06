import GrapheV2.Graphe;
import GrapheV2.Sommet;
import GrapheV2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String ...args ){
        //testAlgoIC2(5, 10, 4);
        //testAlgoIC1();
        testAlgoIC3(5, 10, 4);
    }

    private static void testAlgoIC3(int t, int n, int p) {
        System.out.println("----------AlgoIC3----------\n");
        IC ic = new IC();
        ic.generate(t, n, p);
        System.out.println(ic.toString());
        AlgoIC3 algoIC3 = new AlgoIC3();
        algoIC3.compute(ic);
        System.out.println(ic.getGraphe().toString());
    }

    private static void testAlgoIC2(int t, int n, int p) {
        System.out.println("----------AlgoIC2----------\n");
        IC ic = new IC();
        ic.generate(t, n, p);
        System.out.println(ic.toString());
        AlgoIC2 algoIC2 = new AlgoIC2();
        algoIC2.compute(ic);
        System.out.println(ic.getGraphe().toString());
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
        AlgoIC1 algoIC1 = new AlgoIC1();
        System.out.println(ic.toString());
        algoIC1.compute(ic);
        System.out.println(ic.getGraphe().toString());
    }
}