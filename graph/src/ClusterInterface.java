import java.util.Collection;
import java.util.Set;

public interface ClusterInterface {

    SuperVertex getVertex(int vertexId);

    Set<SuperVertex> getVerticesClone();

    boolean addVertex(SuperVertex var1);

    boolean addVertices(Set<SuperVertex> add);

    boolean containsVertex(SuperVertex var1);

    boolean containsAllVertices(Collection<? extends SuperVertex> vars);

    boolean removeAllVertices(Collection<? extends SuperVertex> vars);

    boolean removeVertex(SuperVertex vert);

    String toString();

    int numOfVertices();

}
