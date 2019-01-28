import java.util.HashSet;
import java.util.Set;

public class tests {
    public static void main(String[] args) {
        System.out.println("tests:");
        tests t1 = new tests();
        System.out.println("vertexsTest:" + t1.verticesTest());
        System.out.println("edgesTest:" + t1.edgesTest());
        System.out.println("graphTest:" + t1.graphTest());
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
        if (!graphTestGraphName()) {failCuont++; System.out.println("graphTestGraphName");}
        if (!graphTestGetVertex()) {failCuont++;  System.out.println("graphTestGetVertex");}
        if (!graphTestGetName()) {failCuont++;  System.out.println("graphTestGetName");}
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
        if (!graphTestIncomingRemoveVertex1()) {failCuont++;  System.out.println("graphTestIncomingRemoveVertex1");}
        if (!graphTestIncomingRemoveVertex2()) {failCuont++;  System.out.println("graphTestIncomingRemoveVertex2");}
        if (!graphTestIncomingRemoveVertex3()) {failCuont++;  System.out.println("graphTestIncomingRemoveVertex3");}
        if (!graphTestIncomingRemoveEdge1()) {failCuont++;  System.out.println("graphTestIncomingRemoveEdge1");}
        if (!graphTestIncomingRemoveEdge2()) {failCuont++;  System.out.println("graphTestIncomingRemoveEdge2");}
        if (!graphTestIncomingRemoveEdge3()) {failCuont++;  System.out.println("graphTestIncomingRemoveEdge3");}
        if (!graphTestIncomingRemoveEdge4()) {failCuont++;  System.out.println("graphTestIncomingRemoveEdge4");}
        if (!graphTestIncomingRemoveAllVertixes1()) {failCuont++;  System.out.println("graphTestIncomingRemoveAllVertixes1");}
        if (!graphTestIncomingRemoveAllVertixes2()) {failCuont++;  System.out.println("graphTestIncomingRemoveAllVertixes2");}
        if (!graphTestIncomingRemoveAllVertixes3()) {failCuont++;  System.out.println("graphTestIncomingRemoveAllVertixes3");}
        if (!graphTestIncomingRemoveAllVertixes4()) {failCuont++;  System.out.println("graphTestIncomingRemoveAllVertixes4");}
        if (!graphTestIncomingRemoveAllEdges1()) {failCuont++;  System.out.println("graphTestIncomingRemoveAllEdges1");}
        if (!graphTestIncomingRemoveAllEdges2()) {failCuont++;  System.out.println("graphTestIncomingRemoveAllEdges2");}
        if (!graphTestSumOfEdges()) {failCuont++;  System.out.println("graphTestSumOfEdges");}
        if (!graphTestGetNeighbors1()) {failCuont++;  System.out.println("graphTestGetNeighbors1");}
        if (!graphTestGetNeighbors2()) {failCuont++;  System.out.println("graphTestGetNeighbors2");}

        return failCuont;
    }
    public boolean graphTestGraphName() {
        Graph g = new Graph("ronen");
        return (g.getGraphName().equals("ronen"));
    }
    public boolean graphTestGetVertex() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        return ((g.getVertex(1)).equals(v1));
    }
    public boolean graphTestGetName() {
        Graph g = new Graph("ronen",null,null);
        return (g.getGraphName().equals("ronen"));
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
    public boolean graphTestIncomingRemoveVertex1(){
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
    public boolean graphTestIncomingRemoveVertex2(){
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
    public boolean graphTestIncomingRemoveVertex3(){
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
    public boolean graphTestIncomingRemoveEdge1(){
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
    public boolean graphTestIncomingRemoveEdge2(){
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
    public boolean graphTestIncomingRemoveEdge3(){
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
    public boolean graphTestIncomingRemoveEdge4(){
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
    public boolean graphTestIncomingRemoveAllVertixes1(){
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
    public boolean graphTestIncomingRemoveAllVertixes2(){
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
    public boolean graphTestIncomingRemoveAllVertixes3(){
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
    public boolean graphTestIncomingRemoveAllVertixes4(){
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
    public boolean graphTestIncomingRemoveAllEdges1(){
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
    public boolean graphTestIncomingRemoveAllEdges2(){
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
