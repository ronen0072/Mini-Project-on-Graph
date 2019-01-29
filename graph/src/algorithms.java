
public class algorithms {
    public void dijkstra(Graph g) {
        int verticesCount = g.numOfVertices();
        double[] wt = new double[verticesCount];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = Double.MAX_VALUE;
        }
        wt[0] = 0.0;
        Edge[] fr  = new Edge[verticesCount];
        Edge[] mst = new Edge[verticesCount];
        int min = -1;
        Edge edge = null;
        for (int v = 0; min != 0; v = min) {
            min = 0;
            for (int w = 1; w < verticesCount; w++) {
                if (mst[w] == null) {
                    double P = 0.0;
                    edge = g.getEdge(g.getVertex(v), g.getVertex(v));
                    if (edge != null) {
                        if ((P = wt[v] + edge.getWeight()) < wt[w]) {
                            wt[w] = P;
                            fr[w] = edge;
                        }
                    }

                    if (wt[w] < wt[min]) {
                        min = w;
                    }
                }
            }

            if (min != 0) {
                mst[min] = fr[min];
            }
        }

        for (int v = 0; v < verticesCount; v++) {
            if (mst[v] != null) {
                System.out.print(mst[v].getSourceVertex() + "->" + mst[v].getTargetVertex() + " ");
            }
        }
    }
}
