
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SpCons {

     public static Graph SpCons(Graph G){ //main function returns the spanner
         int k = 1;
         Graph H;
         Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>() ;
         H = downPart(G,k,partitionG);
         ProcedureSC();
         return H;
    }
    private static Graph downPart( Graph G, int k, Set<SpannedCluster> partitionG){//creates the partition
        System.out.println("Down_Part");
        Set<SuperVertex> vertexSetU = G.getVertices();
        Set<CenteredCluster> centeredClusterSTag = new HashSet<CenteredCluster>();
        Graph H = new Graph("DP_H");
        int n = vertexSetU.size();
        int i=1;
        while(!vertexSetU.isEmpty()){
            Cluster s = new Cluster("S"+i);
            CenteredCluster shell;
            SuperVertex v = vertexSetU.iterator().next();
            s.addVertex(v);
            double factor = Math.pow(n,(1/k))*(s.numOfVertices());
            while (calcNeighbors(s, vertexSetU,G) >= factor){
                s.addVertices(expendNeighbors(s, vertexSetU,G));
                if(vertexSetU.size()==s.numOfVertices())
                    break;
            }
            SpannedCluster cluster = new SpannedCluster(v, s, G.getSubGraph(s));
            partitionG.add(cluster);
            shell = new CenteredCluster("Shell"+i,expendNeighbors(s, vertexSetU,G),v);
            centeredClusterSTag.add(shell);
            vertexSetU.removeAll(s.getVertices());
            i++;
        }
        Iterator sTag = centeredClusterSTag.iterator();
        while(sTag.hasNext()){
            CenteredCluster iterableShell = (CenteredCluster)sTag.next();
            Graph addToH = G.getSubGraph(iterableShell);
            addToH.getSPTForUnWeightGraph(iterableShell.getCenter());
            H.addVertices(addToH.getVertices());
            H.addAllEdges(addToH.getEdges());
        }
        return H;
    }

    private static void ProcedureSC(){

         System.out.println("Procedure_SC");
    }
    public static Set<SuperVertex> expendNeighbors(Cluster s, Set<SuperVertex> vertexSetU, Graph G){//ToDo: change to private
        Set<SuperVertex> neighbors = new HashSet<SuperVertex>();
        neighbors = G.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU);
        return neighbors;
    }
    public static int calcNeighbors(Cluster s, Set<SuperVertex> vertexSetU, Graph G){//ToDo: change to private
        Set<SuperVertex> neighbors = new HashSet<SuperVertex>();
        neighbors = G.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU);
        return neighbors.size();
    }
}
