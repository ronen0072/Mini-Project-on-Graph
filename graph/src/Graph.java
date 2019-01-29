import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Supplier;

public class Graph implements GraphInterface{
    protected String graphName;
    protected Set<Vertex> vertices;
    protected Set<Edge> edges;

    public Graph(String graphName, Set<Vertex> vertices, Set<Edge> edges){
        this.graphName = graphName;
        this.vertices = vertices;
        this.edges = edges;
    }
    public Graph(String graphName){
        this.graphName = graphName;
        this.vertices = new HashSet<Vertex>();
        this.edges = new HashSet<Edge>();
    }

    public String getGraphName() {
        return graphName;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public String toString() {
        return "{"+this.getGraphName()+":"+this.getVertices()+","+this.getEdges()+"}";
    }

    public int numOfVertices() {
        return vertices.size();
    }

    public int numOfEdges() {
        return edges.size();
    }

    public Vertex getVertex(int vertexId){
        Iterator verticesIrer = vertices.iterator();
        while (verticesIrer.hasNext()) {
            Vertex v = (Vertex) verticesIrer.next();
            if (v.getId()== vertexId)
                return v;
        }
        return null;
    }

    public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
        Iterator edgesIrer = edges.iterator();
        while (edgesIrer.hasNext()) {
            Edge e = (Edge) edgesIrer.next();
            if (e.equals(sourceVertex, targetVertex))
                return e;
        }
        return null;
    }

    public Edge getEdge(Edge edge) {
        return (this.getEdge(edge.getSourceVertex(), edge.getTargetVertex()));
    }

    public Edge addEdge(Vertex sourceVertex, Vertex targetVertex) {
        if (this.containsVertex(sourceVertex)&& this.containsVertex(targetVertex)) {
            Edge toAdd = this.getEdge(sourceVertex, targetVertex);
            if (toAdd == null) {
                toAdd = new Edge(sourceVertex, targetVertex);
                this.edges.add(toAdd);
                sourceVertex.increaseDegree();
                targetVertex.increaseDegree();
                return toAdd;
            }
            else System.out.println("the edge:" + toAdd + " is already in the graph.");
        }
        else System.out.println("the edge:("+sourceVertex+","+targetVertex+") contains vertex which does not exist in the graph.");
        return null;
    }

    public Edge addEdge(Edge toAdd){
        if (this.containsVertex(toAdd.getSourceVertex())&& this.containsVertex(toAdd.getTargetVertex())) {
            if (!this.containsEdge(toAdd)) {
                this.edges.add(toAdd);
                toAdd.getSourceVertex().increaseDegree();
                toAdd.getTargetVertex().increaseDegree();
                return toAdd;
            } else {
                System.out.println("the edge:" + toAdd + " is already in the graph.");
                return null;
            }
        }
        else {
            System.out.println("the edge:"+toAdd+" contains vertex which does not exist in the graph.");
            return null;
        }
    }

    public boolean addVertex(Vertex toAdd) {
        if(vertices.contains(toAdd))
            return false;
        vertices.add(toAdd);
        return true;
    }

    public boolean containsEdge(Vertex var1, Vertex var2) {
        return (this.getEdge(var1,var2) != null);
    }

    public boolean containsEdge(Edge edge) {
        return (this.getEdge(edge) != null);
    }

    public boolean containsVertex(Vertex var1) {
        return vertices.contains(var1);
    }

    public Set<Edge> incomingEdgesOf(Vertex var) {
        Set<Edge> incomingEdges = new HashSet<Edge>();
        Iterator edgesIrer = edges.iterator();
        while (edgesIrer.hasNext()) {
            Edge e = (Edge) edgesIrer.next();
            if (e.contains(var))
                incomingEdges.add(e);
        }
        if(incomingEdges.isEmpty())
            return incomingEdges;
        return incomingEdges;
    }

    public boolean removeAllEdges(Collection<? extends Edge> edges) {
        boolean res = true;
        Iterator edge = edges.iterator();
        while (edge.hasNext()) {
            Edge toRemove = (Edge) edge.next();
            res &= this.removeEdge(toRemove);
        }
        return res;
    }

    public boolean removeAllVertixes(Collection<? extends Vertex> vars) {
        boolean res = true;
        Iterator var = vars.iterator();
        while (var.hasNext()) {
            Vertex toRemove = (Vertex) var.next();
            res &= this.removeVertex(toRemove);
        }
        return res;
    }

    public Edge removeEdge(Vertex var1, Vertex var2) {
        Edge toRemove = this.getEdge(var1,var2);
        if(toRemove != null) {
            var1.decreaseDegree();
            var2.decreaseDegree();
            edges.remove(toRemove);
        }
        System.out.println("the edge:"+toRemove+" is not existing in the graph.");
        return toRemove;
    }

    public boolean removeEdge(Edge var) {
        Edge toRemove = this.getEdge(var);
        if (toRemove != null){
            var.getSourceVertex().decreaseDegree();
            var.getTargetVertex().decreaseDegree();
            edges.remove(toRemove);
            return true;
        }
        System.out.println("the edge:"+var+" is not existing in the graph.");
        return false;
    }

    public boolean removeVertex(Vertex var) {
        Set<Edge> edgesToRemove = this.incomingEdgesOf(var);
        this.removeAllEdges(edgesToRemove);
        return vertices.remove(var);
    }

    public Vertex getEdgeSource(Edge var) {
        return var.getSourceVertex();
    }

    public Vertex getEdgeTarget(Edge var) {
        return var.getTargetVertex();
    }

    public double getEdgeWeight(Edge var) {
        return var.getWeight();
    }

    public void setEdgeWeight(Edge var, double weight) {
        (this.getEdge(var)).setWeight(weight);
    }

    public void setEdgeWeight(Vertex sourceVertex, Vertex targetVertex, double weight) {
        (this.getEdge(sourceVertex,targetVertex)).setWeight(weight);
    }

    public  double sumOfEdges(Collection<? extends Edge> vars){
        double sum = 0;
        Iterator edge = edges.iterator();
        while (edge.hasNext()) {
            Edge toRemove = (Edge) edge.next();
            sum += toRemove.getWeight();
        }
        return sum;
    }
    public  Set<Vertex> getNeighbors(Vertex v){
        Set<Vertex> res = new HashSet<Vertex>();
        Set<Edge> incomingEdges =  this.incomingEdgesOf(v);
        Iterator edge = incomingEdges.iterator();
        while (edge.hasNext()) {
            Edge toAdd = (Edge) edge.next();
            res.add(toAdd.getSourceVertex());
            res.add(toAdd.getTargetVertex());
        }
        res.remove(v);
        return res;
    }
    public  Set<Vertex> getNeighbors(Set<Vertex> rv){
        Set<Vertex> res = new HashSet<Vertex>();
        Iterator vertex = rv.iterator();
        while (vertex.hasNext()) {
            Vertex v = (Vertex) vertex.next();
            res.addAll(this.getNeighbors(v));
        }
        res.removeAll(rv);
        return res;
    }

}
