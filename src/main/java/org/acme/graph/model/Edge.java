package org.acme.graph.model;

import javax.validation.constraints.Null;

/**
 * 
 * Un arc matérialisé par un sommet source et un sommet cible
 * 
 * @author MBorne
 *
 */
public class Edge {
	/**
	 * Identifiant de l'arc
	 */
	private String id;

	/**
	 * Sommet initial
	 */
	private Vertex source;

	/**
	 * Sommet final
	 */
	private Vertex target;
	
	public Edge(String id, Vertex source, Vertex target) throws IllegalArgumentException {
		if (id == null || source == null || target == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.source = source;
		this.target = target;
	}

	public Edge(Vertex source, Vertex target) throws IllegalArgumentException {
		if (source == null || target == null) {
			throw new IllegalArgumentException();
		}
		this.source = source;
		source.addOutEdge(this);

		this.target = target;
		target.addInEdge(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws IllegalArgumentException {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) throws IllegalArgumentException {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		this.source = source;
	}

	public Vertex getTarget() {
		return target;
	}

	public void setTarget(Vertex target) throws IllegalArgumentException {
		if (target == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
	}

	/**
	 * dijkstra - coût de parcours de l'arc (distance géométrique)
	 * 
	 * @return
	 */
	public double getCost() {
		return source.getCoordinate().distance(target.getCoordinate());
	}

	@Override
	public String toString() {
		return id + " (" + source + "->" + target + ")";
	}

}
