
import java.util.Set;

public class SpannedCluster extends Graph{

    protected double radius;

    public SpannedCluster (Cluster cluster, Set<Edge> spanningTree){
        super(cluster.getName(),cluster.getVertices(),spanningTree);
        calcRadius();
    }

    protected void calcRadius(){
        this.radius = 0;
    }
}
