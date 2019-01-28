import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;

public interface GraphInterface {
    double DEFAULT_EDGE_WEIGHT = 1.0D;

    Edge getEdge(Vertex var1, Vertex var2);

    Vertex getVertex(int vertexId);

    Edge addEdge(Vertex var1, Vertex var2);

    Edge addEdge(Edge e);

    boolean addVertex(Vertex var1);

    boolean containsEdge(Vertex var1, Vertex var2);

    boolean containsEdge(Edge var1);

    boolean containsVertex(Vertex var1);


    Set<Edge> incomingEdgesOf(Vertex var1);

    boolean removeAllEdges(Collection<? extends Edge> var1);

    boolean removeAllVertixes(Collection<? extends Vertex> var1);

    Edge removeEdge(Vertex var1, Vertex var2);

    boolean removeEdge(Edge var1);

    boolean removeVertex(Vertex var1);

    Vertex getEdgeSource(Edge var1);

    Vertex getEdgeTarget(Edge var1);

    double getEdgeWeight(Edge var1);

    void setEdgeWeight(Edge var1, double var2);

    default void setEdgeWeight(Vertex sourceVertex, Vertex targetVertex, double weight) {
        this.setEdgeWeight(this.getEdge(sourceVertex, targetVertex), weight);
    }

    String toString();

    int numOfVertices();

    int numOfEdges();
}
