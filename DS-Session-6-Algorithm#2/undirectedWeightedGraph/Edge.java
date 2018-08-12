package undirectedWeightedGraph;

public class Edge {
    private int firstNode;
    private int secondNode;
    private int weight;
    
    public Edge(int firstNode,int secondNode,int weight)
    {
        this.firstNode=firstNode;
        this.secondNode=secondNode;
        this.weight=weight;
    }

    public int getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(int firstNode) {
        this.firstNode = firstNode;
    }

    public int getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(int secondNode) {
        this.secondNode = secondNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
