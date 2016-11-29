package com.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<V> {
    private boolean isDirected = false;

    public HashMap<V, ArrayList<Edge<V>>> getAdjacencyList() {
        return adjacencyList;
    }

    private HashMap<V, ArrayList<Edge<V>>> adjacencyList;

    Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.adjacencyList = new HashMap<V, ArrayList<Edge<V>>>();
    }

    boolean addEdge(V sourceVertex, V destinationVertex, int weight) {
        persistVertex(sourceVertex, destinationVertex, weight);
        if (!isDirected) {
            persistVertex(destinationVertex, sourceVertex, weight);
        }
        return true;
    }

    private void persistVertex(V sourceVertex, V destinationVertex, int weight) {
        ArrayList<Edge<V>> adjacentVertex;
        if (!doesVertexExist(sourceVertex)) {
            adjacentVertex = new ArrayList<Edge<V>>();
            adjacentVertex.add(new Edge<V>(destinationVertex, weight));
            adjacencyList.put(sourceVertex, adjacentVertex);
        } else {
            adjacentVertex = adjacencyList.get(sourceVertex);
            adjacentVertex.add(new Edge<V>(destinationVertex, weight));
        }
    }

    private boolean doesVertexExist(V vertex) {
        return adjacencyList.containsKey(vertex);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (V vertex : adjacencyList.keySet()) {
            stringBuilder.append(vertex).append(" : ").append(adjacencyList.get(vertex)).append("\n");
        }
        return stringBuilder.toString();
    }
}


