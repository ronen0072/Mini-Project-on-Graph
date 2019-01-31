
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class SpannedCluster extends Graph {
    protected Vertex center;
    protected double radius;

    public SpannedCluster (Vertex center, Cluster cluster, Graph subGraph){
        super(cluster.getName(),cluster.getVertices(),subGraph.getEdges());
        this.center = center;
        radius = this.getSPTForUnWeightGraph(center);
    }

    public double getRadius(){
        return radius;
    }
}
