import java.util.Set;

public class SpannedCluster extends Graph {
    protected SuperVertex center;
    protected double radius;

    public SpannedCluster (SuperVertex center, Cluster cluster, Graph subGraph){
        super(cluster.getName());
        try {
            if((!subGraph.containsAllVertices(cluster.getVertices()))||(!cluster.containsVertex(center))||(subGraph.numOfVertices() != cluster.numOfVertices()))
                throw new InputException("The sub graph is corrupted");
            else{
                this.center = center;
                this.addVertices(cluster.getVertices());
                this.addAllEdges(subGraph.getEdges());
                radius = this.getSPTForUnWeightGraph(center);
            }
        }catch (InputException e){
            System.out.println("The sub graph is corrupted");
        }
    }
    public String toString() {
        return "{"+this.getName()+": center:"+this.center+" Vertices:"+this.getVertices()+", Edges:"+this.getEdges()+"}";
    }

    public SpannedCluster (SpannedCluster centerCluster, Set<SpannedCluster> clusters, Graph subGraph){
        super(centerCluster.getName());

    }
    public SuperVertex getCenter(){
        return this.center;
    }

    public double getRadius(){
        return this.radius;
    }

    public boolean addVertex(SuperVertex toAdd){
        boolean res = super.addVertex(toAdd);
        toAdd.setSpannedCluster(this);
        return res;
    }
    public boolean removeVertex(SuperVertex toRemove){
        boolean res = super.removeVertex(toRemove);
        ((SuperVertex)toRemove).initSpannedCluster();
        return false;
    }

}
