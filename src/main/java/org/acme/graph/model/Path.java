package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;


public class Path {

    private List<Edge> edges;

    public Path() {
        this.edges = new ArrayList<Edge>();
    }

    public Path(List<Edge> edges) {
        if (edges == null) {
            this.edges = new ArrayList<Edge>();
        } else {
            this.edges = edges;
        }
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int size() {
        return edges.size();
    }

    public Edge get(int i) {
        return edges.get(i);
    }
    
}
