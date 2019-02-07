
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SpCons {
    private static double epsilon;
    private static double K = 1;
    private static int J = (int) Math.ceil(Math.log(K));
    private static int N;
    private static double tj(int j){
        return ((K - Math.pow(2,(j-1)))/(Math.pow(2,(j-1))*K ));
    }
    private static double delta(int j){
        return Math.pow((Math.log(K)/epsilon),j);
    }
    private static final int sigma(int j){
       return (int) Math.ceil(Math.pow(N,tj(J -j)-tj(J-j+1)));
    }


     public static Graph SpCons(Graph G, int k, double _epsilon){ //main function returns the spanner
         K = k;
         N = G.numOfVertices();
         epsilon = _epsilon;
         Graph H, HTag;
         Set<SpannedCluster> partitionR = new HashSet<SpannedCluster>();
         Set<SpannedCluster> partitionG = new HashSet<SpannedCluster>() ;
         Set<SpannedCluster> partitionCTag = new HashSet<SpannedCluster>() ;
         H = downPart(G,partitionG);
         for (int j =1; j<= J-1; j++){
             Set<SpannedCluster> partitionC = new HashSet<SpannedCluster>(partitionCTag);
             partitionC.addAll(getAi(partitionG,j));
             HTag = ProcedureSC(G,partitionC,sigma(j),delta(j),partitionCTag, partitionR);
             H.addAllEdges(HTag.getEdges());
         }
         partitionR.addAll(getAi(partitionG,J));
         SpannedCluster[] spClusterToArr = partitionR.toArray(new SpannedCluster[partitionR.size()]);
         for (int i=0; i<partitionR.size();i++){
             for (int j=i+1; j<partitionR.size();j++){
                 Graph shortPath = G.getShortestPath(spClusterToArr[i],spClusterToArr[j]);
                 if(shortPath.numOfEdges()<= 2*delta(J)){
                     H.addVertices(shortPath.getVertices());
                     H.addAllEdges(shortPath.getEdges());
                 }
             }
         }
         return H;
    }
    public static Graph downPart( Graph G, Set<SpannedCluster> partitionG){//creates the partition
        System.out.println("Down_Part");
        Cluster vertexSetU = new Cluster("U",G.getVertices());
        Set<CenteredCluster> centeredClusterSTag = new HashSet<CenteredCluster>();
        Graph H = new Graph("DP_H");
        int n = vertexSetU.numOfVertices();
        int i=1;
        while(!(vertexSetU.numOfVertices() == 0)){
            Cluster s = new Cluster("S"+i);
            CenteredCluster shell;
            SuperVertex v = vertexSetU.getRandomVertex();
            s.addVertex(v);
            double factor = Math.pow(n,1/K);
            while (calcNeighbors(s, vertexSetU,G) >= factor*(s.numOfVertices())){
                s.addVertices(expendNeighbors(s, vertexSetU,G));
                if(vertexSetU.numOfVertices() == s.numOfVertices())
                    break;
            }
            SpannedCluster cluster = new SpannedCluster(v, s, G.getSubGraph(s));
            partitionG.add(cluster);
            shell = new CenteredCluster("Shell"+i,expendNeighbors(s, vertexSetU,G),v);
            centeredClusterSTag.add(shell);
            vertexSetU.removeAllVertices(s.getVertices());
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

    public static Graph ProcedureSC(Graph G,Set<SpannedCluster> partitionC, int sigma, double delta, Set<SpannedCluster> partitionCTag, Set<SpannedCluster> partitionR){
         System.out.println("Procedure_SC");
        Set<SpannedCluster> partitionU = new HashSet<>(partitionC);
         Graph HTag = new Graph("HTag");
         Boolean condition =true;
         while (condition){
             Iterator spundClus = partitionU.iterator();
             while (spundClus.hasNext()){
                 SpannedCluster center = (SpannedCluster) spundClus.next();
                 Set<SpannedCluster> neighbors = G.getLSpannedClusterNeighbors(center,1);
                 if(neighbors.size() >= sigma) {//Check if the neighbors group is big enough
                     Cluster allVertices = new Cluster("allVertices");
                     allVertices.addVertices(center.getVertices());
                     boolean allContained = true;

                     Iterator neighborsIter = neighbors.iterator();
                     while (neighborsIter.hasNext()) {//check if neighbors are contained in U
                         SpannedCluster contained = (SpannedCluster) neighborsIter.next();
                         if(partitionU.contains(contained)){
                             allVertices.addVertices(contained.getVertices());
                         }else{
                             neighbors.remove(contained);
                             allContained = false;
                         }
                     }
                     if(allContained||(neighbors.size() >= sigma)){
                         SpannedCluster addToCTag = new SpannedCluster(center, neighbors,G);
                         partitionCTag.add(addToCTag);
                         partitionU.removeAll(neighbors);
                         HTag.addVertices(allVertices.getVertices());
                         HTag.addAllEdges(addToCTag.getEdges());
                         break;
                     }
                 }
             }
             condition = false;
         }
        partitionR = partitionU;
         SpannedCluster[] spClusterToArr = partitionR.toArray(new SpannedCluster[partitionR.size()]);
         for (int i=0; i<partitionR.size();i++){
             for (int j=i+1; j<partitionR.size();j++){
                 Graph shortPath = G.getShortestPath(spClusterToArr[i],spClusterToArr[j]);
                 if(shortPath.numOfEdges()<= 2*delta){
                    HTag.addVertices(shortPath.getVertices());
                    HTag.addAllEdges(shortPath.getEdges());
                 }
             }
         }
         return HTag;
    }
    public static Set<SuperVertex> expendNeighbors(Cluster s, Cluster vertexSetU, Graph G){//ToDo: change to private
        Set<SuperVertex> neighbors = new HashSet<SuperVertex>();
        neighbors = G.getNeighbors(s.getVertices());
        neighbors.addAll(s.getVertices());
        neighbors.retainAll(vertexSetU.getVertices());
        return neighbors;
    }
    public static int calcNeighbors(Cluster s, Cluster vertexSetU, Graph G){//ToDo: change to private
        Set<SuperVertex> neighbors = expendNeighbors(s, vertexSetU, G);
        //Set<SuperVertex> neighbors = new HashSet<SuperVertex>();
        //neighbors = G.getNeighbors(s.getVertices());
        //neighbors.addAll(s.getVertices());
        //neighbors.retainAll(vertexSetU);
        return neighbors.size();
    }
    public static Set<SpannedCluster> getAi(Set<SpannedCluster> g, int j){
        Set<SpannedCluster> res = new HashSet<SpannedCluster>();
        Iterator iter = g.iterator();
        while (iter.hasNext()){
            SpannedCluster s = (SpannedCluster) iter.next();
            if((s.getRadius() <= (Math.pow(2,j)-1))&&(s.getRadius()>= (Math.pow(2,j+1)-2)))
                res.add(s);
        }
        return res;
    }
}
