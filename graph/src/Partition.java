import java.util.HashSet;

public class Partition {
    protected Set<SpannedCluster> SpannedClusters;

    public Partition(){

        this.SpannedClusters = new HashSet<SpannedCluster>();
    }

    public void addSpannedCluster(SpannedCluster SpannedClusterToAdd){

        this.SpannedClusters.add(SpannedClusterToAdd);
    }
}
