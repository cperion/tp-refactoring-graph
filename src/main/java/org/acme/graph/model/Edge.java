package org.acme.graph.model;

import javax.validation.constraints.Null;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

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

	private Geometry geometry;


	
	Edge(String id, Vertex source, Vertex target) throws IllegalArgumentException {
		if (id == null || source == null || target == null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.source = source;
		this.target = target;


	}

	Edge(Vertex source, Vertex target) throws IllegalArgumentException {
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

	@JsonIdentityInfo
	(
	generator=ObjectIdGenerators.PropertyGenerator.class, 
	property="id"
    )
    @JsonIdentityReference(alwaysAsId=true)
	public Vertex getSource() {
		return source;
	}


	@JsonIdentityInfo
	(
	generator=ObjectIdGenerators.PropertyGenerator.class, 
	property="id"
    )
    @JsonIdentityReference(alwaysAsId=true)
	public Vertex getTarget() {
		return target;
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

	 @JsonSerialize(using = GeometrySerializer.class)
    public LineString getGeometry() {
        GeometryFactory gf = new GeometryFactory();
        return (LineString)gf.createLineString(new Coordinate[] {
            getSource().getCoordinate(),
            getTarget().getCoordinate()
        });
    }

}
