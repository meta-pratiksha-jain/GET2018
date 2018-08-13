package undirectedWeightedGraph;

import java.util.*;

/**
 * This class implements IGraph Interface using adjacency list representation. 
 * This class represents undirected weighted graph.
 */
public class Graph implements IGraph {
    public int numberOfVertices;
    private List<Edge>[] arrayOfListOfEdges;
    private List<Edge> listOfEdgesInMST;
    private List<Edge> listOfTotalEdges;
    
    /**
     * constructor
     * @param numberOfVertices
     */
    public Graph(int numberOfVertices)
    {
        this.numberOfVertices=numberOfVertices;
        arrayOfListOfEdges=new LinkedList[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            arrayOfListOfEdges[i]=new LinkedList<Edge>();
        }
        listOfEdgesInMST=new ArrayList<>();
        listOfTotalEdges=new ArrayList<>();
    }
    
    /**
     * adds an edge to the graph
     * @param firstVertex 
     * @param secondVertex
     * @param weight contains weight of edge.
     */
    public void addEdge(int firstVertex,int secondVertex,int weight)
    {
        Edge edge=new Edge(firstVertex,secondVertex,weight);
        arrayOfListOfEdges[firstVertex-1].add(edge);
        listOfTotalEdges.add(edge);
    }

    @Override
    public boolean isConnected() {
        boolean isConnected=true;
        boolean[] isVisited=new boolean[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            isVisited[i]=false;
        }
        dFS(1,isVisited);
        for(int i=0;i<numberOfVertices;i++)
        {
            //if all vertices are visited then graph is connected.
            if(isVisited[i]==false)
            {
                isConnected=false;
                return isConnected;
            }
        }
        return isConnected;
    }
    
    /**
     * private helper method to check whether graph is connected or not.It traverses graph using depth first search algorithm.
     * @param vertex contains vertex from which dfs to be started.
     * @param isVisited contains boolean array which keep track of vertices whether they are visited or not.
     */
    private void dFS(int vertex,boolean[] isVisited)
    {
        isVisited[vertex-1]=true;
        for(Edge edge:arrayOfListOfEdges[vertex-1])
        {
            int destinationVertexOFEdge=edge.getSecondNode();
            boolean isDestinationVisited=isVisited[destinationVertexOFEdge-1];
            //if destination vertex is not visited then dFS is recursively called for that vertex.
            if(!isDestinationVisited)
            {
                dFS(destinationVertexOFEdge,isVisited);
            }
        }
    }
    
    @Override
    public List<Integer> getListOfReachableNode(int vertex)
    {
        List<Integer> listOfReachableNode=new ArrayList<Integer>();
        boolean[] isVisited=new boolean[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            isVisited[i]=false;
        }
        dFS(vertex,isVisited);
        for(int i=0;i<numberOfVertices;i++)
        {
            if(isVisited[i])
            {
                listOfReachableNode.add(i+1);
            }
                
        }
        return listOfReachableNode;
    }

    @Override
    public List<Edge> getMinimumSpanningTree() {
        boolean[] isVisited=new boolean[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            isVisited[i]=false;
        }
        getMSTUsingPrim(1,new LinkedList(),isVisited);
        return listOfEdgesInMST;
    }
    
    /**
     * private helper method to find minimum spanning tree using Prim's algorithm.
     * @param vertex 
     * @param listOfTemporaryEdges contains list of edges that should traversed.
     * @param isVisited
     */
    private void getMSTUsingPrim(int vertex,List<Edge> listOfTemporaryEdges,boolean[] isVisited)
    {
        isVisited[vertex-1]=true;
        List<Edge> listOfAdjacentEdges=arrayOfListOfEdges[vertex-1];
        //adjacent edges of vertex are added to the temporary list of edges
        for(Edge edge:listOfAdjacentEdges)
        {
            int destination=edge.getSecondNode();
            if(!isVisited[destination-1])
            {
                listOfTemporaryEdges.add(edge);
            }
        }
        Edge currentEdge=listOfTemporaryEdges.get(0);
        int mininmumWeight=Integer.MAX_VALUE;
        //finds edge with minimum weight and not exist in listOfEdgesInMST
        for(Edge edge:listOfTemporaryEdges)
        {
            int currentWeight=edge.getWeight();
            boolean isMSTContainEdge=listOfEdgesInMST.contains(edge);
            if(mininmumWeight>currentWeight && !isMSTContainEdge)
            {
                mininmumWeight=currentWeight;
                currentEdge=edge;
            }
        }
        int destinationOfCurrent=currentEdge.getSecondNode();
        if(!isVisited[destinationOfCurrent-1])
        {
            listOfEdgesInMST.add(currentEdge);
            listOfTemporaryEdges.remove(currentEdge);
        }
        for(int i=0;i<isVisited.length;i++)
        {
            //recursive call to function if any node is not visited.
            if(!isVisited[i])
            {
                getMSTUsingPrim(destinationOfCurrent, listOfTemporaryEdges, isVisited);
            }
        }
    }

    @Override
    public List<Integer> getShortestPath(int source, int destination) {
        /**List<Integer> shortestPath=new ArrayList<Integer>();
        boolean[] isVisited=new boolean[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            isVisited[i]=false;
        }
        HashMap<Integer,Integer> mapOfDistanceFromSource=new HashMap<Integer,Integer>();
        mapOfDistanceFromSource.put(source, 0);
        int currentNode=source;
        while(currentNode!=destination)
        {
            int minimumDistance=Integer.MAX_VALUE;
            int temporaryNode=currentNode;
            for(Map.Entry<Integer, Integer> entry:mapOfDistanceFromSource.entrySet())
            {
                int currentDistance=entry.getValue();
                if(minimumDistance>currentDistance && !isVisited[currentNode-1])
                {
                    minimumDistance=currentDistance;
                    temporaryNode=entry.getKey();
                }
            }
            currentNode=temporaryNode;
            isVisited[currentNode-1]=true;
            mapOfDistanceFromSource.remove(currentNode);
            shortestPath.add(currentNode);
            for(Edge edge:listOfTotalEdges)
            {
                if(currentNode==edge.getFirstNode() && !isVisited[edge.getSecondNode()-1])
                {
                    mapOfDistanceFromSource.put(edge.getSecondNode(), edge.getWeight());
                }
                else if(currentNode==edge.getSecondNode && !isVisited[edge.getFirstNode()-1])
                {
                    mapOfDistanceFromSource.put(edge.getFirstNode(), edge.getWeight());
                }
            }
            return shortestPath
        }**/
    }

}
