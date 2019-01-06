package GrapheV2;

import java.util.List;

public class AlgoIC1 implements Algo {

    @Override
    public void compute(IC ic) {
        for(List<Sommet> ensemble : ic.getDonnees()) {
            if(ensemble.size() > 1) {
                for(int i = 1; i < ensemble.size(); ++i) {
                    ic.getGraphe().addEdge(new Arc(ensemble.get(i-1), ensemble.get(i)));
                }
            }
        }
    }
}
