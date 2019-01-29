import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class  Cluster implements ClusterInterface{
    protected Set<Vertex> vertices ;
    protected String name;

    public Cluster(String name){
        this.vertices = new HashSet<Vertex>();
        this.name = name;
    }
    public Cluster(String name, Set<Vertex> vertices){
        this.vertices = vertices;
        this.name = name;
    }
    public Vertex getVertex(int vertexId){
        Iterator verticesIrer = vertices.iterator();
        while (verticesIrer.hasNext()) {
            Vertex v = (Vertex) verticesIrer.next();
            if (v.getId()== vertexId)
                return v.clone();
        }
        return null;
    }
    public boolean addVertex(Vertex toAdd) {//adding vertex while checking for dupes
        if(vertices.contains(toAdd))
            return false;
        Iterator verticesIrer = vertices.iterator();
        while (verticesIrer.hasNext()) {
            Vertex v = (Vertex) verticesIrer.next();
            if (v.getId() == toAdd.getId())
                return false;
        }
        vertices.add(toAdd);
        return true;
    }
    public void addVertices(Set<Vertex> add){
        Iterator iter = add.iterator();
        while (iter.hasNext()) {
            Vertex v = ((Vertex) iter.next()).clone();
            this.vertices.addVertex(v);
        }
    }
    public String getName(){
        return this.name;
    }
    boolean containsVertex(Vertex var1);

    boolean removeAllVertixes(Collection<? extends Vertex> var1);

    boolean removeVertex(Vertex var1);

    public Set<Vertex> getVertices(){
        Set<Vertex> ret = new HashSet<Vertex>();
        Iterator iter = this.vertices.iterator();
        while (iter.hasNext()) {
            Vertex v = (Vertex) iter.next().clone();
            ret.add(v);
        }
        return ret;
    }

    String toString();

    public int numOfVertices(){
        return this.vertices.size();
    }

}
