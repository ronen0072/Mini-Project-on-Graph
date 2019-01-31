import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;


public class Graph extends Cluster implements GraphInterface,Cloneable{
    protected Set<Edge> edges;

    public Graph(String graphName, Set<Vertex> vertices, Set<Edge> edges){
        super(graphName, vertices);
        this.edges = new HashSet<Edge>();
        if(edges != null) {
            try {
                if (!this.addAllEdges(edges))
                    throw new InputException("sum of the edges contains vertices which does not exist in the graph.");
            }
            catch (InputException e) {
                System.out.println("part of the edges contains vertices which does not exist in the graph.");
                //e.printStackTrace();
            }


        }
    }

    public Graph(String graphName){
        super(graphName);
        this.edges = new HashSet<Edge>();
    }

    public Graph clone(){
        return new Graph(this.getName(),this.getVertices(),this.getEdges());
    }

    public Set<Edge> getEdges() {
        Set<Edge> ret = new HashSet<Edge>();
        Iterator iter = this.edges.iterator();
        while (iter.hasNext()) {
            Edge e = ((Edge) iter.next()).clone();
            ret.add(e);
        }
        return ret;
    }

    public String toString() {
        return "{"+this.getName()+":"+this.getVertices()+","+this.getEdges()+"}";
    }

    public int numOfEdges() {
        return edges.size();
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

    public boolean addAllEdges(Collection<? extends Edge> edges) {
        boolean res = true;
        Iterator edge = edges.iterator();
        while (edge.hasNext()) {
            Edge toAdd = (Edge) edge.next();
            if (this.addEdge(toAdd) == null)
                if(this.getEdge(toAdd) == null)
                    res &= false;
        }
        return res;
    }

    public boolean containsEdge(Vertex var1, Vertex var2) {
        return (this.getEdge(var1,var2) != null);
    }

    public boolean containsEdge(Edge edge) {
        return (this.getEdge(edge) != null);
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
        return super.removeVertex(var);
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

    public int getSPTForUnWeightGraph(Vertex sourceVertex) {
        Set<Vertex> verticesWeCovered = new HashSet<Vertex>();
        verticesWeCovered.add(sourceVertex);
        return this.getSPTForUnWeightGraph(verticesWeCovered);
    }

    public int getSPTForUnWeightGraph(Set<Vertex> verticesWeCovered) {
        Set<Edge> treeEdges = new HashSet<Edge>();
        Set<Vertex> neighbors = this.getNeighbors(verticesWeCovered);
        Iterator<Vertex> neighborsIter = neighbors.iterator();
        while (neighborsIter.hasNext()){
            Vertex neighbor = (Vertex)neighborsIter.next();
            Iterator<Vertex> iter = verticesWeCovered.iterator();
            boolean foundEdge = false;
            while (iter.hasNext() && !foundEdge){
                Vertex sourceVertex = (Vertex)iter.next();
                Edge edge = this.getEdge(sourceVertex,neighbor);
                if (edge != null){
                    treeEdges.add(edge);
                    foundEdge = true;
                }
            }
        }
        verticesWeCovered.addAll(neighbors);
        if(this.numOfEdges() == verticesWeCovered.size()){
            return 0;
        }
        else {
            return this.getSPTForUnWeightGraph(verticesWeCovered)+1;
        }
    }

    public Graph getSubGraph(Cluster cluster){
        try{
            if(!containsAllVertixes(cluster.getVertices()))
                throw new InputException("part of the vertices does not exist in the graph");
            Graph gSub = this.clone();
            Set<Vertex> toRemove = this.getVertices();
            toRemove.removeAll(cluster.getVertices());
            gSub.removeAllVertixes(toRemove);
            return gSub;
        }
        catch (InputException e){
            System.out.println("part of the vertices does not exist in the graph");
            return null;
        }
    }



    /*public void dijkstra(Vertex sourceVertex) {
        int verticesCount = this.numOfVertices();
        double[] wt = new double[verticesCount];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = Double.MAX_VALUE;
        }
        wt[sourceVertex.getId()] = 0.0;
        Edge[] fr  = new Edge[verticesCount];
        Edge[] mst = new Edge[verticesCount];
        int min = -1;
        Edge edge = null;
        for (int v = 0; min != 0; v = min) {
            min = 0;
            for (int w = 1; w < verticesCount; w++) {
                if (mst[w] == null) {
                    double P = 0.0;
                    edge = this.getEdge(this.getVertex(v), this.getVertex(w));
                    if (edge != null) {
                        if ((P = wt[v] + edge.getWeight()) < wt[w]) {
                            wt[w] = P;
                            fr[w] = edge;
                        }
                    }

                    if (wt[w] < wt[min]) {
                        min = w;
                    }
                }
            }

            if (min != 0) {
                mst[min] = fr[min];
            }
        }

        for (int v = 0; v < verticesCount; v++) {
            if (mst[v] != null) {
                System.out.print(mst[v].getSourceVertex() + "->" + mst[v].getTargetVertex() + " ");
            }
        }
    }*/

}
