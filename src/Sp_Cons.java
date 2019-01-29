import org.jetbrains.annotations.NotNull;
import src.Cluster;
import src.Partition;

import java.util.HashSet;
import java.util.Set;

public class Sp_Cons {

     public static Graph Sp_Cons(Graph G){ //main function returns the spanner
         Graph H = new Graph("SC_H");
         return H;
    }
    private static void down_part(@NotNull Graph G, int k){//creates the partition
        Partition partititionG = new Partition();
        Set<Vertex> vertexSetU = G.getVertices();
        Partition partitionSTag = new Partition();
        Graph H = new Graph("DP_H");
        int n = vertexSetU.size();
        while(!vertexSetU.isEmpty()){
            int i=1;
            Cluster S = new Cluster("S"+i);
            Cluster shell = new Cluster("Shell"+i);
            Vertex v = vertexSetU.iterator().next();
            S.addVertex(v);
            while (calcNeighbors(s, vertexSetU,G) >= ((n^(1/k))*(s.numOfVertices()))){
                s.addVertices(expendNeighbors(s, vertexSetU,G));
            }
            shell.addVertices(s.getVertices());
            shell.addVertices(expendNeighbors(shell, vertexSetU,G));
            SpannedCluster shellSC = new SpannedCluster (V,shell);
            partitionSTag.addSpannedCluster(shellSC);
            Set<Edge> spTree = new hashSet<Edge>;
            spTree = g.getSpanningTree(V,s.getVertices());
            SpannedCluster clusterSC = new SpannedCluster (V,s,spTree);
        }
    }

    private static void Procedure_SC(){

    }
    private static Set<Vertex> expendNeighbors(Cluster s, Set<Vertex> vertexSetU, Graph G){
        Set<Vertex> neighbors = new HashSet<Vertex>();
        neighbors = G.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU);
        return neighbors;
    }
    private static int calcNeighbors(Cluster s, Set<Vertex> vertexSetU, Graph G){
        Set<Vertex> neighbors = new HashSet<Vertex>();
        neighbors = G.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU);
        return neighbors.size();
    }
}
