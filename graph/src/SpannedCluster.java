
public class SpannedCluster extends Graph {
    protected Vertex center;
    protected double radius;

    public SpannedCluster (Vertex center, Cluster cluster, Graph subGraph){
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

    public Vertex getCenter(){
        return this.center;
    }

    public double getRadius(){
        return this.radius;
    }


    private boolean addVertex(SuperVertex toAdd){
        boolean res = super.addVertex(toAdd);
        toAdd.setSpannedCluster(this);
        return res;
    }
    public boolean removeVertex(SuperVertex vert){
        boolean res = super.removeVertex(vert);
        vert.initSpannedCluster();
        return false;
    }

}
