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

    public Cluster(String name,  Set<Vertex> vertices) {
        this.vertices = new HashSet<Vertex>();
        this.addVertices(vertices);
        this.name = name;

    }

    public Vertex getVertex(int vertexId){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if (v.getId() == vertexId)
                return v;
        }
        return null;
    }

    protected Vertex getVertex(Vertex ver){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if (v.equals(ver))
                return v;
        }
        return null;
    }

    protected Set<Vertex> getVertices(){
        Set<Vertex> ret = new HashSet<Vertex>();
        Iterator iter = this.vertices.iterator();
        while (iter.hasNext()) {
            Vertex v = ((Vertex) iter.next());
            ret.add(v);
        }
        return ret;
    }

    public Set<Vertex> getVerticesClone(){
        Set<Vertex> ret = new HashSet<Vertex>();
        Iterator iter = this.vertices.iterator();
        while (iter.hasNext()) {
            Vertex v = ((Vertex) iter.next()).clone();
            ret.add(v);
        }
        return ret;
    }

    public boolean addVertex(Vertex toAdd) {//adding vertex while checking for dupes
        if(vertices.contains(toAdd)) return false;
        if(this.containsVertex(toAdd)) return false;
        vertices.add(toAdd);
        return true;
    }

    public boolean addVertices(Set<Vertex> toAdd){
        boolean res = true;
        Iterator iter = toAdd.iterator();
        while (iter.hasNext()) {
            Vertex v = ((Vertex) iter.next());
            res &= this.addVertex(v);
        }
        return res;
    }

    public String getName(){
        return this.name;
    }

    public boolean containsVertex(Vertex vert){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if (vert.equals(v))
                return true;
        }
        return false;
    }

    public boolean containsAllVertices(Collection<? extends Vertex> vert){

        try{
            if(vert == null) {
                throw new InputException("There are no vertices in the collection.");
            }
            boolean res = true;
            Iterator verticesIter = vert.iterator();
            while (verticesIter.hasNext()) {
                Vertex toRemove = (Vertex) verticesIter.next();
                res &= this.containsVertex(toRemove);
            }
            return res;
        }
        catch (InputException e) {
            System.out.println("There are no vertices in the collection.");
            //e.printStackTrace();
            return false;
        }

    }

    public boolean removeAllVertices(Collection<? extends Vertex> vert){
        try {
            if (vert == null) {
                throw new InputException("There are no vertices in the collection.");
            }
            boolean res = true;
            Iterator verticesIter = vert.iterator();
            while (verticesIter.hasNext()) {
                Vertex toRemove = (Vertex) verticesIter.next();
                res &= this.removeVertex(toRemove);
            }
            return res;
        }
        catch (InputException e) {
            System.out.println("There are no vertices in the collection.");
            //e.printStackTrace();
            return false;
        }
    }

    public boolean removeAllVerticesExceptFrom(Collection<? extends Vertex> vert){
        try {
            if (vert == null) {
                throw new InputException("There are no vertices in the collection.");
            }
            Set<Vertex> toRemove = new HashSet<Vertex>();
            Iterator verticesIter = getVertices().iterator();
            while (verticesIter.hasNext()) {
                Vertex vertex = (Vertex) verticesIter.next();
                toRemove.add(vertex);
                Iterator iter = vert.iterator();
                while (iter.hasNext()) {
                    Vertex v = (Vertex) iter.next();
                    if (vertex.equals(v))
                        toRemove.remove(this.getVertex(vertex));
                }
            }
            return removeAllVertices(toRemove);
        }
        catch (InputException e) {
            System.out.println("There are no vertices in the collection.");
            //e.printStackTrace();
            return false;
        }
    }

    public boolean removeVertex(Vertex vert){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if(v.equals(vert)) {
                vertices.remove(v);
                return true;
            }
        }
        System.out.println("the vertex:"+vert+" does not exist in this Object:"+this);
        return false;
    }

    public String toString(){
        return "{" + this.getName() + ":" + this.getVertices() + "}";
    }

    public int numOfVertices(){
        return this.vertices.size();
    }

}
