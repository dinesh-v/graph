package com.ds.graph.algorithm;

import com.ds.graph.Edge;
import com.ds.graph.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * To find the shortest path of all the vertices in a graph where all edges have weight in whole numbers.
 * Starting vertex should be specified for calculating the shortest path.
 */
public class Dijkstra<V> {
    private Graph<V> graph;
    private V startVertex;
    private Map<V, Edge<V>> shortestPath;

    public Dijkstra(Graph<V> graph, V startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
        this.shortestPath = new HashMap<V, Edge<V>>();
    }

    public void findShortestPath() {
        int spTotalWeight = 0;
        V spParentVertex = null;
        for (V vertex : graph.getAdjacencyList().keySet()) {
            if (shortestPath.containsKey(vertex)) {
                Edge<V> currentVertex = shortestPath.get(vertex);
                if (startVertex.equals(currentVertex.getVertex())) {
                    spParentVertex = null;
                    spTotalWeight = 0;
                } else {
                    spParentVertex = currentVertex.getVertex();
                    spTotalWeight = currentVertex.getWeight();
                    calculateShortestPath();
                }
            } else {
                calculateShortestPath();
            }
        }
    }

    /**
     * TODO: Write recursive method to calculate shortest path.
     */
    private void calculateShortestPath() {

    }
}
