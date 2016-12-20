package com.ds.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {
    Graph<String> graph;

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
        System.out.println(graph);
        Collection<String> listOne = new ArrayList<String>(Arrays.asList("A", "B", "B", "C", "D"));
        Collection<String> listTwo = new ArrayList<String>(Arrays.asList("A", "B", "B"));
        listOne.removeAll(listTwo);
        System.out.println(listOne.size());
        System.out.println(listOne);
        System.exit(0);
        List<String> expectedDepthFirstOrder = new ArrayList<String>(Arrays.asList("A"));
        assertEquals(graph.depthFirstTraversal("A"), expectedDepthFirstOrder);
    }

}