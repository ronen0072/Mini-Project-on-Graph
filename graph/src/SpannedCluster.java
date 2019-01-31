
public class SpannedCluster extends Graph {
    protected Vertex center;
    protected double radius;

    public SpannedCluster (Vertex center, Cluster cluster, Graph subGraph){
        super(cluster.getName(),cluster.getVertices(),subGraph.getEdges());
        this.center = center;
        try {
            if(!subGraph.containsAllVertices(cluster.getVertices()))
                throw new InputException("The sub graph is corrupted");
        }catch (InputException e){
            System.out.println("The sub graph is corrupted");
        }
        radius = this.getSPTForUnWeightGraph(center);
    }
    public Vertex getCenter(){
        return this.center.clone();
    }
    public double getRadius(){
        return this.radius;
    }
}
