public class SuperVertex extends Vertex {
    protected SpannedCluster sc;

    public SuperVertex(int id){
        super(id);
    }

    public SuperVertex(int id, String name){
        super(id, name);
    }

    public SuperVertex clone(){
        return new SuperVertex(this.getId(), this.getName(),this.getDegree());
    }

    public SuperVertex(int id, String name, int degree){
        super(id, name, degree);
    }


    public SpannedCluster getSpannedCluster() {
        return sc;
    }

    public void setSpannedCluster(SpannedCluster upDete) {
        try {
            if (upDete.containsVertex(this))
                this.sc = upDete;
            else throw new InputException("the Spanned Cluster:"+ upDete+" not contains this Vertex:"+this);
        }
        catch (InputException e){
            System.out.println("the Spanned Cluster:"+ upDete+" not contains this Vertex:"+this);
        }
    }

    public void initSpannedCluster(){
        this.sc = null;
    }
}
