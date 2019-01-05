package GrapheV2;

public class Arc {
    private Sommet origin;
    private Sommet destination;

    public Arc(Sommet origin,Sommet destination){
        this.origin = origin;
        this.destination = destination;
        origin.addArc(this);
        destination.addArc(this);
    }

    public Sommet getOppositeVertex(Sommet sommet) {
        if(sommet.equals(origin)) {
            return destination;
        } else if(sommet.equals(destination)){
            return origin;
        }
        return null;
    }
}
