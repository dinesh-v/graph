package com.ds.graph;

/**
 * Graph data structure implementation in Java
 */
public class App {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<String>(false);
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 12);
        graph.addEdge("A", "D", 7);
        graph.addEdge("C", "B", 1);
        graph.addEdge("B", "L", 4);
        graph.addEdge("W", "F", 4);
        graph.addEdge("Z", "F", 4);
        graph.addEdge("Z", "R", 5);
        graph.addEdge("D", "C", 1);
        graph.addEdge("F", "D", 1);
        graph.addEdge("W", "L", 1);
        System.out.println(graph);
        graph.depthFirstTraversal("A");
        //graph.breadthFirstTraversal(null);


        /*Dijkstra<String> dijkstra = new Dijkstra<String>(graph, "A");
        dijkstra.findShortestPath();*/
    }
}
