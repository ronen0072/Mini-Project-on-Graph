import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tests {
    public static void main(String[] args) {
        String numOffFails = "The number of failures: ";
        Tests t = new Tests();
        System.out.println("tests:");
        System.out.println("Vertexs Test:");
        System.out.println(numOffFails+t.verticesTest());
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Super Vertices Test:");
        System.out.println(numOffFails+t.superVerticesTest());
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Edges Test:");
        System.out.println(numOffFails+t.edgesTest());
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Cluster Test:");
        System.out.println(numOffFails+t.testCluster());
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Graph Test:");
        System.out.println(numOffFails+t.graphTest());
        System.out.println("______________________________________________________________________________________________");
        System.out.println("Spanned Cluster Test:");
        System.out.println(numOffFails+t.spannedClusterTest());
        System.out.println("______________________________________________________________________________________________");
        System.out.println("SpCons Test:");
        System.out.println(numOffFails+t.algorithmTest());
        System.out.println("______________________________________________________________________________________________");

        //t.algorithmsTestdijkstra();


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
        SuperVertex var = new SuperVertex(1);
        return (var.getId() ==1);
    }
    private boolean vertexTestGetName(){
        SuperVertex var = new SuperVertex(1, "ronen");
        return (var.getName().equals("ronen"));
    }
    private boolean vertexTestSetName(){
        SuperVertex var = new SuperVertex(1, "ronen");
        var.setName("kethrine");
        return (var.getName().equals("kethrine"));
    }
    private boolean vertexTestGetDegree(){
        SuperVertex var = new SuperVertex(1, "ronen");
        return  var.getDegree() == 0;
    }
    private boolean vertexTestIncreaseDegree(){
        SuperVertex var = new SuperVertex(1, "ronen");
        var.increaseDegree();
        return ( var.getDegree() == 1);
    }
    private boolean vertexTestDecreaseDegree(){
        SuperVertex var = new SuperVertex(1, "ronen");
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Edge edge = new Edge(v1, v2);
        return (edge.getSourceVertex() == v1);
    }
    public boolean edgeTestetTargetVertex() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Edge edge = new Edge(v1, v2);
        return (edge.getTargetVertex() == v2);
    }
    public boolean edgeTestGetWeight() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Edge edge = new Edge(v1, v2,4);
        return (edge.getWeight() == 4);
    }
    public boolean edgeTestSetWeight() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Edge edge = new Edge(v1, v2,4);
        edge.setWeight(10);
        return (edge.getWeight() == 10);
    }
    public boolean edgeTestContains() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Edge edge = new Edge(v1, v2,4);
        return ((edge.contains(v1)) && (edge.contains(v2)));
    }
    public boolean edgeTestToString() {SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Edge edge = new Edge(v1, v2,4);
        return edge.toString().equals("(v1,v2|4.0)");
    }
    public boolean edgeTestEquals() {
            SuperVertex v1 = new SuperVertex(1);
            SuperVertex v2 = new SuperVertex(2);
            Edge edge1 = new Edge(v1, v2);
            Edge edge2 = new Edge(v2, v1);
            return (edge1.equals(edge2));
    }
    public boolean edgeTestEquals1() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
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
        if (!graphTestGetNeighbors3()) {failCuont++;  System.out.println("graphTestGetNeighbors3");}
        if (!graphTestGetSPTForUnWeightGraph1()) {failCuont++;  System.out.println("graphTestGetSPTForUnWeightGraph1");}
        if (!graphTestGetSPTForUnWeightGraph2()) {failCuont++;  System.out.println("graphTestGetSPTForUnWeightGraph2");}
        if (!graphTestGetSPTForUnWeightGraph3()) {failCuont++;  System.out.println("graphTestGetSPTForUnWeightGraph3");}
        if (!graphTestGetSPTForUnWeightGraph4()) {failCuont++;  System.out.println("graphTestGetSPTForUnWeightGraph4");}
        if (!graphTestGetSubGraph1()) {failCuont++;  System.out.println("graphTestGetSubGraph1");}
        if (!graphTestGetSubGraph2()) {failCuont++;  System.out.println("graphTestGetSubGraph2");}
        if (!graphTestGetSubGraph3()) {failCuont++;  System.out.println("graphTestGetSubGraph3");}
        if (!graphTestGetLNeighbors0()) {failCuont++;  System.out.println("graphTestGetLNeighbors0");}
        if (!graphTestGetLNeighbors1()) {failCuont++;  System.out.println("graphTestGetLNeighbors1");}
        if (!graphTestGetLNeighbors2()) {failCuont++;  System.out.println("graphTestGetLNeighbors2");}
        if (!graphTestGetLSpannedClusterNeighbors()) {failCuont++;  System.out.println("graphTestGetLSpannedClusterNeighbors");}
        if (!graphTestIsConnected1()) {failCuont++;  System.out.println("graphTestIsConnected1");}
        if (!graphTestIsConnected2()) {failCuont++;  System.out.println("graphTestIsConnected2");}
        if (!graphTestRandomConstructor1()) {failCuont++;  System.out.println("graphTestRandomConstructor1");}
        if (!graphTestGetShortestPath0()) {failCuont++;  System.out.println("graphTestGetShortestPath0");}
        if (!graphTestGetShortestPath1()) {failCuont++;  System.out.println("graphTestGetShortestPath1");}
        if (!graphTestGetShortestPath2()) {failCuont++;  System.out.println("graphTestGetShortestPath2");}
        if (!graphTestGetShortestPath3()) {failCuont++;  System.out.println("graphTestGetShortestPath3");}
        if (!graphTestGetShortestPath4()) {failCuont++;  System.out.println("graphTestGetShortestPath4");}
        return failCuont;
    }
    private Graph example(){
        Graph g = new Graph("example");
        SuperVertex[] v = new SuperVertex[19];
        for (int i=1; i<=18; i++){
            v[i] = new SuperVertex(i);
            g.addVertex(v[i]);
        }
        for (int i=2; i<=5; i++)
            g.addEdge(v[1],v[i]);
        g.addEdge(v[2],v[3]);
        g.addEdge(v[4],v[5]);

        g.addEdge(v[6],v[7]);
        g.addEdge(v[6],v[8]);
        g.addEdge(v[9],v[7]);
        g.addEdge(v[9],v[8]);
        g.addEdge(v[8],v[7]);

        g.addEdge(v[8],v[10]);

        g.addEdge(v[12],v[10]);
        g.addEdge(v[12],v[11]);
        g.addEdge(v[11],v[10]);

        g.addEdge(v[11],v[4]);

        g.addEdge(v[2],v[16]);

        g.addEdge(v[17],v[16]);
        g.addEdge(v[17],v[18]);

        g.addEdge(v[13],v[5]);

        g.addEdge(v[15],v[14]);

        g.addEdge(v[3],v[14]);
        return g;

    }
    private Graph example2(){
        Graph g = new Graph("example");
        SuperVertex[] v = new SuperVertex[61];
        for (int i=1; i<=60; i++){
            v[i] = new SuperVertex(i);
            g.addVertex(v[i]);
        }
        for (int i=1; i<=4; i++)
            g.addEdge(v[5],v[i]);
        g.addEdge(v[1],v[2]);
        g.addEdge(v[4],v[7]);
        g.addEdge(v[3],v[6]);
        g.addEdge(v[6],v[7]);
        g.addEdge(v[7],v[13]);

        g.addEdge(v[13],v[15]);
        g.addEdge(v[13],v[14]);
        for (int i=14; i<=19; i++)
            if((i != 16)&&(i != 18))
                g.addEdge(v[16],v[i]);
        g.addEdge(v[14],v[18]);

        g.addEdge(v[10],v[9]);
        g.addEdge(v[10],v[11]);
        g.addEdge(v[9],v[8]);
        g.addEdge(v[11],v[12]);

        g.addEdge(v[9],v[15]);
        g.addEdge(v[12],v[34]);
        g.addEdge(v[17],v[34]);
        g.addEdge(v[34],v[35]);
        g.addEdge(v[35],v[38]);

        for (int i=20; i<=24; i++)
            if(i != 22)
                g.addEdge(v[22],v[i]);
        g.addEdge(v[20],v[21]);
        g.addEdge(v[20],v[23]);
        g.addEdge(v[24],v[25]);

        for (int i=25; i<=28; i++)
            if(i != 26)
                g.addEdge(v[26],v[i]);
        g.addEdge(v[28],v[27]);
        g.addEdge(v[28],v[25]);


        g.addEdge(v[29],v[24]);
        g.addEdge(v[24],v[31]);
        g.addEdge(v[29],v[31]);
        g.addEdge(v[29],v[33]);
        g.addEdge(v[32],v[33]);
        g.addEdge(v[31],v[32]);
        g.addEdge(v[33],v[30]);



        g.addEdge(v[30],v[36]);
        g.addEdge(v[36],v[37]);
        g.addEdge(v[37],v[38]);
        g.addEdge(v[38],v[39]);
        g.addEdge(v[39],v[40]);
        g.addEdge(v[40],v[41]);
        g.addEdge(v[41],v[49]);

        for (int i=46; i<=53; i++)
            if((i != 47)&&(i != 49)&&(i != 52))
                g.addEdge(v[49],v[i]);

        g.addEdge(v[46],v[47]);
        g.addEdge(v[47],v[48]);
        g.addEdge(v[51],v[52]);
        g.addEdge(v[52],v[53]);

        for (int i=43; i<=45; i++)
            g.addEdge(v[42],v[i]);
        g.addEdge(v[45],v[47]);


        g.addEdge(v[54],v[55]);
        g.addEdge(v[54],v[56]);
        g.addEdge(v[55],v[57]);
        g.addEdge(v[55],v[58]);
        g.addEdge(v[56],v[58]);
        g.addEdge(v[56],v[59]);
        g.addEdge(v[59],v[60]);
        g.addEdge(v[60],v[51]);
        return g;

    }
    public boolean graphTestGraphName() {
        Graph g = new Graph("ronen");
        return (g.getName().equals("ronen"));
    }
    public boolean graphTestGetVertex() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        return ((g.getVertex(1)).equals(v1));
    }
    public boolean graphTestGetName() {
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        Graph g = new Graph("ronen",vertices,edges);
        return (g.getName().equals("ronen"));
    }
    public boolean graphTestNumOfVertices1() {
        Graph g = new Graph("ronen");
        return (g.numOfVertices()==0);
    }
    public boolean graphTestNumOfVertices2() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge1 = new Edge(v1,v2);
        edges.add(edge1);
        Graph g = new Graph("ronen", vertices, edges);

        return (g.numOfEdges()==1);
    }
    public boolean graphTestGetEdge1() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1,v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return ((g.getEdge(edge)).equals(edge));
    }
    public boolean graphTestGetEdge2() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        Graph g = new Graph("ronen", vertices, edges);
        return ((g.getEdge(v1,v3)) == null);
    }
    public boolean graphTestAddVertex1() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        g.addVertex(v1);
        return((g.getVertex(1)).equals(v1));
    }
    public boolean graphTestAddVertex2() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, null);
        g.addVertex(v1);
        return(g.numOfVertices() == 1);
    }
    public boolean graphTestAddEdge1() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        Edge edge = new Edge(v1,v2);
        g.addEdge(edge);
        return ((g.getEdge(edge)).equals(edge));
    }
    public boolean graphTestAddEdge2() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);

        return (g.numOfEdges() == 1);
    }
    public boolean graphTestAddEdge5() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        g.addEdge(v2,v1);
        return (g.numOfEdges() == 1);
    }
    public boolean graphTestAddEdge6() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsVertex(v1);
    }
    public boolean graphTestContainsVertex2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return !g.containsVertex(v2);
    }
    public boolean graphTestContainsEdge1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsEdge(edge);
    }
    public boolean graphTestContainsEdge2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsEdge(v1, v2);
    }
    public boolean graphTestContainsEdge3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Edge edge = new Edge(v1, v2);
        edges.add(edge);
        Graph g = new Graph("ronen", vertices, edges);
        return g.containsEdge(v2, v1);
    }
    public boolean graphTestContainsEdge4(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return (((g.getVertex(1)).getDegree())== 0);
    }
    public boolean graphTestGetDegree2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        Graph g = new Graph("ronen", vertices, edges);
        return (g.incomingEdgesOf(v1).isEmpty());
    }
    public boolean graphTestIncomingEdgesOf2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Graph g = new Graph("ronen", vertices, edges);
        int before = g.numOfVertices();
        g.removeVertex(v3);
        return !g.removeVertex(v3);
    }
    public boolean graphTestRemoveVertex3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        int before = g.numOfVertices();
        g.removeAllVertices(vertices2);
        return ((before ==3)&& g.numOfVertices()==0);
    }
    public boolean graphTestRemoveAllVertixes2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        g.addEdge(v1,v2);
        int before = g.numOfEdges();
        g.removeAllVertices(vertices2);
        return ((before ==1)&& g.numOfEdges() == 0);
    }
    public boolean graphTestRemoveAllVertixes3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        return g.removeAllVertices(vertices);
    }
    public boolean graphTestRemoveAllVertixes4(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Graph g = new Graph("ronen", vertices, edges);
        return (!g.removeAllVertices(vertices2));
    }
    public boolean graphTestRemoveAllEdges1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
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
    private boolean graphTestGetNeighbors3(){
        SuperVertex var = new SuperVertex(1);
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster c = new Cluster("ronen", vertices);
        Set<Edge> edges = new HashSet<Edge>();
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        g.getSPTForUnWeightGraph(v1);
        System.out.println(g);
        return (g.getNeighbors(v1).size() == 2);
    }
    public boolean graphTestGetSPTForUnWeightGraph1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        g.getSPTForUnWeightGraph(v1);
        //System.out.println(g);
        return (g.numOfEdges() == 2);
    }
    public boolean graphTestGetSPTForUnWeightGraph2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        Graph g = new Graph("ronen", vertices, edges);

        return (g.getSPTForUnWeightGraph(v1) != (int)Integer.MAX_VALUE);
    }
    private boolean graphTestGetSPTForUnWeightGraph3(){
        SuperVertex var = new SuperVertex(1);
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster c = new Cluster("ronen", vertices);
        Set<Edge> edges = new HashSet<Edge>();
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        g.getSPTForUnWeightGraph(v1);
        //System.out.println(g);
        return (g.numOfEdges() == 2);
    }
    private boolean graphTestGetSPTForUnWeightGraph4(){
        Graph g = example();
        //System.out.println(g);
        g.getSPTForUnWeightGraph(g.getVertex(1));
        //System.out.println(g);
        return (g.numOfVertices()-1 == g.numOfEdges());
    }
    public boolean graphTestGetSubGraph1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        Cluster s = new Cluster("ronen", vertices2);
        Graph h = g.getSubGraph(s);
        System.out.println(h);
        return (h.numOfEdges() == 1)&&(h.numOfVertices() == 2);
    }
    public boolean graphTestGetSubGraph2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        Cluster s = new Cluster("ronen", vertices2);
        Graph h = g.getSubGraph(s);
        //System.out.println(h);
        return (h.numOfEdges() == 0)&&(h.numOfVertices() == 0);
    }
    private boolean graphTestGetSubGraph3(){
        Graph g = example();
        //System.out.println(g);
        Cluster c1 = new Cluster("1,2,3,4,5");
        Cluster c7 = new Cluster("6,7,8,9");
        Cluster c12 = new Cluster("10,11,12");
        Cluster c13 = new Cluster("13");
        Cluster c15 = new Cluster("14,15");
        Cluster c17 = new Cluster("16,17,18");
        for (int i=1; i<=18; i++){
            if((1<=i)&&(i<=5)){
                c1.addVertex(g.getVertex(i));
            }
            if((6<=i)&&(i<=9)){
                c7.addVertex(g.getVertex(i));
            }
            if((10<=i)&&(i<=12)){
                c12.addVertex(g.getVertex(i));
            }
            if(13 == i){
                c13.addVertex(g.getVertex(i));
            }
            if((14<=i)&&(i<=15)){
                c15.addVertex(g.getVertex(i));
            }
            if((16<=i)&&(i<=18)){
                c17.addVertex(g.getVertex(i));
            }
        }
        Graph h1 = g.getSubGraph(c1);
        Graph h7 = g.getSubGraph(c7);
        Graph h12 = g.getSubGraph(c12);
        Graph h13 = g.getSubGraph(c13);
        Graph h15 = g.getSubGraph(c15);
        Graph h17 = g.getSubGraph(c17);
        //System.out.println(g);
        return ((h1.numOfEdges() == 6)&&(h1.numOfVertices() == 5))&&
                ((h7.numOfEdges() == 5)&&(h7.numOfVertices() == 4))&&
                ((h12.numOfEdges() == 3)&&(h12.numOfVertices() == 3))&&
                ((h13.numOfEdges() == 0)&&(h13.numOfVertices() == 1))&&
                ((h15.numOfEdges() == 1)&&(h15.numOfVertices() == 2))&&
                ((h17.numOfEdges() == 2)&&(h17.numOfVertices() == 3));
    }
    private boolean graphTestGetLNeighbors0() {
        Graph g = example();
        SuperVertex v19 = new SuperVertex(19);
        Set<SuperVertex> setV = new HashSet<SuperVertex>();
        setV.add(v19);
        //System.out.println("TestGetLNeighbors1"+g.getLNeighbors(setV,1));
        return (g.getLNeighbors(setV,1).size() == 0);
    }
    private boolean graphTestGetLNeighbors1() {
        Graph g = example();
        Set<SuperVertex> setV = new HashSet<SuperVertex>();
        setV.add(g.getVertex(1));
        //System.out.println("TestGetLNeighbors1"+g.getLNeighbors(setV,1));
        return (g.getLNeighbors(setV,1).size() == 5);
    }
    private boolean graphTestGetLNeighbors2() {
        Graph g = example();
        Set<SuperVertex> setV = new HashSet<SuperVertex>();
        setV.add(g.getVertex(1));
        //System.out.println("TestGetLNeighbors1"+g.getLNeighbors(setV,1));
        return (g.getLNeighbors(setV,2).size() == 9);
    }
    private boolean graphTestGetLSpannedClusterNeighbors(){
        Graph g = example();
        //System.out.println(g);
        Cluster c1 = new Cluster("1,2,3,4,5");
        Cluster c7 = new Cluster("6,7,8,9");
        Cluster c12 = new Cluster("10,11,12");
        Cluster c13 = new Cluster("13");
        Cluster c15 = new Cluster("14,15");
        Cluster c17 = new Cluster("16,17,18");
        for (int i=1; i<=18; i++){
            if((1<=i)&&(i<=5)){
                c1.addVertex(g.getVertex(i));
            }
            if((6<=i)&&(i<=9)){
                c7.addVertex(g.getVertex(i));
            }
            if((10<=i)&&(i<=12)){
                c12.addVertex(g.getVertex(i));
            }
            if(13 == i){
                c13.addVertex(g.getVertex(i));
            }
            if((14<=i)&&(i<=15)){
                c15.addVertex(g.getVertex(i));
            }
            if((16<=i)&&(i<=18)){
                c17.addVertex(g.getVertex(i));
            }
        }
        SpannedCluster s1 = new SpannedCluster(g.getVertex(1),c1,g.getSubGraph(c1));
        SpannedCluster s7 = new SpannedCluster(g.getVertex(7),c7,g.getSubGraph(c7));
        SpannedCluster s12 = new SpannedCluster(g.getVertex(12),c12,g.getSubGraph(c12));
        SpannedCluster s13 = new SpannedCluster(g.getVertex(13),c13,g.getSubGraph(c13));
        SpannedCluster s15 = new SpannedCluster(g.getVertex(15),c15,g.getSubGraph(c15));
        SpannedCluster s17 = new SpannedCluster(g.getVertex(17),c17,g.getSubGraph(c17));
        //System.out.println("graphTestGetLSpannedClusterNeighbors:"+g.getLSpannedClusterNeighbors(s1,1));
        return (g.getLSpannedClusterNeighbors(s1,1).size() == 5);
    }
    private boolean graphTestIsConnected1(){
        Graph g = example();
        return g.isConnected();
    }
    private boolean graphTestIsConnected2(){
        Graph g = example();
        g.removeEdge(g.getVertex(5),g.getVertex(13));
        return !g.isConnected();
    }
    private boolean graphTestRandomConstructor1(){
        Graph g = new Graph("Random Graph", 30 , 0.3 , 0.2);
        //System.out.println(g.isConnected());
        //System.out.println(g);
        g.getSPTForUnWeightGraph(g.getVertex(1));
        //System.out.println(g);
        return g.isConnected();
    }

    private boolean graphTestGetShortestPath0() {
    Graph g = example();

        return g.getDistance(g.getVertex(1),g.getVertex(7)) == 5;
    }

    private boolean graphTestGetShortestPath1() {
        Graph g = example();
        //System.out.println(g.getShortestPath(g.getVertex(18),g.getVertex(7)).size());
        return g.getDistance(g.getVertex(18),g.getVertex(7)) == 9;
    }

    private boolean graphTestGetShortestPath2(){
        Graph g = example();
        //System.out.println(g);
        Cluster c1 = new Cluster("1,2,3,4,5");
        Cluster c7 = new Cluster("6,7,8,9");
        Cluster c12 = new Cluster("10,11,12");
        Cluster c13 = new Cluster("13");
        Cluster c15 = new Cluster("14,15");
        Cluster c17 = new Cluster("16,17,18");
        for (int i=1; i<=18; i++){
            if((1<=i)&&(i<=5)){
                c1.addVertex(g.getVertex(i));
            }
            if((6<=i)&&(i<=9)){
                c7.addVertex(g.getVertex(i));
            }
            if((10<=i)&&(i<=12)){
                c12.addVertex(g.getVertex(i));
            }
            if(13 == i){
                c13.addVertex(g.getVertex(i));
            }
            if((14<=i)&&(i<=15)){
                c15.addVertex(g.getVertex(i));
            }
            if((16<=i)&&(i<=18)){
                c17.addVertex(g.getVertex(i));
            }
        }
        SpannedCluster s1 = new SpannedCluster(g.getVertex(1),c1,g.getSubGraph(c1));
        SpannedCluster s7 = new SpannedCluster(g.getVertex(7),c7,g.getSubGraph(c7));
        SpannedCluster s12 = new SpannedCluster(g.getVertex(12),c12,g.getSubGraph(c12));
        SpannedCluster s13 = new SpannedCluster(g.getVertex(13),c13,g.getSubGraph(c13));
        SpannedCluster s15 = new SpannedCluster(g.getVertex(15),c15,g.getSubGraph(c15));
        SpannedCluster s17 = new SpannedCluster(g.getVertex(17),c17,g.getSubGraph(c17));

        //System.out.println(g.getShortestPath(s
        // 1,s7));
        return g.getShortestPath(s1,s7).numOfEdges()==3;
    }
    private boolean graphTestGetShortestPath3(){
        Graph g = example();
        //System.out.println(g);
        Cluster c1 = new Cluster("1,2,3,4,5");
        Cluster c7 = new Cluster("6,7,8,9");
        Cluster c12 = new Cluster("10,11,12");
        Cluster c13 = new Cluster("13");
        Cluster c15 = new Cluster("14,15");
        Cluster c17 = new Cluster("16,17,18");
        for (int i=1; i<=18; i++){
            if((1<=i)&&(i<=5)){
                c1.addVertex(g.getVertex(i));
            }
            if((6<=i)&&(i<=9)){
                c7.addVertex(g.getVertex(i));
            }
            if((10<=i)&&(i<=12)){
                c12.addVertex(g.getVertex(i));
            }
            if(13 == i){
                c13.addVertex(g.getVertex(i));
            }
            if((14<=i)&&(i<=15)){
                c15.addVertex(g.getVertex(i));
            }
            if((16<=i)&&(i<=18)){
                c17.addVertex(g.getVertex(i));
            }
        }
        SpannedCluster s1 = new SpannedCluster(g.getVertex(1),c1,g.getSubGraph(c1));
        SpannedCluster s7 = new SpannedCluster(g.getVertex(7),c7,g.getSubGraph(c7));
        SpannedCluster s12 = new SpannedCluster(g.getVertex(12),c12,g.getSubGraph(c12));
        SpannedCluster s13 = new SpannedCluster(g.getVertex(13),c13,g.getSubGraph(c13));
        SpannedCluster s15 = new SpannedCluster(g.getVertex(15),c15,g.getSubGraph(c15));
        SpannedCluster s17 = new SpannedCluster(g.getVertex(17),c17,g.getSubGraph(c17));

        //System.out.println(g.getShortestPath(s1,s7));
        return g.getShortestPath(s1,s15).numOfEdges()==1;
    }

    private boolean graphTestGetShortestPath4(){
        Graph g = example();
        //System.out.println(g);
        Cluster c1 = new Cluster("1,2,3,4,5");
        Cluster c7 = new Cluster("6,7,8,9");
        Cluster c12 = new Cluster("10,11,12");
        Cluster c13 = new Cluster("13");
        Cluster c15 = new Cluster("14,15");
        Cluster c17 = new Cluster("16,17,18");
        for (int i=1; i<=18; i++){
            if((1<=i)&&(i<=5)){
                c1.addVertex(g.getVertex(i));
            }
            if((6<=i)&&(i<=9)){
                c7.addVertex(g.getVertex(i));
            }
            if((10<=i)&&(i<=12)){
                c12.addVertex(g.getVertex(i));
            }
            if(13 == i){
                c13.addVertex(g.getVertex(i));
            }
            if((14<=i)&&(i<=15)){
                c15.addVertex(g.getVertex(i));
            }
            if((16<=i)&&(i<=18)){
                c17.addVertex(g.getVertex(i));
            }
        }
        SpannedCluster s1 = new SpannedCluster(g.getVertex(1),c1,g.getSubGraph(c1));
        SpannedCluster s7 = new SpannedCluster(g.getVertex(7),c7,g.getSubGraph(c7));
        SpannedCluster s12 = new SpannedCluster(g.getVertex(12),c12,g.getSubGraph(c12));
        SpannedCluster s13 = new SpannedCluster(g.getVertex(13),c13,g.getSubGraph(c13));
        SpannedCluster s15 = new SpannedCluster(g.getVertex(15),c15,g.getSubGraph(c15));
        SpannedCluster s17 = new SpannedCluster(g.getVertex(17),c17,g.getSubGraph(c17));

        //System.out.println(g.getShortestPath(s1,s7));
        return g.getShortestPath(s7,s15).numOfEdges()==6;
    }

    private int testCluster(){
        int failCount = 0;
        if (!clusterTestGetName()) {failCount++; System.out.println("clusterTestGetName");}
        if (!clusterTestNumOfVertices0()) {failCount++;  System.out.println("clusterTestNumOfVertices0");}
        if (!clusterTestNumOfVertices1()) {failCount++;  System.out.println("clusterTestNumOfVertices1");}
        if (!clusterTestNumOfVertices2()) {failCount++;  System.out.println("clusterTestNumOfVertices2");}
        if (!clusterTestGetVertex1()) {failCount++;  System.out.println("clusterTestGetVertex1");}
        if (!clusterTestGetVertex2()) {failCount++;  System.out.println("clusterTestGetVertex2");}
        if (!clusterTestAddVertex1()) {failCount++;  System.out.println("clusterTestAddVertex1");}
        if (!clusterTestAddVertex2()) {failCount++;  System.out.println("clusterTestAddVertex2");}
        if (!clusterTestAddVertex3()) {failCount++;  System.out.println("clusterTestAddVertex3");}
        if (!clusterTestAddVertex4()) {failCount++;  System.out.println("clusterTestAddVertex4");}
        if (!clusterTestContainsVertex1()) {failCount++;  System.out.println("clusterTestContainsVertex1");}
        if (!clusterTestContainsVertex2()) {failCount++;  System.out.println("clusterTestContainsVertex2");}
        if (!clusterTestContainsVertex3()) {failCount++;  System.out.println("clusterTestContainsVertex3");}
        if (!clusterTestRemoveVertex1()) {failCount++;  System.out.println("clusterTestRemoveVertex1");}
        if (!clusterTestRemoveVertex2()) {failCount++;  System.out.println("clusterTestRemoveVertex2");}
        if (!clusterTestRemoveVertex3()) {failCount++;  System.out.println("clusterTestRemoveVertex3");}
        if (!clusterTestRemoveVertex4()) {failCount++;  System.out.println("clusterTestRemoveVertex4");}
        if (!clusterTestRemoveAllVertixes1()) {failCount++;  System.out.println("graphTestRemoveAllVertixes1");}
        if (!clusterTestRemoveAllVertixes2()) {failCount++;  System.out.println("graphTestRemoveAllVertixes2");}
        if (!clusterTestRemoveAllVertixes3()) {failCount++;  System.out.println("graphTestRemoveAllVertixes3");}
        if (!clusterTestRemoveAllVertixes4()) {failCount++;  System.out.println("graphTestRemoveAllVertixes4");}
        if (!clusterTestContainsAllVertixes1()) {failCount++;  System.out.println("clusterTestContainsAllVertixes1");}
        if (!clusterTestContainsAllVertixes2()) {failCount++;  System.out.println("clusterTestContainsAllVertixes2");}
        if (!clusterTestContainsAllVertixes3()) {failCount++;  System.out.println("clusterTestContainsAllVertixes3");}
        return failCount;
    }

    public boolean clusterTestGetName() {
        Cluster s = new Cluster("MrCluster");
        return (s.getName().equals("MrCluster"));
    }
    public boolean clusterTestNumOfVertices0(){
        Cluster s = new Cluster("MrCluster");
        return (s.numOfVertices() == 0);
    }
    public boolean clusterTestNumOfVertices1(){
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        SuperVertex v1 = new SuperVertex(1);
        vertices.add(v1);
        Cluster s = new Cluster("MrCluster", vertices);

        return (s.numOfVertices() == 1);
    }
    public boolean clusterTestNumOfVertices2(){
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("MrCluster", vertices);
        return (s.numOfVertices() == 2);
    }
    public boolean clusterTestGetVertex1() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return ((s.getVertex(1)).equals(v1));
    }
    public boolean clusterTestGetVertex2() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return ((s.getVertex(2)) == null);
    }
    public boolean clusterTestAddVertex1() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return((s.getVertex(1)).equals(v1));
    }
    public boolean clusterTestAddVertex2() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return(s.numOfVertices() == 1);
    }
    public boolean clusterTestAddVertex3() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        s.addVertex(v1.clone());
        return(s.numOfVertices() == 1);
    }
    public boolean clusterTestAddVertex4() {
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return !s.addVertex(v1.clone());
    }
    public boolean clusterTestContainsVertex1(){
        SuperVertex v1 = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.containsVertex(v1);
    }
    public boolean clusterTestContainsVertex2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v1Clone = new SuperVertex(1);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return !s.containsVertex(v1Clone);
    }
    public boolean clusterTestContainsVertex3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return !s.containsVertex(v2);
    }
    public boolean clusterTestRemoveVertex1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        int before = s.numOfVertices();
        s.removeVertex(v1);
        return (before == 3)&&(s.numOfVertices() == 2);
    }
    public boolean clusterTestRemoveVertex2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("ronen", vertices);
        return !s.removeVertex(v3);
    }
    public boolean clusterTestRemoveVertex3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v1Clone = v1.clone();
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.removeVertex(v1Clone);
    }
    public boolean clusterTestRemoveVertex4(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v1Clone = v1.clone();
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.removeVertex(v1Clone);
        return (s.numOfVertices() == 0);
    }
    public boolean clusterTestRemoveAllVertixes1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        int before = s.numOfVertices();
        s.removeAllVertices(vertices2);
        return ((before ==3)&& s.numOfVertices()==0);
    }
    public boolean clusterTestRemoveAllVertixes2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        return s.removeAllVertices(vertices2);
    }
    public boolean clusterTestRemoveAllVertixes3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        return (!s.removeAllVertices(vertices2));
    }
    public boolean clusterTestRemoveAllVertixes4(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("ronen", vertices);
        return (!s.removeAllVertices(null));
    }
    public boolean clusterTestContainsAllVertixes1(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        return (!s.containsAllVertices(vertices2));
    }
    public boolean clusterTestContainsAllVertixes2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        Cluster s = new Cluster("ronen", vertices);
        return (s.containsAllVertices(vertices2));
    }
    public boolean clusterTestContainsAllVertixes3(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        return (!s.containsAllVertices(null));
    }
    /*public
    void algorithmsTestdijkstra(){
        SuperVertex v0 = new SuperVertex(0);
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Graph g = new Graph("ronen");
        g.addVertex(v0);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v0,v1);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);

        //g.dijkstra(v0);

    }*/
    public int superVerticesTest(){
        int failCuont =0;
        if (!superVerticesTestGetSpannedCluster1()) {failCuont++; System.out.println("superVerticesTestGetSpannedCluster");}
        if (!superVerticesTestSetSpannedCluster2()) {failCuont++;  System.out.println("superVerticesTestSetSpannedCluster1");}
        if (!superVerticesTestInitSpannedCluster()) {failCuont++;  System.out.println("superVerticesTestInitSpannedCluster");}
        return failCuont;
    }
    private boolean superVerticesTestGetSpannedCluster1(){
        SuperVertex var = new SuperVertex(1);
        return (var.getSpannedCluster() == null);
    }
    private boolean superVerticesTestSetSpannedCluster2(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster c = new Cluster("ronen", vertices);
        Set<Edge> edges = new HashSet<Edge>();
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        SpannedCluster s = new SpannedCluster(v1,c,g);
        v1.setSpannedCluster(s);
        return (v1.getSpannedCluster() == s);
    }
    private boolean superVerticesTestInitSpannedCluster(){
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster c = new Cluster("ronen", vertices);
        Set<Edge> edges = new HashSet<Edge>();
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v2,v3));
        edges.add(new Edge(v1,v3));
        Graph g = new Graph("ronen", vertices, edges);
        SpannedCluster s = new SpannedCluster(v1,c,g);
        v1.setSpannedCluster(s);
        v1.initSpannedCluster();
        return (v1.getSpannedCluster() != s)&&(v1.getSpannedCluster() == null);
    }

    public int spannedClusterTest(){
        int failCount = 0;
        if (!spannedClusterTestConstructor1()) {failCount++; System.out.println("spannedClusterTestAddVertex1");}
        if (!spannedClusterTestConstructor2()) {failCount++; System.out.println("spannedClusterTestAddVertex2");}
        if (!spannedClusterTestConstructor3()) {failCount++; System.out.println("spannedClusterTestAddVertex3");}
        if (!spannedClusterTestConstructor4()) {failCount++; System.out.println("spannedClusterTestAddVertex4");}
        if (!spannedClusterTestConstructor5()) {failCount++; System.out.println("spannedClusterTestAddVertex5");}
        return failCount;
    }
    public boolean spannedClusterTestConstructor1() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        Graph g = new Graph("ronen", vertices, edges);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        Cluster c = new Cluster("ronen", vertices2);
        SpannedCluster s = new SpannedCluster(v1, c, g);
        return (s.numOfEdges() == 0)&&(s.numOfVertices() == 0);
    }
    public boolean spannedClusterTestConstructor2() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        edges.add(new Edge(v1,v2));
        Graph g = new Graph("ronen", vertices, edges);
        Cluster c = new Cluster("ronen", vertices);
        SpannedCluster s = new SpannedCluster(v3, c, g);
        return (s.numOfEdges() == 0)&&(s.numOfVertices() == 0);
    }
    public boolean spannedClusterTestConstructor3() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        Graph g = new Graph("ronen", vertices, edges);
        Set<SuperVertex> vertices2 = new HashSet<SuperVertex>();
        vertices2.add(v1);
        Cluster c = new Cluster("ronen", vertices2);
        SpannedCluster s = new SpannedCluster(v1, c, g);
        return (s.numOfEdges() == 0)&&(s.numOfVertices() == 0);
    }
    public boolean spannedClusterTestConstructor4() {
        SuperVertex v1 = new SuperVertex(1);
        SuperVertex v2 = new SuperVertex(2);
        SuperVertex v3 = new SuperVertex(3);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        edges.add(new Edge(v1,v2));
        edges.add(new Edge(v1,v3));
        edges.add(new Edge(v2,v3));
        Graph g = new Graph("ronen", vertices, edges);
        Cluster c = new Cluster("ronen", vertices);
        SpannedCluster s = new SpannedCluster(v1, c, g);
        return (s.numOfEdges() == s.numOfVertices()-1);
    }
    private boolean spannedClusterTestConstructor5(){
        Graph g = example();
        //System.out.println(g);
        Cluster c1 = new Cluster("1,2,3,4,5");
        Cluster c7 = new Cluster("6,7,8,9");
        Cluster c12 = new Cluster("10,11,12");
        Cluster c13 = new Cluster("13");
        Cluster c15 = new Cluster("14,15");
        Cluster c17 = new Cluster("16,17,18");
        for (int i=1; i<=18; i++){
            if((1<=i)&&(i<=5)){
                c1.addVertex(g.getVertex(i));
            }
            if((6<=i)&&(i<=9)){
                c7.addVertex(g.getVertex(i));
            }
            if((10<=i)&&(i<=12)){
                c12.addVertex(g.getVertex(i));
            }
            if(13 == i){
                c13.addVertex(g.getVertex(i));
            }
            if((14<=i)&&(i<=15)){
                c15.addVertex(g.getVertex(i));
            }
            if((16<=i)&&(i<=18)){
                c17.addVertex(g.getVertex(i));
            }
        }
        SpannedCluster s1 = new SpannedCluster(g.getVertex(1),c1,g.getSubGraph(c1));
        SpannedCluster s7 = new SpannedCluster(g.getVertex(7),c7,g.getSubGraph(c7));
        SpannedCluster s12 = new SpannedCluster(g.getVertex(12),c12,g.getSubGraph(c12));
        SpannedCluster s13 = new SpannedCluster(g.getVertex(13),c13,g.getSubGraph(c13));
        SpannedCluster s15 = new SpannedCluster(g.getVertex(15),c15,g.getSubGraph(c15));
        SpannedCluster s17 = new SpannedCluster(g.getVertex(17),c17,g.getSubGraph(c17));
        /*System.out.println(s1);
        System.out.println(s7);
        System.out.println(s12);
        System.out.println(s13);
        System.out.println(s15);
        System.out.println(s17);*/
        return ((s1.numOfEdges() == s1.numOfVertices()-1))&&
                (s7.numOfEdges() ==  s7.numOfVertices()-1)&&
                ((s12.numOfEdges() == s12.numOfVertices()-1))&&
                ((s13.numOfEdges() == s13.numOfVertices()-1))&&
                ((s15.numOfEdges() == s15.numOfVertices()-1))&&
                ((s17.numOfEdges() == s17.numOfVertices()-1));

    }

    public int algorithmTest(){
        int failCount = 0;
        Graph h;
        System.out.println("spCons tests:" );
        if (calcNeighborsTest()){
            System.out.println("calcNeighbors success!!");
            if(expendNeighborsTest()){
                System.out.println("expendNeighbors success!!");
                if(spConsTest1()){
                    System.out.println("SpCons success!!");
                }else{
                    System.out.println("SpCons Failed :(");
                    failCount ++;
                }
            }
            else {
                System.out.println("expendNeighbors test failed.");
                failCount++;
            }
        }else{
            System.out.println("calcNeighbors test failed.");
            failCount++;
        }
        if (!downPartTest1()) {failCount++; System.out.println("downPartTest1");}
        if (!downPartTest2()) {failCount++; System.out.println("downPartTest2");}
        if (!downPartTest3()) {failCount++; System.out.println("downPartTest3");}
        if (!spConsTest2()) {failCount++; System.out.println("spConsTest2");}
        if (!spConsTest3()) {failCount++; System.out.println("spConsTest3");}
        return failCount;
    }
    public boolean calcNeighborsTest(){
        Cluster s = new Cluster("cluster");
        SuperVertex v1 = new SuperVertex(1,"1");
        SuperVertex v2 = new SuperVertex(2,"2");
        SuperVertex v3 = new SuperVertex(3,"3");
        SuperVertex v4 = new SuperVertex(4,"4");
        s.addVertex(v1);
        s.addVertex(v2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Cluster u = new Cluster("U");
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        u.addVertex(v1);
        u.addVertex(v2);
        u.addVertex(v3);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v1,v3);
        Edge edge3 = new Edge(v1,v4);
        Edge edge4 = new Edge(v3,v2);
        Edge edge5 = new Edge(v4,v2);
        Edge edge6 = new Edge(v3,v4);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        Graph g = new Graph("graph", vertices, edges);
        return (SpCons.calcNeighbors( s, u, g) == 3);
    }
    public boolean expendNeighborsTest(){
        Cluster s = new Cluster("cluster");
        SuperVertex v1 = new SuperVertex(1,"1");
        SuperVertex v2 = new SuperVertex(2,"2");
        SuperVertex v3 = new SuperVertex(3,"3");
        SuperVertex v4 = new SuperVertex(4,"4");
        s.addVertex(v1);
        s.addVertex(v2);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Cluster u = new Cluster("U");
        Set<Edge> edges = new HashSet<Edge>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        u.addVertex(v1);
        u.addVertex(v2);
        u.addVertex(v3);
        Edge edge1 = new Edge(v1,v2);
        Edge edge2 = new Edge(v1,v3);
        Edge edge3 = new Edge(v1,v4);
        Edge edge4 = new Edge(v3,v2);
        Edge edge5 = new Edge(v4,v2);
        Edge edge6 = new Edge(v3,v4);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        Graph g = new Graph("graph", vertices, edges);

        Set<SuperVertex> neighbors = SpCons.expendNeighbors( s, u, g);

        if(neighbors.size()==3){
            if (neighbors.contains(v1)&&neighbors.contains(v2)&&neighbors.contains(v3)){
                neighbors.removeAll(u.getVertices());
                if(neighbors.size()==0){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean downPartTest1(){
        Graph g = new Graph("downPartTest",50,0.1,0.05);
        System.out.println(g.isConnected());
        Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>();
        SpCons.downPart(g, partitionG);
        boolean res = true;
        Iterator<SpannedCluster> prat = partitionG.iterator();
        while (prat.hasNext()){
            SpannedCluster current = prat.next();
            res &= current.isConnected();
        }
        return res;
    }
    private boolean downPartTest2(){
        Graph g = new Graph("downPartTest",50,0.1,0.05);
        System.out.println(g.isConnected());
        Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>();
        SpCons.downPart(g, partitionG);
        boolean res = true;
        Cluster collection= new Cluster("Collection");
        Iterator<SpannedCluster> prat = partitionG.iterator();
        while (prat.hasNext()){
            SpannedCluster current = prat.next();
            res &= collection.cutting(current).isEmpty();
            collection.addVertices(current.getVertices());
        }
        res &= collection.containsAllVertices(g.getVertices());
        return res;
    }
    private boolean downPartTest3(){
        Graph g = new Graph("downPartTest",50,0.1,0.05);
        System.out.println(g.isConnected());
        Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>();
        SpCons.downPart(g, partitionG);

        return SpCons.downPart(g, partitionG).isConnected();
    }

    public boolean spConsTest1() {
        Graph g = new Graph("graph");
        Graph h = SpCons.SpCons(g, 1, 0);
        Set<SuperVertex> vertices = new HashSet<SuperVertex>();
        Set<Edge> edges = new HashSet<Edge>();
        SuperVertex v1 = new SuperVertex(1, "1");
        SuperVertex v2 = new SuperVertex(2, "2");
        SuperVertex v3 = new SuperVertex(3, "3");
        SuperVertex v4 = new SuperVertex(4, "4");
        SuperVertex v5 = new SuperVertex(5, "5");
        SuperVertex v6 = new SuperVertex(6, "6");
        SuperVertex v7 = new SuperVertex(7, "7");
        SuperVertex v8 = new SuperVertex(8, "8");
        SuperVertex v9 = new SuperVertex(9, "9");
        SuperVertex v10 = new SuperVertex(10, "10");
        SuperVertex v11 = new SuperVertex(11, "11");
        SuperVertex v12 = new SuperVertex(12, "12");
        vertices.add(v7);
        vertices.add(v8);
        vertices.add(v9);
        vertices.add(v10);
        vertices.add(v11);
        vertices.add(v12);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        Edge edge5 = new Edge(v4, v2);
        Edge edge6 = new Edge(v3, v4);
        Edge edge7 = new Edge(v5, v2);
        Edge edge8 = new Edge(v5, v6);
        Edge edge9 = new Edge(v5, v9);
        Edge edge10 = new Edge(v9, v10);
        Edge edge11 = new Edge(v9, v11);
        Edge edge12 = new Edge(v9, v12);
        Edge edge13 = new Edge(v6, v7);
        Edge edge14 = new Edge(v7, v8);
        Edge edge1 = new Edge(v1, v2);
        Edge edge2 = new Edge(v1, v3);
        Edge edge3 = new Edge(v1, v4);
        Edge edge4 = new Edge(v3, v2);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);
        edges.add(edge10);
        edges.add(edge11);
        edges.add(edge12);
        edges.add(edge13);
        edges.add(edge14);
        Graph g1 = new Graph("graph", vertices, edges);
        Graph h1 = SpCons.SpCons(g1, 4, 0);
        return ((h1.isConnected())&&(g1.numOfEdges()>h1.numOfEdges()));
    }
    public boolean spConsTest2() {
        Graph g = example2();
        System.out.println(g.isConnected());
        Graph h = SpCons.SpCons(g, 4, 0.5);
        System.out.println(h.numOfEdges());
        return ((h.isConnected())&&(g.numOfEdges()>h.numOfEdges()));
    }
    public boolean spConsTest3() {
        Graph g = new Graph("spConsTest3", 200, 0.8, 0.02);
        //System.out.println(g.isConnected());
        System.out.println("num of edges in g: "+g.numOfEdges());
        Graph h = SpCons.SpCons(g, 4, 0.5);
        System.out.println("num of edges in h: "+h.numOfEdges());
        return ((h.isConnected())&&(g.numOfEdges()>h.numOfEdges()));
    }
}

