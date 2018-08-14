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
    }

    @Override
    public boolean isConnected() {
        boolean isConnected=true;
        boolean[] isVisited=new boolean[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            isVisited[i]=false;
        }
        depthFirstSearch(1,isVisited);
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
    private void depthFirstSearch(int vertex,boolean[] isVisited)
    {
        isVisited[vertex-1]=true;
        for(Edge edge:arrayOfListOfEdges[vertex-1])
        {
            int destinationVertexOFEdge=edge.getSecondNode();
            boolean isDestinationVisited=isVisited[destinationVertexOFEdge-1];
            //if destination vertex is not visited then dFS is recursively called for that vertex.
            if(!isDestinationVisited)
            {
                depthFirstSearch(destinationVertexOFEdge,isVisited);
            }
        }
    }
    
    @Override
    public List<Integer> getReachableNodes(int vertex)
    {
        if(vertex>numberOfVertices)
        {
            throw new AssertionError("node doesn't exist in graph");
        }
        List<Integer> listOfReachableNode=new ArrayList<Integer>();
        boolean[] isVisited=new boolean[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
        {
            isVisited[i]=false;
        }
        depthFirstSearch(vertex,isVisited);
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
        if(source>numberOfVertices || destination>numberOfVertices)
        {
            throw new AssertionError("source or destination doesn't exist in graph");
        }
        List<Integer> shortestPath=new ArrayList<Integer>();
        boolean[] isVisited=new boolean[numberOfVertices];
        //distanceParentTable is 2D array whose 1st column contains minimum distance and 2nd column contains parent of node.
        int[][] distanceParentTable=new int[numberOfVertices][2];
        //initialize distance with infinity
        for(int i=0;i<numberOfVertices;i++)
        {
            distanceParentTable[i][0]=Integer.MAX_VALUE;
        }
        distanceParentTable[source-1][0]=0;
        setDistanceParentTable(source, isVisited, distanceParentTable);
        int currentNode=destination;
        while(currentNode!=source)
        {
            shortestPath.add(currentNode);
            currentNode=distanceParentTable[currentNode-1][1];
        }
        shortestPath.add(currentNode);
        Collections.reverse(shortestPath);
        return shortestPath;

    }
    
    /**
     * private method to set distanceParentTable with minimum distance of all nodes from source using Dijkstra algorithm.
     * @param currentNode contains current node which is traversed.
     * @param isVisited
     * @param distanceParentTable
     */
    private void setDistanceParentTable(int currentNode,boolean[] isVisited,int[][] distanceParentTable)
    {
        int minimumDistance=distanceParentTable[currentNode-1][0];
        for(Edge edge:arrayOfListOfEdges[currentNode-1])
        {
            //set distanceParentTable with minimum distance of adjacent nodes of
            int currentDestination=edge.getSecondNode();
            int currentDistance=edge.getWeight()+minimumDistance;
            if(distanceParentTable[currentDestination-1][0]>currentDistance)
            {
                distanceParentTable[currentDestination-1][0]=currentDistance;
                distanceParentTable[currentDestination-1][1]=currentNode;
            }
        }
        isVisited[currentNode-1]=true;
        currentNode=getMinimumDistanceNode(distanceParentTable, isVisited);
        for(int i=0;i<isVisited.length;i++)
        {
            //recursive call to function if any node is not visited.
            if(!isVisited[i])
            {
                setDistanceParentTable(currentNode, isVisited, distanceParentTable);
            }
        }
        
    }
    
    /**
     * private method to get node with minimum distance distanceParentTable
     * @param distanceParentTable
     * @param isVisited
     * @return returns node
     */
    private int getMinimumDistanceNode(int[][] distanceParentTable,boolean[] isVisited)
    {
        int node=0;
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<distanceParentTable.length;i++)
        {
            if(minimum>distanceParentTable[i][0] && !isVisited[i])
            {
                minimum=distanceParentTable[i][0];
                node=i+1;
            }
        } 
        return node;
    }

}