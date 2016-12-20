package com.ds.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    private Graph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph<String>(false);
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

        System.out.println("Graph Adjacency list:");
        System.out.println(graph);
        System.out.println("Depth First Traversal:");
        System.out.println(actualDepthFirstOrder);

        assertEquals(expectedDepthFirstOrder, actualDepthFirstOrder);
    }
}