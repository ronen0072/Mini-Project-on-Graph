import java.util.HashSet;
import java.util.Set;

public class testsForCluster {

    public void main(String[] args) {
        System.out.println("tests:");
        System.out.println("cluster test:" + this.testCluster());
    }
    public int testCluster(){
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
        Set<Vertex> vertices = new HashSet<Vertex>();
        Vertex v1 = new Vertex(1);
        vertices.add(v1);
        Cluster s = new Cluster("MrCluster", vertices);

        return (s.numOfVertices() == 1);
    }
    public boolean clusterTestNumOfVertices2(){
        Set<Vertex> vertices = new HashSet<Vertex>();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("MrCluster", vertices);
        return (s.numOfVertices() == 2);
    }
    public boolean clusterTestGetVertex1() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return ((s.getVertex(1)).equals(v1));
    }
    public boolean clusterTestGetVertex2() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        Set<Edge> edges  = new HashSet<Edge>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return ((s.getVertex(2)) == null);
    }
    public boolean clusterTestAddVertex1() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return((s.getVertex(1)).equals(v1));
    }
    public boolean clusterTestAddVertex2() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return(s.numOfVertices() == 1);
    }
    public boolean clusterTestAddVertex3() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        s.addVertex(v1.clone());
        return(s.numOfVertices() == 1);
    }
    public boolean clusterTestAddVertex4() {
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.addVertex(v1);
        return s.addVertex(v1.clone());
    }
    public boolean clusterTestContainsVertex1(){
        Vertex v1 = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.containsVertex(v1);
    }
    public boolean clusterTestContainsVertex2(){
        Vertex v1 = new Vertex(1);
        Vertex v1Clone = new Vertex(1);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.containsVertex(v1Clone);
    }
    public boolean clusterTestContainsVertex3(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return !s.containsVertex(v2);
    }
    public boolean clusterTestRemoveVertex1(){
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
    public boolean clusterTestRemoveVertex2(){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        vertices.add(v2);
        Cluster s = new Cluster("ronen", vertices);
        return !s.removeVertex(v3);
    }
    public boolean clusterTestRemoveVertex3(){
        Vertex v1 = new Vertex(1);
        Vertex v1Clone = v1.clone();
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        return s.removeVertex(v1Clone);
    }
    public boolean clusterTestRemoveVertex4(){
        Vertex v1 = new Vertex(1);
        Vertex v1Clone = v1.clone();
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(v1);
        Cluster s = new Cluster("ronen", vertices);
        s.removeVertex(v1Clone);
        return (s.numOfVertices() == 0);
    }
    public boolean clusterTestRemoveAllVertixes1(){
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
        s.removeAllVertices(vertices2);
        return ((before ==3)&& s.numOfVertices()==0);
    }
    public boolean clusterTestRemoveAllVertixes2(){
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
        return s.removeAllVertices(vertices);
    }
    public boolean clusterTestRemoveAllVertixes3(){
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
        return (!s.removeAllVertices(vertices2));
    }
}
