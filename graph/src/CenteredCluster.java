import java.util.Set;

public class CenteredCluster extends Cluster {
    Vertex center;

    public CenteredCluster (String name,  Set<Vertex> vertices, Vertex center){
        super(name, vertices);
        this. center = center;
    }
}
