import java.util.HashSet;
import java.util.Set;

public class testsForCluster {

    public void main(String[] args) {
        System.out.println("tests:");
        System.out.println("cluster test:" + this.testCluster());
    }
    public int testCluster(){
        int failCount = 0;
        if (!testClusterName()) {failCount++; System.out.println("testClusterName");}
        if (!testNumOfVertices0()) {failCount++;  System.out.println("testNumOfVertices0");}
        if (!testNumOfVertices1()) {failCount++;  System.out.println("testNumOfVertices1");}
        if (!testNumOfVertices2()) {failCount++;  System.out.println("testNumOfVertices2");}
        if (!testGetVertex1()) {failCount++;  System.out.println("testGetVertex1");}
        if (!testGetVertex2()) {failCount++;  System.out.println("testGetVertex2");}
        if (!testAddVertex1()) {failCount++;  System.out.println("testAddVertex1");}
        if (!testAddVertex2()) {failCount++;  System.out.println("testAddVertex2");}
        if (!testAddVertex3()) {failCount++;  System.out.println("testAddVertex3");}
        if (!testAddVertex4()) {failCount++;  System.out.println("testAddVertex4");}
        if (!testContainsVertex1()) {failCount++;  System.out.println("testContainsVertex1");}
        if (!testContainsVertex2()) {failCount++;  System.out.println("testContainsVertex2");}
        if (!testContainsVertex3()) {failCount++;  System.out.println("testContainsVertex3");}
        if (!testRemoveVertex1()) {failCount++;  System.out.println("testRemoveVertex1");}
        if (!testRemoveVertex2()) {failCount++;  System.out.println("testRemoveVertex2");}
        if (!testRemoveVertex3()) {failCount++;  System.out.println("testRemoveVertex3");}
        if (!testRemoveVertex4()) {failCount++;  System.out.println("testRemoveVertex4");}
        if (!graphTestRemoveAllVertixes1()) {failCount++;  System.out.println("graphTestRemoveAllVertixes1");}
        if (!graphTestRemoveAllVertixes2()) {failCount++;  System.out.println("graphTestRemoveAllVertixes2");}
        if (!graphTestRemoveAllVertixes3()) {failCount++;  System.out.println("graphTestRemoveAllVertixes3");}
        return failCount;
    }
    public boolean testClusterName() {
        Cluster s = new Cluster("MrCluster");
        return (s.getName().equals("MrCluster"));
    }
    public boolean testNumOfVertices0(){
        Cluster s = new Cluster("MrCluster");
        return (s.numOfVertices() == 0);
    }
    public boolean testNumOfVertices1(){
        Set<Vertex> vertices = new HashSet<Vertex>();
        Vertex v1 = new Vertex(1);
        vertices.add(v1);
        Cluster s = new Cluster("MrCluster", vertices);

        return (s.numOfVertices() == 1);
    }
    public boolean testNumOfVertices2(){
        Set<Vertex> vertices = new HashSet<Vertex>();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("MrCluster", vertices);
        return (s.numOfVertices() == 2);
    }
    public boolean testGetVertex1() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return ((s.getVertex(1)).equals(v1));
    }
    public boolean testGetVertex2() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return ((s.getVertex(2)) == null);
    }
    public boolean testAddVertex1() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return((s.getVertex(1)).equals(v1));
    }
    public boolean testAddVertex2() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return(s.numOfVertices() == 1);
    }
    public boolean testAddVertex3() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        s.addVertex(v1.clone());
        return(s.numOfVertices() == 1);
    }
    public boolean testAddVertex4() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return s.addVertex(v1.clone());
    }
    public boolean testContainsVertex1(){
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.containsVertex(v1);
    }
    public boolean testContainsVertex2(){
        Vertex v1 = new Vertex(1);
        Vertex v1Clone = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.containsVertex(v1Clone);
    }
    public boolean testContainsVertex3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return !s.containsVertex(v2);
    }
    public boolean testRemoveVertex1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        int before = s.numOfVertices();
        s.removeVertex(v1);
        return (before == 3)&&(s.numOfVertices() == 2);
    }
    public boolean testRemoveVertex2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("ronen", vertices);
        return !s.removeVertex(v3);
    }
    public boolean testRemoveVertex3(){
        Vertex v1 = new Vertex(1);
        Vertex v1Clone = v1.clone();
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.removeVertex(v1Clone);
    }
    public boolean testRemoveVertex4(){
        Vertex v1 = new Vertex(1);
        Vertex v1Clone = v1.clone();
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.removeVertex(v1Clone);
        return (s.numOfVertices() == 0);
    }
    public boolean graphTestRemoveAllVertixes1(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        int before = s.numOfVertices();
        s.removeAllVertixes(vertices2);
        return ((before ==3)&& s.numOfVertices()==0);
    }
    public boolean graphTestRemoveAllVertixes2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        return s.removeAllVertixes(vertices);
    }
    public boolean graphTestRemoveAllVertixes3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        Set<Vertex> vertices2 = new HashSet<Vertex>();
        vertices2.add(v1);
        vertices2.add(v2);
        vertices2.add(v3);
        Cluster s = new Cluster("ronen", vertices);
        return (!s.removeAllVertixes(vertices2));
    }

}
