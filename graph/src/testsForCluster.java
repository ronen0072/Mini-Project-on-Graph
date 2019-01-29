package src;

public class testsForCluster {

    public static void main(String[] args) {
        System.out.println("tests:");
        testsForCluster t = new testsForCluster();
        System.out.println("graphTest:" + t.testCluster());
    }
    public int testCluster(){
        int failCount = 0;
        if (!testClusterName()) {failCount++; System.out.println("testClusterName");}
        if (!testGetNumOfVertices0()) {failCount++;  System.out.println("testGetNumOfVertices0");}
        if (!testNumOfVertices1()) {failCount++;  System.out.println("testNumOfVertices1");}
        if (!testNumOfVertices2()) {failCount++;  System.out.println("testNumOfVertices2");}
        if (!testGetVertex()) {failCount++;  System.out.println("testGetVertex");}
        return failCount;
    }
    public boolean testClusterName() {
        Cluster s = new Cluster("MrCluster");
        return (s.getClusterName().equals("MrCluster"));
    }
    public boolean testGetNumOfVertices0(){
        Cluster s = new Cluster("MrCluster");
        return (s.numOfVertices() == 0);
    }
    public boolean testNumOfVertices1(){
        Cluster s = new Cluster("MrCluster");
        Vertex v1 = new Vertex(1);
        s.addVertex(v1);
        return (s.numOfVertices() == 1);
    }
    public boolean testNumOfVertices2(){
        Cluster s = new Cluster("MrCluster");
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        s.addVertex(v1);
        s.addVertex(v2);
        return (s.numOfVertices() == 2);
    }
    public boolean testGetVertex() {
        Cluster s = new Cluster("MrCluster");
        Vertex v1 = new Vertex(1);
        s.addVertex(v1);
        return ((s.getVertex(1)).equals(v1));
    }
}
