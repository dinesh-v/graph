package com.ds.graph.algorithm;

import com.ds.graph.Edge;
import com.ds.graph.Graph;

import java.util.ArrayList;
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

    public Edge<V> getShortestPath(V vertex) {
        return shortestPath.get(vertex);
    }

    private void updateShortestPath(V vertex, Edge<V> edge) {
        if (shortestPath.containsKey(vertex) && edge != null) {
            shortestPath.remove(vertex);
            shortestPath.put(vertex, edge);
        }
    }

    public void setShortestPath(Map<V, Edge<V>> shortestPath) {
        this.shortestPath = shortestPath;
    }


    public Dijkstra(Graph<V> graph, V startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
        this.shortestPath = new HashMap<V, Edge<V>>();
    }

    public void findShortestPath() {
        int spTotalWeight = 0;
        V spParentVertex = null;
        for (V vertex : graph.getAdjacencyList().keySet()) {
            if (!vertex.equals(startVertex)) { // Start vertex and current vertex are not same. So calculate shortest path
                if (shortestPath.containsKey(vertex)) {
                    Edge<V> currentVertex = shortestPath.get(vertex);
                    if (startVertex.equals(currentVertex.getVertex())) {
                        spParentVertex = null;
                        spTotalWeight = 0;
                    } else {
                        spParentVertex = currentVertex.getVertex();
                        spTotalWeight = currentVertex.getWeight();
                        calculateShortestPath(vertex);
                    }
                } else {
                    calculateShortestPath(vertex);
                }
            } else { // Start vertex and current vertex are same
                updateShortestPath(vertex, new Edge<V>(null, 0));
            }
        }
    }

    /**
     * TODO: Write recursive method to calculate shortest path.
     */
    private void calculateShortestPath(V vertex) {
        ArrayList<Edge<V>> adjacentVertices = graph.getAdjacentVertices(vertex);
        for (Edge<V> edge : adjacentVertices) {
            if (!shortestPath.containsKey(edge.getVertex())) { // Calculate shortest path from A
                calculateShortestPath(edge.getVertex());
            }
        }
    }
}
