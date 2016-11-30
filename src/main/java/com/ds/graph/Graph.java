package com.ds.graph;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph<V> {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private boolean isDirected = false;
    private TreeMap<V, ArrayList<Edge<V>>> adjacencyList;

    Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.adjacencyList = new TreeMap<V, ArrayList<Edge<V>>>();
    }

    public TreeMap<V, ArrayList<Edge<V>>> getAdjacencyList() {
        return adjacencyList;
    }

    public ArrayList<Edge<V>> getAdjacentVertices(V vertex) {
        return adjacencyList.get(vertex);
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

        Collections.sort(adjacencyList.get(sourceVertex), new Comparator<Edge<V>>() {
            public int compare(Edge<V> edge1, Edge<V> edge2) {
                if (edge1.getVertex() instanceof Integer) {
                    return ((Integer) edge1.getVertex()) - ((Integer) edge2.getVertex());
                } else if (edge1.getVertex() instanceof String) {
                    return ((String) edge1.getVertex()).compareTo((String) edge2.getVertex());
                }
                return 0;
            }
        });
    }

    private boolean doesVertexExist(V vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Depth first traversal
     * <a href="https://www.youtube.com/watch?v=iaBEKo5sM7w&t=27s">Depth First Search Algorithm</a>
     *
     * @param startingVertex Identity of a vertex from the traversal must start
     */
    void depthFirstTraversal(V startingVertex) {
        List<V> visitedVertex = new LinkedList<V>();
        Stack<V> stack = new Stack<V>();
        if (adjacencyList.containsKey(startingVertex) && startingVertex != null) {
            stack.push(startingVertex);
            visitedVertex.add(startingVertex);
            // Get adjacent vertices of startingVertex Ex: A
            ArrayList<Edge<V>> adjacentVertices = adjacencyList.get(startingVertex);
            // Visit adjacent vertices in alphabetical order. It would be better if adjacent vertices are stored in sorted order.
            // TODO: Recode storing logic of adjacent vertices in addEdge() method.


        } else {
            // TODO: Throw custom exception
            logger.log(Level.SEVERE, "Starting vertex should be specified");
        }

    }

    /**
     * Breadth first traversal
     * <a href="https://www.youtube.com/watch?v=QRq6p9s8NVg">Breadth First Search Algorithm</a>
     *
     * @param startingVertex Identity of a vertex from the traversal must start
     */
    public void breadthFirstTraversal(V startingVertex) {

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

