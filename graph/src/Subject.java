public class Subject {
    private Graph originalGraph;
    private  Graph graphSpanner;
    private double ProbabilityInSubGraph;
    private double ProbabilityBetweenSubGraph;
    private double k;
    private double epsilon;

    public Subject(Graph originalGraph, Graph graphSpanner, double ProbabilityInSubGraph, double ProbabilityBetweenSubGraph, double k, double epsilon){
        this.originalGraph = originalGraph;
        this.graphSpanner = graphSpanner;
        this.ProbabilityInSubGraph = ProbabilityInSubGraph;
        this.ProbabilityBetweenSubGraph = ProbabilityBetweenSubGraph;
        this.k = k;
        this.epsilon = epsilon;
    }


}
