package src;

import sun.security.provider.certpath.Vertex;

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
    public Vertex getVertex(int vertexId){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if (v.getId()== vertexId)
                return v.clone();
        }
        return null;
    }
    public boolean addVertex(Vertex toAdd) {//adding vertex while checking for dupes
        if(vertices.contains(toAdd))
            return false;
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if (v.getId() == toAdd.getId())
                return false;
        }
        vertices.add(toAdd);
        return true;
    }
    public boolean addVertices(Set<Vertex> add){
        Iterator iter = add.iterator();
        while (iter.hasNext()) {
            Vertex v = (Vertex) iter.next().clone();
            this.vertices.addVertex(v);
        }
    }
    public String getName(){
        return this.name;
    }

    boolean containsVertex(Vertex vert){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if (vart.getId() == v.getId())
                return true;
        }
        return false;
    }

    boolean removeAllVertixes(Collection<? extends Vertex> vert){
            vertices.clear();
    }

    boolean removeVertex(Vertex vert){
        Iterator verticesIter = vertices.iterator();
        while (verticesIter.hasNext()) {
            Vertex v = (Vertex) verticesIter.next();
            if(v.getId() == vert.getId()){
                vertices.remove(v);
                return true;
            }
        }
        return false;
    }

    public Set<Vertex> getVertices(){
        Set<Vertex> ret = new HashSet<Vertex>();
        Iterator iter = this.vertices.iterator();
        while (iter.hasNext()) {
            Vertex v = (Vertex) iter.next().clone();
            ret.add(v);
        }
        return ret;
    }

    public String toString(){
        return "{" + this.getName() + ":" + this.getVertices() + "}";
    }

    public int numOfVertices(){
        return this.vertices.size();
    }

}
