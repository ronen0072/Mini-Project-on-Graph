
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SpCons {
     private static int k = 1;
     public static Graph SpCons(Graph g){ //main function returns the spanner

         int sigma = 1;
         int delta = 1;
         Graph h, hTag;
         Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>() ;
         Set<SpannedCluster> partitionCTag = new HashSet<SpannedCluster>() ;
         h = downPart(g,partitionG);
         for (int j =0; j<= Math.log(k); j++){

         }
         hTag = ProcedureSC(g,partitionG,sigma,delta,partitionCTag);

         return h;
    }
    public static Graph downPart( Graph g, Set<SpannedCluster> partitionG){//creates the partition
        System.out.println("Down_Part");
        Set<SuperVertex> vertexSetU = g.getVertices();
        Set<CenteredCluster> centeredClusterSTag = new HashSet<CenteredCluster>();
        Graph h = new Graph("DP_H");
        int n = vertexSetU.size();
        int i=1;
        while(!vertexSetU.isEmpty()){
            Cluster s = new Cluster("S"+i);
            CenteredCluster shell;
            SuperVertex v = vertexSetU.iterator().next();
            s.addVertex(v);
            double factor = Math.pow(n,(1/k))*(s.numOfVertices());
            while (calcNeighbors(s, vertexSetU,g) >= factor){
                s.addVertices(expendNeighbors(s, vertexSetU,g));
                if(vertexSetU.size()==s.numOfVertices())
                    break;
            }
            SpannedCluster cluster = new SpannedCluster(v, s, g.getSubGraph(s));
            partitionG.add(cluster);
            shell = new CenteredCluster("Shell"+i,expendNeighbors(s, vertexSetU,g),v);
            centeredClusterSTag.add(shell);
            vertexSetU.removeAll(s.getVertices());
            i++;
        }
        Iterator sTag = centeredClusterSTag.iterator();
        while(sTag.hasNext()){
            CenteredCluster iterableShell = (CenteredCluster)sTag.next();
            Graph addToH = g.getSubGraph(iterableShell);
            addToH.getSPTForUnWeightGraph(iterableShell.getCenter());
            h.addVertices(addToH.getVertices());
            h.addAllEdges(addToH.getEdges());
        }
        return h;
    }

    public static Graph ProcedureSC(Graph g,Set<SpannedCluster> partitionG, int sigma, int delta, Set<SpannedCluster> partitionCTag){
         System.out.println("Procedure_SC");
         Graph hTag = new Graph("hTag");
         Set<SpannedCluster> u = new HashSet<SpannedCluster>();
         Iterator partitionIter = partitionG.iterator();
         while (partitionIter.hasNext()){
             SpannedCluster toAdd = (SpannedCluster) partitionIter.next();
             u.add(toAdd);
         }
         Boolean condition =true;
         while (condition){
             Iterator spundClus = u.iterator();
             while (spundClus.hasNext()){
                 SpannedCluster center = (SpannedCluster) spundClus.next();
                 Set<SpannedCluster> neighbors = g.getLSpannedClusterNeighbors(center,1);
                 if(neighbors.size() >= sigma) {//Check if the neighbors group is big enough
                     Cluster allVertices = new Cluster("allVertices");
                     allVertices.addVertices(center.getVertices());
                     boolean allContained = true;

                     Iterator neighborsIter = neighbors.iterator();
                     while (neighborsIter.hasNext()) {//check if neighbors are contained in U
                         SpannedCluster contained = (SpannedCluster) neighborsIter.next();
                         if(u.contains(contained)){
                             allVertices.addVertices(contained.getVertices());
                         }else{
                             neighbors.remove(contained);
                             allContained = false;
                         }
                     }
                     if(allContained||(neighbors.size() >= sigma)){
                         SpannedCluster addToCTag = new SpannedCluster(center, neighbors,g);
                         partitionCTag.add(addToCTag);
                         u.removeAll(neighbors);
                         hTag.addVertices(allVertices.getVertices());
                         hTag.addAllEdges(addToCTag.getEdges());
                         break;
                     }
                 }
             }
             condition = false;
         }
         return hTag;
    }
    public static Set<SuperVertex> expendNeighbors(Cluster s, Set<SuperVertex> vertexSetU, Graph g){//ToDo: change to private
        Set<SuperVertex> neighbors = new HashSet<SuperVertex>();
        neighbors = g.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU);
        return neighbors;
    }
    public static int calcNeighbors(Cluster s, Set<SuperVertex> vertexSetU, Graph g){//ToDo: change to private
        /*Set<SuperVertex> neighbors = new HashSet<SuperVertex>();
        neighbors = g.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU);*/
        return expendNeighbors(s, vertexSetU, g).size();
    }
}
