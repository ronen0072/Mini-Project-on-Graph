import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;

public interface GraphInterface {
    double DEFAULT_EDGE_WEIGHT = 1.0D;

    Edge getEdge(SuperVertex var1, SuperVertex var2);

    SuperVertex getVertex(int vertexId);

    Edge addEdge(SuperVertex var1, SuperVertex var2);

    Edge getEdge(Edge edge);

    boolean addVertex(SuperVertex var1);

    boolean containsEdge(SuperVertex var1, SuperVertex var2);

    boolean containsEdge(Edge var1);

    boolean containsVertex(SuperVertex var1);


    Set<Edge> incomingEdgesOf(SuperVertex var1);

    boolean removeAllEdges(Collection<? extends Edge> var1);

    boolean removeAllVertices(Collection<? extends SuperVertex> vars);

    Edge removeEdge(SuperVertex var1, SuperVertex var2);

    boolean removeEdge(Edge var1);

    boolean removeVertex(SuperVertex var);

    SuperVertex getEdgeSource(Edge var1);

    SuperVertex getEdgeTarget(Edge var1);

    double getEdgeWeight(Edge var1);

    void setEdgeWeight(Edge var1, double var2);

    void setEdgeWeight(SuperVertex sourceVertex, SuperVertex targetVertex, double weight);

    String toString();

    int numOfVertices();

    int numOfEdges();

    double sumOfEdges(Collection<? extends Edge> vars);
}
