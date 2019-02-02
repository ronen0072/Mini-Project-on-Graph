import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;


public class Graph extends Cluster implements GraphInterface,Cloneable{
    protected Set<Edge> edges;

    public Graph(String graphName, Set<SuperVertex> vertices, Set<Edge> edges){
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
            Edge e = ((Edge) iter.next());
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

    public Edge getEdge(SuperVertex sourceVertex, SuperVertex targetVertex) {
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

    public Edge addEdge(SuperVertex sourceVertex, SuperVertex targetVertex) {
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
                if(this.containsEdge(toAdd))
                    res &= false;
        }
        return res;
    }

    public boolean containsEdge(SuperVertex var1, SuperVertex var2) {
        return (this.getEdge(var1,var2) != null);
    }

    public boolean containsEdge(Edge edge) {
        return (this.getEdge(edge) != null);
    }

    public Set<Edge> incomingEdgesOf(SuperVertex var) {
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


    public Edge removeEdge(SuperVertex var1, SuperVertex var2) {
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

    public boolean removeVertex(SuperVertex var) {
        Set<Edge> edgesToRemove = this.incomingEdgesOf(var);
        this.removeAllEdges(edgesToRemove);
        return super.removeVertex(var);
    }

    public SuperVertex getEdgeSource(Edge var) {
        return var.getSourceVertex();
    }

    public SuperVertex getEdgeTarget(Edge var) {
        return var.getTargetVertex();
    }

    public double getEdgeWeight(Edge var) {
        return var.getWeight();
    }

    public void setEdgeWeight(Edge var, double weight) {
        (this.getEdge(var)).setWeight(weight);
    }

    public void setEdgeWeight(SuperVertex sourceVertex, SuperVertex targetVertex, double weight) {
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

    public  Set<SuperVertex> getNeighbors(SuperVertex v){
        SuperVertex var = getVertex(v);
        Set<SuperVertex> res = new HashSet<SuperVertex>();
        Set<Edge> incomingEdges =  this.incomingEdgesOf(var);
        Iterator edge = incomingEdges.iterator();
        while (edge.hasNext()) {
            Edge toAdd = (Edge) edge.next();
            res.add(toAdd.getSourceVertex());
            res.add(toAdd.getTargetVertex());
        }
        res.remove(var);
        return res;
    }

    public  Set<SuperVertex> getNeighbors(Set<SuperVertex> rv){
        Set<SuperVertex> res = new HashSet<SuperVertex>();
        Iterator vertex = rv.iterator();
        while (vertex.hasNext()) {
            SuperVertex v = (SuperVertex) vertex.next();
            res.addAll(this.getNeighbors(v));
        }
        res.removeAll(rv);
        return res;
    }

    public int getSPTForUnWeightGraph(SuperVertex sourceVertex) {
        Set<SuperVertex> verticesWeCovered = new HashSet<SuperVertex>();
        verticesWeCovered.add(sourceVertex);
        Set<Edge> treeEdges = new HashSet<Edge>();
        return this.getSPTForUnWeightGraph(verticesWeCovered, treeEdges);
    }

    public int getSPTForUnWeightGraph(Set<SuperVertex> verticesWeCovered, Set<Edge> treeEdges) {
        Set<SuperVertex> neighbors = this.getNeighbors(verticesWeCovered);
        try{
            if(neighbors.isEmpty()&& (verticesWeCovered.size() < this.numOfVertices()))
                throw new Exception("the graph is not connected so there is no SPT for this graph:"+this);
            Iterator<SuperVertex> neighborsIter = neighbors.iterator();
            while (neighborsIter.hasNext()){
                SuperVertex neighbor = (SuperVertex)neighborsIter.next();
                Iterator<SuperVertex> iter = verticesWeCovered.iterator();
                boolean foundEdge = false;
                while (iter.hasNext() && !foundEdge){
                    SuperVertex sourceVertex = (SuperVertex)iter.next();
                    Edge edge = this.getEdge(sourceVertex,neighbor);
                    if (edge != null){
                        treeEdges.add(edge);
                        foundEdge = true;
                    }
                }
            }
            verticesWeCovered.addAll(neighbors);
            if(this.numOfVertices() == verticesWeCovered.size()){
                this.edges = treeEdges;
                return 0;
            }
            else {
                return this.getSPTForUnWeightGraph(verticesWeCovered, treeEdges)+1;
            }
        }
        catch (Exception e){
            System.out.println("the graph is not connected so there is no SPT for this graph:"+this);
            return Integer.MAX_VALUE;
        }
    }

    public Graph getSubGraph(Cluster cluster){
        try{
            if(!containsAllVertices(cluster.getVertices()))
                throw new InputException("part of the vertices does not exist in the graph");
            else {
                Graph gSub = this.clone();
                gSub.removeAllVerticesExceptFrom(cluster.getVertices());

                return gSub;
            }
        }
        catch (InputException e){
            System.out.println("part of the vertices does not exist in the graph");
            return null;
        }
    }
    public Set<SuperVertex> getLNeighbors(Set<SuperVertex> vertices,int l){
        Set<SuperVertex> lNeighbors = new HashSet<SuperVertex>();
        try {
            if (!containsAllVertices(vertices))
                throw new InputException("part of the vertices does not exist in the graph");
            else {
                lNeighbors.addAll(vertices);
                for (int i = 0; (i < l); i++) {
                    Set<SuperVertex> newNeighbors = this.getNeighbors(lNeighbors);
                    if (newNeighbors.size() != 0)
                        lNeighbors.addAll(newNeighbors);
                    else {
                        lNeighbors.removeAll(vertices);
                        return lNeighbors;
                    }
                }
                lNeighbors.removeAll(vertices);
                return lNeighbors;
            }
        }
        catch (InputException e){
            System.out.println("part of the vertices does not exist in the graph");
            return lNeighbors;
        }
    }
    public Set<SpannedCluster> getLSpannedClusterNeighbors(Cluster cluster, int l){
        Set<SuperVertex> lNeighbors = getLNeighbors(cluster.getVertices(), l);
        Set<SpannedCluster> SpannedClusterLNeighbors = new HashSet<SpannedCluster>();
        Iterator<SuperVertex> iter = lNeighbors.iterator();
        while (iter.hasNext()) {
            SuperVertex Neighbor = (SuperVertex) iter.next();
            SpannedClusterLNeighbors.add(Neighbor.getSpannedCluster());
        }
        return SpannedClusterLNeighbors;
    }


    /*public void dijkstra(SuperVertex sourceVertex) {
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
