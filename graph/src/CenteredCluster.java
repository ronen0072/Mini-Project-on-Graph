import java.util.Set;

public class CenteredCluster extends Cluster {
    private SuperVertex center;

    public CenteredCluster (String name,  Set<SuperVertex> vertices, SuperVertex center){
        super(name, vertices);
        this. center = center;
    }
    public SuperVertex getCenter(){
        return this.center.clone();
    }
}
