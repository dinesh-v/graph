package com.ds.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    private Graph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph<>(false);
        graph.addEdge("A", "B");
        graph.addEdge("A", "S");
        graph.addEdge("S", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "F");
        graph.addEdge("C", "E");
        graph.addEdge("E", "H");
        graph.addEdge("F", "G");
        graph.addEdge("S", "G");
        graph.addEdge("G", "H");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void depthFirstTraversal() throws Exception {
        List<String> expectedDepthFirstOrder = Arrays.asList("A", "B", "S", "C", "D", "E", "H", "G", "F");
        List<String> actualDepthFirstOrder = graph.depthFirstTraversal("A");

        System.out.println("Graph's Adjacency list:");
        System.out.println(graph);
        System.out.println("Depth First Traversal:");
        System.out.println(actualDepthFirstOrder);

        assertEquals(expectedDepthFirstOrder, actualDepthFirstOrder);
    }

    @Test
    public void breadthFirstTraversal() throws Exception {
        List<String> expectedBreadthFirstOrder = Arrays.asList("A", "B", "S", "C", "G", "D", "E", "F", "H");
        List<String> actualBreadthFirstOrder = graph.breadthFirstTraversal("A");
        System.out.println("Breadth First Traversal:\n" + actualBreadthFirstOrder);
        assertEquals(expectedBreadthFirstOrder, actualBreadthFirstOrder);
    }

    @Test
    public void dijkstraFindShortestPath() throws Exception {
        Graph<String> graph = new Graph<>(false);
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 1);
        graph.addEdge("B", "D", 2);
        graph.addEdge("D", "E", 1);
        graph.addEdge("B", "E", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("C", "E", 5);


        Map<String, Edge<String>> actualShortestPath = graph.dijkstraShortestPath("A");

        Map<String, Edge<String>> expectedShortestPath = new TreeMap<>();
        expectedShortestPath.put("A", new Edge<>("A", 0));
        expectedShortestPath.put("B", new Edge<>("D", 3));
        expectedShortestPath.put("C", new Edge<>("E", 7));
        expectedShortestPath.put("D", new Edge<>("A", 1));
        expectedShortestPath.put("E", new Edge<>("D", 2));

        assertEquals(expectedShortestPath, actualShortestPath);

    }
}