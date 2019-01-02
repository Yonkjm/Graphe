package graphe;

public class Arc {
    private Sommet o;
    private Sommet d;
    public Arc(Sommet o,Sommet d){
        this.o = o;
        this.d = d;
    }

    public boolean equals(Object o ){
        Arc arc = (Arc)o;
        return this.d.equals(arc.d) && this.o.equals(arc.o);
    }

    public String string(){
        return "("+this.o+", "+this.d+")";

    }

    public Sommet getD() {
        return d;
    }

    public Sommet getO() {
        return o;
    }
}
