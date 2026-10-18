public class MyEdge {

    int id;
    int weight;

    public MyEdge(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return id + " " + weight;
    }

}
