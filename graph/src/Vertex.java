public class Vertex {
    protected int id;
    protected String name;
    protected int degree = 0;
    public Vertex(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Vertex(int id){
        this.id = id;
        this.name = null;
    }
    private Vertex(int id, String name, int degree){
        this.id = id;
        this.name = name;
        this.degree = degree;
    }
    public Vertex clone(){
        return new Vertex(this.getId(), this.getName(),this.getDegree());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
         this.name = name;
    }
    public int getDegree(){
        return degree;
    }
    public void increaseDegree(){
        degree++;
    }
    public void decreaseDegree(){
        degree--;
    }

    public String toString() {
        if (name == null)
            return "v"+this.getId();
        else
            return "("+this.getName()+")"+"v"+this.getId();
    }
    public boolean equals(Vertex otherVertex){
        return this.getId()== otherVertex.getId();
    }
}
