import java.util.Collection;
import java.util.Set;

public interface ClusterInterface {

    Vertex getVertex(int vertexId);

    Set<Vertex> getVerticesClone();

    boolean addVertex(Vertex var1);

    boolean addVertices(Set<Vertex> add);

    boolean containsVertex(Vertex var1);

    boolean containsAllVertices(Collection<? extends Vertex> vert);

    boolean removeAllVertices(Collection<? extends Vertex> var1);

    boolean removeVertex(Vertex var1);

    String toString();

    int numOfVertices();

}
