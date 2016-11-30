package com.ds.graph;

public class Edge<V> {
    private V vertex;
    private int weight;

    public Edge(V vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public V getVertex() {
        return vertex;
    }

    public void setVertex(V vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "( " + vertex + ", " + weight + " )";
    }
}
