import java.util.HashSet;
import java.util.Set;

public class tests {
    public void main(String[] args) {
        System.out.println("tests:");
        System.out.println("vertexs Test:" + verticesTest());
        System.out.println("edges Test:" + edgesTest());
        System.out.println("graph Test:" + graphTest());
    }
    public int verticesTest(){
        int failCuont =0;
        if (!vertexTestGetID()) {failCuont++; System.out.println("vertexTestGetID");}
        if (!vertexTestGetName()) {failCuont++;  System.out.println("vertexTestGetName");}
        if (!vertexTestSetName()) {failCuont++;  System.out.println("vertexTestSetName");}
        if (!vertexTestGetDegree()) {failCuont++;  System.out.println("vertexTestGetDegree");}
        if (!vertexTestIncreaseDegree()) {failCuont++;  System.out.println("vertexTestIncreaseDegree");}
        if (!vertexTestDecreaseDegree()) {failCuont++;  System.out.println("vertexTestDecreaseDegree");}
        return failCuont;
    }
    private boolean vertexTestGetID(){
        Vertex var = new Vertex(1);
        return (var.getId() ==1);
    }
    private boolean vertexTestGetName(){
        Vertex var = new Vertex(1, "ronen");
        return (var.getName().equals("ronen"));
    }
    private boolean vertexTestSetName(){
        Vertex var = new Vertex(1, "ronen");
        var.setName("kethrine");
        return (var.getName().equals("kethrine"));
    }
    private boolean vertexTestGetDegree(){
        Vertex var = new Vertex(1, "ronen");
        return  var.getDegree() == 0;
    }
    private boolean vertexTestIncreaseDegree(){
        Vertex var = new Vertex(1, "ronen");
        var.increaseDegree();
        return ( var.getDegree() == 1);
    }
    private boolean vertexTestDecreaseDegree(){
        Vertex var = new Vertex(1, "ronen");
        var.increaseDegree();
        var.decreaseDegree();
        return ( var.getDegree() == 0);
    }

    public int edgesTest(){
        int failCuont =0;
        if (!edgeTestGetSourceVertex()) {failCuont++; System.out.println("edgeTestGetSourceVertex");}
        if (!edgeTestetTargetVertex()) {failCuont++;  System.out.println("edgeTestetTargetVertex");}
        if (!edgeTestGetWeight()) {failCuont++;  System.out.println("edgeTestGetWeight");}
        if (!edgeTestSetWeight()) {failCuont++;  System.out.println("edgeTestSetWeight");}
        if (!edgeTestContains()) {failCuont++;  System.out.println("edgeTestContains");}
        if (!edgeTestContains()) {failCuont++;  System.out.println("edgeTestContains");}
        if (!edgeTestToString()) {failCuont++;  System.out.println("edgeTestToString");}
        if (!edgeTestEquals()) {failCuont++;  System.out.println("edgeTestEquals");}
        if (!edgeTestEquals1()) {failCuont++;  System.out.println("edgeTestEquals1");}

        return failCuont;
    }
    public boolean edgeTestGetSourceVertex() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Edge edge = new Edge(v1, v2);
        return (edge.getSourceVertex() == v1);
    }
    public boolean edgeTestetTargetVertex() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Edge edge = new Edge(v1, v2);
        return (edge.getTargetVertex() == v2);
    }
    public boolean edgeTestGetWeight() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Edge edge = new Edge(v1, v2,4);
        return (edge.getWeight() == 4);
    }
    public boolean edgeTestSetWeight() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Edge edge = new Edge(v1, v2,4);
        edge.setWeight(10);
        return (edge.getWeight() == 10);
    }
    public boolean edgeTestContains() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Edge edge = new Edge(v1, v2,4);
        return ((edge.contains(v1)) && (edge.contains(v2)));
    }
    public boolean edgeTestToString() {Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Edge edge = new Edge(v1, v2,4);
        return edge.toString().equals("(v1,v2|4.0)");
    }
    public boolean edgeTestEquals() {
            Vertex v1 = new Vertex(1);
            Vertex v2 = new Vertex(2);
            Edge edge1 = new Edge(v1, v2);
            Edge edge2 = new Edge(v2, v1);
            return (edge1.equals(edge2));
    }
    public boolean edgeTestEquals1() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Edge edge1 = new Edge(v1, v2);
        Edge edge2 = new Edge(v2, v3);
        return (!edge1.equals(edge2));
    }
    public int graphTest(){
        int failCuont =0;
        if (!graphTestGetName1()) {failCuont++; System.out.println("graphTestGetName1");}
        if (!graphTestGetName2()) {failCuont++;  System.out.println("graphTestGetName2");}
        if (!graphTestGetVertex()) {failCuont++;  System.out.println("graphTestGetVertex");}
        if (!graphTestNumOfVertices1()) {failCuont++;  System.out.println("graphTestNumOfVertices1");}
        if (!graphTestNumOfVertices2()) {failCuont++;  System.out.println("graphTestNumOfVertices2");}
        if (!graphTestNumOfEdges1()) {failCuont++;  System.out.println("graphTestNumOfEdges1");}
        if (!graphTestNumOfEdges2()) {failCuont++;  System.out.println("graphTestNumOfEdges2");}
        if (!edgeTestEquals1()) {failCuont++;  System.out.println("edgeTestEquals1");}
        if (!graphTestGetEdge1()) {failCuont++;  System.out.println("graphTestGetEdge1");}
        if (!graphTestGetEdge2()) {failCuont++;  System.out.println("graphTestGetEdge2");}
        if (!graphTestGetEdge3()) {failCuont++;  System.out.println("graphTestGetEdge3");}
        if (!graphTestGetEdge4()) {failCuont++;  System.out.println("graphTestGetEdge4");}
        if (!graphTestGetEdge5()) {failCuont++;  System.out.println("graphTestGetEdge5");}
        if (!graphTestAddVertex1()) {failCuont++;  System.out.println("graphTestAddVertex1");}
        if (!graphTestAddVertex2()) {failCuont++;  System.out.println("graphTestAddVertex2");}
        if (!graphTestAddEdge1()) {failCuont++;  System.out.println("graphTestAddEdge1");}
        if (!graphTestAddEdge2()) {failCuont++;  System.out.println("graphTestAddEdge2");}
        if (!graphTestAddEdge3()) {failCuont++;  System.out.println("graphTestAddEdge3");}
        if (!graphTestAddEdge4()) {failCuont++;  System.out.println("graphTestAddEdge4");}
        if (!graphTestAddEdge5()) {failCuont++;  System.out.println("graphTestAddEdge5");}
        if (!graphTestAddEdge6()) {failCuont++;  System.out.println("graphTestAddEdge6");}
        if (!graphTestContainsVertex1()) {failCuont++;  System.out.println("graphTestContainsVertex1");}
        if (!graphTestContainsVertex2()) {failCuont++;  System.out.println("graphTestContainsVertex2");}
        if (!graphTestContainsEdge1()) {failCuont++;  System.out.println("graphTestContainsEdge1");}
        if (!graphTestContainsEdge2()) {failCuont++;  System.out.println("graphTestContainsEdge2");}
        if (!graphTestContainsEdge3()) {failCuont++;  System.out.println("graphTestContainsEdge3");}
        if (!graphTestContainsEdge4()) {failCuont++;  System.out.println("graphTestContainsEdge4");}
        if (!graphTestGetDegree1()) {failCuont++;  System.out.println("graphTestGetDegree1");}
        if (!graphTestGetDegree2()) {failCuont++;  System.out.println("graphTestGetDegree2");}
        if (!graphTestIncomingEdgesOf1()) {failCuont++;  System.out.println("graphTestIncomingEdgesOf1");}
        if (!graphTestIncomingEdgesOf2()) {failCuont++;  System.out.println("graphTestIncomingEdgesOf2");}
        if (!graphTestRemoveVertex1()) {failCuont++;  System.out.println("graphTestRemoveVertex1");}
        if (!graphTestRemoveVertex2()) {failCuont++;  System.out.println("graphTestRemoveVertex2");}
        if (!graphTestRemoveVertex3()) {failCuont++;  System.out.println("graphTestRemoveVertex3");}
        if (!graphTestRemoveEdge1()) {failCuont++;  System.out.println("graphTestRemoveEdge1");}
        if (!graphTestRemoveEdge2()) {failCuont++;  System.out.println("graphTestRemoveEdge2");}
        if (!graphTestRemoveEdge3()) {failCuont++;  System.out.println("graphTestRemoveEdge3");}
        if (!graphTestRemoveEdge4()) {failCuont++;  System.out.println("graphTestRemoveEdge4");}
        if (!graphTestRemoveAllVertixes1()) {failCuont++;  System.out.println("graphTestRemoveAllVertixes1");}
        if (!graphTestRemoveAllVertixes2()) {failCuont++;  System.out.println("graphTestRemoveAllVertixes2");}
        if (!graphTestRemoveAllVertixes3()) {failCuont++;  System.out.println("graphTestRemoveAllVertixes3");}
        if (!graphTestRemoveAllVertixes4()) {failCuont++;  System.out.println("graphTestRemoveAllVertixes4");}
        if (!graphTestRemoveAllEdges1()) {failCuont++;  System.out.println("graphTestRemoveAllEdges1");}
        if (!graphTestRemoveAllEdges2()) {failCuont++;  System.out.println("graphTestRemoveAllEdges2");}
        if (!graphTestSumOfEdges()) {failCuont++;  System.out.println("graphTestSumOfEdges");}
        if (!graphTestGetNeighbors1()) {failCuont++;  System.out.println("graphTestGetNeighbors1");}
        if (!graphTestGetNeighbors2()) {failCuont++;  System.out.println("graphTestGetNeighbors2");}

        return failCuont;
    }
    public boolean graphTestGetName1() {
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        Graph g = new Graph("ronen", vertices, edges);
        return (g.getName().equals("ronen"));
    }
    public boolean graphTestGetName2() {
        Graph g = new Graph("ronen");
        return (g.getName().equals("ronen"));
    }
    public boolean graphTestGetVertex() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        return ((g.getVertex(1)).equals(v1));
    }
    public boolean graphTestNumOfVertices1() {
        Graph g = new Graph("ronen");
        return (g.numOfVertices()==0);
    }
    public boolean graphTestNumOfVertices2() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);

        return (g.numOfVertices()==1);
    }
    public boolean graphTestNumOfEdges1() {
        Graph g = new Graph("ronen");

        return (g.numOfEdges() == 0);
    }
    public boolean graphTestNumOfEdges2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge1 = new Edge(v1,v2);
        edges.add(edge1);
        Graph g = new Graph("ronen", vertices, edges);

        return (g.numOfEdges()==1);
    }
    public boolean graphTestGetEdge1() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1,v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return ((g.getEdge(edge)).equals(edge));
    }
    public boolean graphTestGetEdge2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v2,v1);
        edges.add(edge1);
        edges.add(edge2);
        Graph g = new Graph("ronen", vertices, edges);
        return ((g.getEdge(edge2)).equals(edge1));
    }
    public boolean graphTestGetEdge3() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v2,v3);
        edges.add(edge1);
        Graph g = new Graph("ronen", vertices, edges);
        return (!(g.getEdge(edge1)).equals(edge2));
    }
    public boolean graphTestGetEdge4() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v2,v3);
        edges.add(edge1);
        Graph g = new Graph("ronen", vertices, edges);
        return ((g.getEdge(edge2)) == null);
    }
    public boolean graphTestGetEdge5() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        Graph g = new Graph("ronen", vertices, edges);
        return ((g.getEdge(v1,v3)) == null);
    }
    public boolean graphTestAddVertex1() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        g.addVertex(v1);
        return((g.getVertex(1)).equals(v1));
    }
    public boolean graphTestAddVertex2() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        g.addVertex(v1);
        return(g.numOfVertices() == 1);
    }
    public boolean graphTestAddEdge1() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        Edge edge = new Edge(v1,v2);
        g.addEdge(edge);
        return ((g.getEdge(edge)).equals(edge));
    }
    public boolean graphTestAddEdge2() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        Edge edge1 = new Edge(v1,v2);
        g.addEdge(edge1);
        return (g.numOfEdges() == 1);
    }
    public boolean graphTestAddEdge3() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v2,v1);
        g.addEdge(edge1);
        g.addEdge(edge2);
        return (g.numOfEdges() == 1);
    }
    public boolean graphTestAddEdge4() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);

        return (g.numOfEdges() == 1);
    }
    public boolean graphTestAddEdge5() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        g.addEdge(v2,v1);
        return (g.numOfEdges() == 1);
    }
    public boolean graphTestAddEdge6() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v3,v1);
        g.addEdge(edge1);
        g.addEdge(edge2);

        return (g.numOfEdges() == 1);
    }
    public boolean graphTestContainsVertex1(){
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsVertex(v1);
    }
    public boolean graphTestContainsVertex2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return !g.containsVertex(v2);
    }
    public boolean graphTestContainsEdge1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsEdge(edge);
    }
    public boolean graphTestContainsEdge2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsEdge(v1, v2);
    }
    public boolean graphTestContainsEdge3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsEdge(v2, v1);
    }
    public boolean graphTestContainsEdge4(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return !g.containsEdge(v3, v1);
    }
    public boolean graphTestGetDegree1(){
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return (((g.getVertex(1)).getDegree())== 0);
    }
    public boolean graphTestGetDegree2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        return (((g.getVertex(1)).getDegree())== 2);
    }
    public boolean graphTestIncomingEdgesOf1(){
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return (g.incomingEdgesOf(v1).isEmpty());
    }
    public boolean graphTestIncomingEdgesOf2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        return (g.incomingEdgesOf(v1).size() == 2);
    }
    public boolean graphTestRemoveVertex1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        int before = g.numOfVertices();
        g.removeVertex(v1);
        return (before == 3)&&(g.numOfVertices() == 2);
    }
    public boolean graphTestRemoveVertex2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        int before = g.numOfVertices();
        g.removeVertex(v3);
        return !g.removeVertex(v3);
    }
    public boolean graphTestRemoveVertex3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        int before = g.numOfEdges();
        g.removeVertex(v1);
        return ((before ==2)&&g.numOfEdges()==0);
    }
    public boolean graphTestRemoveEdge1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);

        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        int before = g.numOfEdges();
        g.removeEdge(v1,v2);
        return ((before ==1)&&g.numOfEdges()==0);
    }
    public boolean graphTestRemoveEdge2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        Edge edge = new Edge(v1,v2);
        int before = g.numOfEdges();
        g.removeEdge(edge);

        return ((before ==1)&&g.numOfEdges()==0);
    }
    public boolean graphTestRemoveEdge3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        Edge edge = new Edge(v1,v2);
        int before = g.getVertex(1).getDegree();
        g.removeEdge(edge);
        return ((before ==1)&&g.getVertex(1).getDegree()==0);
    }
    public boolean graphTestRemoveEdge4(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        Edge edge = new Edge(v1,v2);
        int before = g.getVertex(1).getDegree();
        g.removeEdge(v1,v2);
        return ((before ==1)&&g.getVertex(1).getDegree()==0);
    }
    public boolean graphTestRemoveAllVertixes1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        int before = g.numOfVertices();
        g.removeAllVertixes(vertices2);
        return ((before ==3)&& g.numOfVertices()==0);
    }
    public boolean graphTestRemoveAllVertixes2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        int before = g.numOfEdges();
        g.removeAllVertixes(vertices2);
        return ((before ==1)&& g.numOfEdges() == 0);
    }
    public boolean graphTestRemoveAllVertixes3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.removeAllVertixes(vertices2);
        return g.removeAllVertixes(vertices);
    }
    public boolean graphTestRemoveAllVertixes4(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        return (!g.removeAllVertixes(vertices2));
    }
    public boolean graphTestRemoveAllEdges1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v1,v3));
        edges.add(new Edge(v2,v3));
        Set<Edge> edges2 = new HashSet<Edge>();
        edges2.add(new Edge(v1,v2));
        edges2.add(new Edge(v1,v3));
        edges2.add(new Edge(v2,v3));
        Graph g = new Graph("ronen", vertices, edges);

        int before = g.numOfEdges();
        g.removeAllEdges(edges2);
        return ((before ==3)&& g.numOfEdges() == 0);
    }
    public boolean graphTestRemoveAllEdges2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v1,v3));
        Set<Edge> edges2 = new HashSet<Edge>();
        edges2.add(new Edge(v1,v2));
        edges2.add(new Edge(v1,v3));
        edges2.add(new Edge(v2,v3));
        Graph g = new Graph("ronen", vertices, edges);
        int before = g.numOfEdges();

        return (!g.removeAllEdges(edges2));
    }
    public boolean graphTestSumOfEdges(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);

        return (g.sumOfEdges(edges)==2);
    }
    public boolean graphTestGetNeighbors1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);

        return (g.getNeighbors(v1).size() == 2);
    }
    public boolean graphTestGetNeighbors2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        Graph g = new Graph("ronen", vertices, edges);
        //System.out.println(g.getNeighbors(g.getNeighbors(v1)));
        return (g.getNeighbors(v1).size() == 1)&&(g.getNeighbors(g.getNeighbors(v1)).size() == 2);
    }

}
