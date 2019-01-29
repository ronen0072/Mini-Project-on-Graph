package src;

import java.util.HashSet;
import java.util.Set;

public class Partition {
    protected Set<SpannedCluster> SpannedClusters;

    public Partition(){
        this.SpannedClusters = new HashSet<SpannedCluster>();
    }
    public void addSpannedCluster(SpannedCluster SpannedClusterToAdd){

        this.SpannedClusters.add(SpannedClusterToAdd);
    }
}
