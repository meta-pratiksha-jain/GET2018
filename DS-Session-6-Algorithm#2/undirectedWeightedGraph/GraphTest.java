package undirectedWeightedGraph;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class GraphTest {
    Graph graph;

    //test cases for isConnected()
    @Test
    public void testisConnectedShouldReturnTrueWhenGraphConnected() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        boolean isConnected=graph.isConnected();
        assertEquals(true,isConnected);
    }
    
    @Test
    public void testisConnectedShouldReturnFalseWhenGraphNotConnected() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        boolean isConnected=graph.isConnected();
        assertEquals(false,isConnected);
    }
    
    //test cases for getListOfReachableNode()
    @Test
    public void testgetReachableNodeShouldReturnListOfReachableNodeWhenAllNodesAreReachable() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        List<Integer> actualOutput=graph.getReachableNodes(1);
        Collections.sort(actualOutput);
        int[] expectedOutput= {1,2,3,4,5};
        for(int i=0;i<expectedOutput.length;i++)
        {
            assertEquals(expectedOutput[i],(int)actualOutput.get(i));
        }
    }
    
    @Test
    public void testgetReachableNodeShouldReturnListOfReachableNodeWhenSomeNodesAreReachable() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        List<Integer> actualOutput=graph.getReachableNodes(1);
        Collections.sort(actualOutput);
        int[] expectedOutput= {1,2,4,5};
        for(int i=0;i<expectedOutput.length;i++)
        {
            assertEquals(expectedOutput[i],(int)actualOutput.get(i));
        }
    }
    
    @Test(expected=AssertionError.class)
    public void testgetReachableNodeShouldThrowExceptionWhenNodeNotExist() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.getReachableNodes(6);
        
    }
    
    //test cases for getMinimumSpanningTree()
    @Test
    public void testgetMSTShouldReturnListOfEdgesInMST() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        List<Edge> actualOutput=graph.getMinimumSpanningTree();
        for(Edge edge:actualOutput)
        {
            System.out.println(edge.getFirstNode()+" "+edge.getSecondNode()+" "+edge.getWeight());
        }
    }
    
    //test cases for getShortestPath()
    @Test
    public void testgetShortestPathShouldReturnShortestPath() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        List<Integer> actualOutput=graph.getShortestPath(1, 4);
        int[] expectedOutput= {1,2,4};
        for(int i=0;i<expectedOutput.length;i++)
        {
            assertEquals(expectedOutput[i],(int)actualOutput.get(i));
        }
    }
    
    @Test(expected=AssertionError.class)
    public void testgetShortestPathShouldThrowExceptionWhenNodeNotExist() {
        graph=new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.getReachableNodes(6);
        
    }

}