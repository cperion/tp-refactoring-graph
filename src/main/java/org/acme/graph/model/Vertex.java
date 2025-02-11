package org.acme.graph.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graphe
 * 
 * @author MBorne
 *
 */
public class Vertex {

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;

	/**
	 * dijkstra - coût pour atteindre le sommet
	 */
	private double cost;
	/**
	 * dijkstra - arc entrant avec le meilleur coût
	 */
	private Edge reachingEdge;
	/**
	 * dijkstra - indique si le sommet est visité
	 */
	private boolean visited;

	private ArrayList<Edge> inEdges = new ArrayList<Edge>();

	private ArrayList<Edge> outEdges = new ArrayList<Edge>();

	public Vertex() {

	}

	public Vertex(Coordinate coordinate, String id) {
		this.coordinate = coordinate;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public Edge getReachingEdge() {
		return reachingEdge;
	}

	public void setReachingEdge(Edge reachingEdge) {
		this.reachingEdge = reachingEdge;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return id;
	}

	@JsonIgnore
	public ArrayList<Edge> getInEdges() {
		return inEdges;
	}
	
	@JsonIgnore
	public ArrayList<Edge> getOutEdges() {
		return outEdges;
	}

	public void addInEdge(Edge edge) {
		inEdges.add(edge);
	}

	public void addOutEdge(Edge edge) {
		outEdges.add(edge);
	}

}
