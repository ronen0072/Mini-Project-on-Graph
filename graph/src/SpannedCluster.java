
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class SpannedCluster extends Graph {
    protected Vertex center;
    protected double radius;

    public SpannedCluster(String name, Vertex center, Set<Vertex> vertices, Set<Edge> sptEdges , int radius){
        super(name, vertices, sptEdges);
        this.center = center;
        this.radius = radius;
    }

    protected void calcRadius(){
        this.radius = 0;
    }
}
