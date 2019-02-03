public class Edge {
    private double DEFAULT_EDGE_WEIGHT = 1.0;
    protected SuperVertex sourceVertex, targetVertex;
    protected double weight;

    public  Edge(SuperVertex sourceVertex, SuperVertex targetVertex, double weight){
        this.sourceVertex=sourceVertex;
        this.targetVertex=targetVertex;
        this.weight = weight;
    }
    public  Edge(SuperVertex sourceVertex, SuperVertex targetVertex){
        this.sourceVertex=sourceVertex;
        this.targetVertex=targetVertex;
        this.weight = DEFAULT_EDGE_WEIGHT;
    }

    public Edge clone(){
        return new Edge(this.getSourceVertex(), this.getTargetVertex(), this.getWeight());
    }

    public SuperVertex getSourceVertex() {
        return sourceVertex;
    }

    public SuperVertex getTargetVertex() {
        return targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean contains(SuperVertex var) {
        return (((this.getSourceVertex()).equals(var)) || ((this.getTargetVertex()).equals(var)));
    }
    public String toString() {
        if(weight == 1)
            return "("+this.getSourceVertex().toString()+","+this.getTargetVertex().toString()+")";
        else
            return "("+this.getSourceVertex().toString()+","+this.getTargetVertex().toString()+"|"+this.getWeight()+")";
    }
    public boolean equals(Edge otherEdge) {
        return ((((this.getSourceVertex()).equals(otherEdge.getSourceVertex())) &&
                ((this.getTargetVertex()).equals(otherEdge.getTargetVertex())))||
                (((this.getSourceVertex()).equals(otherEdge.getTargetVertex())) &&
                ((this.getTargetVertex()).equals(otherEdge.getSourceVertex()))));
    }
    public boolean equals(SuperVertex _sourceVertex, SuperVertex _targetVertex){
        return ((((this.getSourceVertex()).equals(_sourceVertex)) &&
                ((this.getTargetVertex()).equals(_targetVertex)))||
                (((this.getSourceVertex()).equals(_targetVertex)) &&
                ((this.getTargetVertex()).equals(_sourceVertex))));
    }
}
