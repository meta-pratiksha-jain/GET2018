package undirectedWeightedGraph;

import java.util.*;

public interface IGraph {
    
    /**
     * Checks whether graph is connected or not
     * @return returns true if graph is connected otherwise false.
     */
    public boolean isConnected();
    
    /**
     * Gives list of reachable nodes from a vertex of graph
     * @param vertex
     * @return returns list of reacheble node from vertex
     */
    public List<Integer> getListOfReachableNode(int vertex);
    
    /**
     * Gives list Of edges of minimum spanning tree of a graph
     * @return returns minimum spanning tree.
     */
    public List<Edge> getMinimumSpanningTree();
    
    /**
     * finds shortest path to reach from one vertex to another in graph
     * @param source 
     * @param destination
     * @return returns list of nodes containing shortest path
     */
    public List<Integer> getShortestPath(int source,int destination);

}
