
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpCons {

     public static Graph SpCons(Graph G){ //main function returns the spanner
         int k = 6;
         Graph H;
         Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>() ;
         H = downPart(G,k,partitionG);
         ProcedureSC();
         return H;
    }
    private static Graph downPart( Graph G, int k, Set<SpannedCluster> partitionG){//creates the partition
        System.out.println("Down_Part");
        Set<Vertex> vertexSetU = G.getVertices();
        Set<CenteredCluster> centeredClusterSTag = new HashSet<CenteredCluster>();
        Graph H = new Graph("DP_H");
        int n = vertexSetU.size();
        int i=1;
        while(!vertexSetU.isEmpty()){
            Cluster s = new Cluster("S"+i);
            CenteredCluster shell;
            Vertex v = vertexSetU.iterator().next();
            s.addVertex(v);
            while (calcNeighbors(s, vertexSetU,G) >= ((n^(1/k))*(s.numOfVertices()))){
                s.addVerticesDeep(expendNeighbors(s, vertexSetU,G));
            }
            SpannedCluster cluster = new SpannedCluster(v, s, G.getSubGraph(s));
            partitionG.add(cluster);
            shell = new CenteredCluster("Shell"+i,expendNeighbors(s, vertexSetU,G),v);
            centeredClusterSTag.add(shell);
            vertexSetU.removeAll(s.getVerticesDeep());
            i++;
        }
        Iterator sTag = centeredClusterSTag.iterator();
        while(sTag.hasNext()){
            CenteredCluster iterableShell = (CenteredCluster)sTag.next();
            Graph addToH = G.getSubGraph(iterableShell);
            addToH.getSPTForUnWeightGraph(iterableShell.getCenter());
            H.addAllEdges(addToH.getEdges());
            H.addVertices(addToH.getVertices());
        }
        return H;
    }

    private static void ProcedureSC(){
        System.out.println("Procedure_SC");
    }
    public static Set<Vertex> expendNeighbors(Cluster s, Set<Vertex> vertexSetU, Graph G){//ToDo: change to private
        Set<Vertex> neighbors = new HashSet<Vertex>();
        neighbors = G.getNeighbors(s.getVerticesDeep());
        neighbors.addAll(s.getVerticesDeep());
        neighbors.retainAll(vertexSetU);
        return neighbors;
    }
    public static int calcNeighbors(Cluster s, Set<Vertex> vertexSetU, Graph G){//ToDo: change to private
        Set<Vertex> neighbors = new HashSet<Vertex>();
        neighbors = G.getNeighbors(s.getVerticesDeep());
        neighbors.addAll(s.getVerticesDeep());
        neighbors.retainAll(vertexSetU);
        return neighbors.size();
    }
}
